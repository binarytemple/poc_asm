import ie.hunt.aop.conf.ParseException;

import java.io.IOException;

/**
 * Bootstrapping the Visitor implementation.
 * 
 * @author bryan
 * 
 */
public class AspectParserVisitingMain {

	public static void main(String args[]) throws IOException, ParseException {
//		java.io.InputStream is = null;
//		is = foo.Util.readFile("sample/valid-aspects1.conf");
//		AspectConfParser parser = new AspectConfParser(is);
//		SimpleNode n = parser.Start();
//		n.jjtAccept(new AspectConfParserVisitor() {
//
//			@Override
//			public Object visit(ASTMatcher node, Map data) {
//				System.err.println("visiting ASTMatcher :" + node.toString());
//				// TODO Auto-generated method stub
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTAlias node, Map data) {
//				System.err.println("visiting ASTAlias :" + node.jjtGetValue());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTMatchersSection node, Map data) {
//				System.err.println("visiting ASTMatchersSection"
//						+ node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTAliasSection node, Map data) {
//				System.err.println("visiting ASTAliasSection :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTExpression node, Map data) {
//				System.err.println("visiting ASTExpression :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTStart node, Map data) {
//				System.err.println("visiting ASTStart :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(SimpleNode node, Map data) {
//				System.err.println("visiting SimpleNode :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTMethodGlob node, Map data) {
//				System.err.println("visiting ASTMethodGlob :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTPath node, Map data) {
//				System.err.println("visiting ASTPath :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//
//			@Override
//			public Object visit(ASTFqcn node, Map data) {
//				System.err.println("visiting ASTFqcn :" + node.toString());
//				return node.childrenAccept(this, data);
//			}
//		}, new HashMap<Object, Object>());
//		n.dump("");
//		System.out.println("Thank you.");
//		is.close();
	}
}
