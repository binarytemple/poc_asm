package ie.hunt;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.*;

import java.io.File;

public class HelloWorldMainDump implements Opcodes {

    public static void main(String[] args) throws Exception {
        byte[] data = HelloWorldMainDump.dump();
        FileUtils.deleteDirectory(new File("/tmp/ie"));
        FileUtils.forceMkdir(new File("/tmp/ie/hunt"));
        FileUtils.writeByteArrayToFile(new File("/tmp/ie/hunt/HelloWorldMain.class"), data);
    }

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "ie/hunt/HelloWorldMain", null, "java/lang/Object", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Hello from HelloWorldMain");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}