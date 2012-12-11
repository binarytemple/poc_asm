package ie.hunt;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.*;

import java.io.File;

public class ScratchSampleDAODumperMain implements Opcodes {

    public static void main(String[] args) throws Exception {
        byte[] data = ScratchSampleDAODumperMain.dump();
        FileUtils.writeByteArrayToFile(new File("/tmp/ScratchSampleDao.class"), data);
    }

    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;
        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "ie/hunt/sample/ScratchSampleDAO", null, "java/lang/Object", null);
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
            mv = cw.visitMethod(ACC_PUBLIC, "getName", "(I)Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitLdcInsn("dawg!");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getNameButDelegating", "(I)Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitLdcInsn("ScratchSampleDAO:getNameButDelegating:id");
            mv.visitMethodInsn(INVOKESTATIC, "ie/hunt/sample/SampleSingleton", "fetchFromCache", "(Ljava/lang/Object;)Lie/hunt/sample/CondRet;");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "ie/hunt/sample/CondRet", "o", "Ljava/lang/Object;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNULL, l0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "ie/hunt/sample/CondRet", "o", "Ljava/lang/Object;");
            mv.visitTypeInsn(CHECKCAST, "java/lang/String");
            mv.visitInsn(ARETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"ie/hunt/sample/CondRet"}, 0, null);
            mv.visitLdcInsn("dave");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKESTATIC, "ie/hunt/sample/SampleSingleton", "addToCache", "(ILjava/lang/String;)V");
            mv.visitVarInsn(ALOAD, 3);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(2, 4);
            mv.visitEnd();
        }
        cw.visitEnd();
        return cw.toByteArray();
    }
}
