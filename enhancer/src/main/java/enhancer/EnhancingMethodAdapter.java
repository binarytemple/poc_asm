package enhancer;

import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;


public class EnhancingMethodAdapter extends MethodAdapter {
    private final String _className;
    private final String _methodName;
    private final String _descriptor;
    private final String _signature;

    public EnhancingMethodAdapter(MethodVisitor visitor,
                                  String className,
                                  String methodName, String descriptor, String signature) {
        super(visitor);
        _className = className;
        _methodName = methodName;
        _descriptor = descriptor;
        _signature = signature;
        System.err.println("_className: '" + _className +
                "', _methodName: '" + _methodName +
                "', _descriptor: '" + _descriptor +
                "' _signature: '" + ", " + _signature + "'");
    }

    @Override
    public void visitAttribute(Attribute attr) {
        System.err.println(attr);
        super.visitAttribute(attr);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        System.err.println("opcode" + opcode + ", owner: " + owner + ", name:" + name + ", desc" + desc);
        super.visitMethodInsn(opcode, owner, name, desc);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        System.err.println("parameter" + parameter + ", desc: " + desc + ", visible:" + visible);
        return super.visitParameterAnnotation(parameter, desc, visible);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void visitCode() {
        this.visitLdcInsn(_className);
        this.visitLdcInsn(_methodName);
        this.visitMethodInsn(INVOKESTATIC,
                "enhancer/Enhance",
                "start",
                "(Ljava/lang/String;Ljava/lang/String;)V");

        super.visitCode();
    }

    /*
    This matcher watches out for the final instruction in a method,
    and adds the call to the enhancer/Enhance method.
     */
    public void visitInsn(int inst) {
        switch (inst) {
            case Opcodes.ARETURN:
            case Opcodes.DRETURN:
            case Opcodes.FRETURN:
            case Opcodes.IRETURN:
            case Opcodes.LRETURN:
            case Opcodes.RETURN:
            case Opcodes.ATHROW:
                this.visitLdcInsn(_className);
                this.visitLdcInsn(_methodName);
                this.visitMethodInsn(INVOKESTATIC,
                        "enhancer/Enhance",
                        "end",
                        "(Ljava/lang/String;Ljava/lang/String;)V");
                break;
            default:
                break;
        }

        super.visitInsn(inst);
    }

}

