package profiler;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ProfilerMain {

    public static void premain(String args, Instrumentation inst) {
        inst.addTransformer(new Transformer());
    }
}

class Transformer implements ClassFileTransformer {

    static final ConcurrentMap<String, Boolean> touched = new ConcurrentHashMap<String, Boolean>();

    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        if (touched.containsKey(className)) {
            return classfileBuffer;
        }

        // can only profile classes that will be able to see
        // the Profile class which is loaded by the application
        // classloader
        //
        if (loader != ClassLoader.getSystemClassLoader()) {
            return classfileBuffer;
        }

        // can't profile yourself
        //
        if (className.startsWith("profiler") || className.startsWith("scala")) {
            return classfileBuffer;
        }

        touched.putIfAbsent(className, true);

        ClassReader reader = new ClassReader(classfileBuffer);
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        ClassAdapter adapter = new PerfClassAdapter(writer, className);
        reader.accept(adapter, 0);
        byte[] result = writer.toByteArray();
        assert (result.length > 0);
        return result;
    }
}