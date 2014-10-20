Comparison of Java and ASM Bytecode generating the same class (without Debug Symbols)
=====================================================================================

The Original Java Class
-----------------------
```java
package ie.hunt;

@SuppressWarnings("unused")
public class SampleMethodCalls {

    public class Human {
        private final String name;
        private final int age;
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    public int getSomeValue(int in) {
        return 10;
    }

    public int getSomeValue(int in, int in2) {
        return 10;
    }

    public String getSomeValue(String in, String  in2) {
        return "dog";
    }

    public Human getSomeValue(String name, int age) {
        return new  Human(name,age);
    }

     public Human getSomeValue(String name, Integer age) {
        return new  Human(name,age);
    }

}
```

The ASM Bytecode generator for the same Class
---------------------------------------------

```java

import java.util.*;

import org.objectweb.asm.*;
import org.objectweb.asm.attrs.*;

public class SampleMethodCallsDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "ie/hunt/SampleMethodCalls", null, "java/lang/Object", null);

        cw.visitInnerClass("ie/hunt/SampleMethodCalls$Human", "ie/hunt/SampleMethodCalls", "Human", ACC_PUBLIC);

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
            mv = cw.visitMethod(ACC_PUBLIC, "getSomeValue", "(I)I", null, null);
            mv.visitCode();
            mv.visitIntInsn(BIPUSH, 10);
            mv.visitInsn(IRETURN);

            mv.visitMaxs(1, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getSomeValue", "(II)I", null, null);
            mv.visitCode();
            mv.visitIntInsn(BIPUSH, 10);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getSomeValue", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitLdcInsn("dog");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getSomeValue", "(Ljava/lang/String;I)Lie/hunt/SampleMethodCalls$Human;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "ie/hunt/SampleMethodCalls$Human");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKESPECIAL, "ie/hunt/SampleMethodCalls$Human", "<init>", "(Lie/hunt/SampleMethodCalls;Ljava/lang/String;I)V");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(5, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getSomeValue", "(Ljava/lang/String;Ljava/lang/Integer;)Lie/hunt/SampleMethodCalls$Human;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "ie/hunt/SampleMethodCalls$Human");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
            mv.visitMethodInsn(INVOKESPECIAL, "ie/hunt/SampleMethodCalls$Human", "<init>", "(Lie/hunt/SampleMethodCalls;Ljava/lang/String;I)V");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(5, 3);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
```
