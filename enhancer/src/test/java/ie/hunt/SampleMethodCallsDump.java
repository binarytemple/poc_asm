package ie.hunt;


import java.util.*;

import org.objectweb.asm.*;

public class SampleMethodCallsDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "ie/hunt/SampleMethodCalls", null, "java/lang/Object", null);

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
            mv = cw.visitMethod(ACC_PUBLIC, "getSomeValue", "(Ljava/lang/String;)I", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "enhancer/MethodKey");
            mv.visitInsn(DUP);
            mv.visitLdcInsn("SampleMethodCalls");
            mv.visitLdcInsn("getSomeValue");
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKESPECIAL, "enhancer/MethodKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKESTATIC, "enhancer/GenericCache", "getValue", "(Lenhancer/MethodKey;)Ljava/lang/Object;");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            Label l0 = new Label();
            mv.visitJumpInsn(IFNULL, l0);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
            mv.visitInsn(IRETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 2, new Object[]{"enhancer/MethodKey", "java/lang/Object"}, 0, null);
            mv.visitIntInsn(BIPUSH, 10);
            mv.visitVarInsn(ISTORE, 4);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 4);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitMethodInsn(INVOKESTATIC, "enhancer/GenericCache", "setValue", "(Lenhancer/MethodKey;Ljava/lang/Object;)V");
            mv.visitVarInsn(ILOAD, 4);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(8, 5);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
