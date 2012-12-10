package ie.hunt;


import java.util.*;

import org.objectweb.asm.*;

public class GenerateHelloWorld implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "ie/hunt/HelloWorld", null, "java/lang/Object", new String[]{"ie/hunt/GetMessage"});

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
            mv = cw.visitMethod(ACC_PUBLIC, "getValue", "()Ljava/lang/String;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/io/IOException");
            Label l3 = new Label();
            Label l4 = new Label();
            Label l5 = new Label();
            mv.visitTryCatchBlock(l3, l4, l5, "java/lang/Throwable");
            Label l6 = new Label();
            Label l7 = new Label();
            Label l8 = new Label();
            mv.visitTryCatchBlock(l6, l7, l8, "java/io/IOException");
            Label l9 = new Label();
            mv.visitTryCatchBlock(l3, l4, l9, null);
            Label l10 = new Label();
            mv.visitTryCatchBlock(l5, l10, l9, null);
            Label l11 = new Label();
            Label l12 = new Label();
            Label l13 = new Label();
            mv.visitTryCatchBlock(l11, l12, l13, "java/io/IOException");
            Label l14 = new Label();
            mv.visitTryCatchBlock(l9, l14, l9, null);
            mv.visitInsn(ACONST_NULL);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitLabel(l3);
            mv.visitTypeInsn(NEW, "java/net/URL");
            mv.visitInsn(DUP);
            mv.visitLdcInsn("http://binarytemple.co.uk");
            mv.visitMethodInsn(INVOKESPECIAL, "java/net/URL", "<init>", "(Ljava/lang/String;)V");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/net/URL", "openStream", "()Ljava/io/InputStream;");
            mv.visitVarInsn(ASTORE, 1);
            mv.visitTypeInsn(NEW, "java/io/InputStreamReader");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/InputStreamReader", "<init>", "(Ljava/io/InputStream;)V");
            mv.visitVarInsn(ASTORE, 4);
            mv.visitLdcInsn(1048576);
            mv.visitIntInsn(NEWARRAY, T_CHAR);
            mv.visitVarInsn(ASTORE, 5);
            Label l15 = new Label();
            mv.visitLabel(l15);
            mv.visitFrame(Opcodes.F_FULL, 6, new Object[]{"ie/hunt/HelloWorld", "java/io/InputStream", "java/net/URL", "java/lang/StringBuilder", "java/io/InputStreamReader", "[C"}, 0, new Object[]{});
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/InputStreamReader", "read", "([C)I");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ISTORE, 6);
            mv.visitInsn(ICONST_M1);
            Label l16 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l16);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ILOAD, 6);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "([CII)Ljava/lang/StringBuilder;");
            mv.visitInsn(POP);
            mv.visitJumpInsn(GOTO, l15);
            mv.visitLabel(l16);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
            mv.visitVarInsn(ASTORE, 7);
            mv.visitLabel(l4);
            mv.visitVarInsn(ALOAD, 1);
            Label l17 = new Label();
            mv.visitJumpInsn(IFNULL, l17);
            mv.visitLabel(l0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/InputStream", "close", "()V");
            mv.visitLabel(l1);
            mv.visitJumpInsn(GOTO, l17);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 8, new Object[]{"ie/hunt/HelloWorld", "java/io/InputStream", "java/net/URL", "java/lang/StringBuilder", "java/io/InputStreamReader", "[C", Opcodes.INTEGER, "java/lang/String"}, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 8);
            mv.visitVarInsn(ALOAD, 8);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");
            mv.visitLabel(l17);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 7);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l5);
            mv.visitFrame(Opcodes.F_FULL, 2, new Object[]{"ie/hunt/HelloWorld", "java/io/InputStream"}, 1, new Object[]{"java/lang/Throwable"});
            mv.visitVarInsn(ASTORE, 2);
            mv.visitInsn(ACONST_NULL);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitLabel(l10);
            mv.visitVarInsn(ALOAD, 1);
            Label l18 = new Label();
            mv.visitJumpInsn(IFNULL, l18);
            mv.visitLabel(l6);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/InputStream", "close", "()V");
            mv.visitLabel(l7);
            mv.visitJumpInsn(GOTO, l18);
            mv.visitLabel(l8);
            mv.visitFrame(Opcodes.F_FULL, 4, new Object[]{"ie/hunt/HelloWorld", "java/io/InputStream", "java/lang/Throwable", "java/lang/String"}, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 4);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");
            mv.visitLabel(l18);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l9);
            mv.visitFrame(Opcodes.F_FULL, 2, new Object[]{"ie/hunt/HelloWorld", "java/io/InputStream"}, 1, new Object[]{"java/lang/Throwable"});
            mv.visitVarInsn(ASTORE, 9);
            mv.visitLabel(l14);
            mv.visitVarInsn(ALOAD, 1);
            Label l19 = new Label();
            mv.visitJumpInsn(IFNULL, l19);
            mv.visitLabel(l11);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/InputStream", "close", "()V");
            mv.visitLabel(l12);
            mv.visitJumpInsn(GOTO, l19);
            mv.visitLabel(l13);
            mv.visitFrame(Opcodes.F_FULL, 10, new Object[]{"ie/hunt/HelloWorld", "java/io/InputStream", Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"}, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 10);
            mv.visitVarInsn(ALOAD, 10);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");
            mv.visitLabel(l19);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 9);
            mv.visitInsn(ATHROW);
            mv.visitMaxs(4, 11);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getMessage", "()Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitLdcInsn("hello world");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
