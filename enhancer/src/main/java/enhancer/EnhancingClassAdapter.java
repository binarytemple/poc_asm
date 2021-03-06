package enhancer;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;

public class EnhancingClassAdapter extends ClassAdapter {
    private String className;
    private String methodName;

    public EnhancingClassAdapter(ClassVisitor visitor, String theClass) {
        super(visitor);
        this.className = theClass;
    }

    public MethodVisitor visitMethod(int arg,
                                     String name,
                                     String descriptor,
                                     String signature,
                                     String[] exceptions) {
        MethodVisitor mv = super.visitMethod(arg,
                name,
                descriptor,
                signature,
                exceptions);
        MethodAdapter ma = new EnhancingMethodAdapter(mv, className, name, descriptor, signature);
        return ma;
    }

}
