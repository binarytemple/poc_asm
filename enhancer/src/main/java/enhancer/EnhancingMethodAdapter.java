package enhancer;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;


public class EnhancingMethodAdapter extends MethodAdapter {
	private String _className, _methodName;
	
	public EnhancingMethodAdapter(MethodVisitor visitor,
                                  String className,
                                  String methodName) {
		super(visitor);
		_className = className;
		_methodName = methodName;
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

