/* Generated By:JJTree&JavaCC: Do not edit this line. EG2.java */
package farf;
import java.io.IOException;

public class EG2/*@bgen(jjtree)*/implements EG2TreeConstants, EG2Constants {/*@bgen(jjtree)*/
  protected JJTEG2State jjtree = new JJTEG2State();java.util.Map < String, String > identifiers = new java.util.HashMap < String, String > ();
  java.util.Map < String, String > globMapping = new java.util.HashMap < String, String > ();

  public void saveAlias(Token id, Token fqcn)
  {
    System.err.println("Encountered identifer:" + id + " -> " + fqcn);
    if (identifiers.containsKey(id.image))
    {
      throw new RuntimeException("duplicate alias id:" + id);
    }
    else
    {
      identifiers.put(id.image, fqcn.image);
    }
  }

  public ParseException saveGlobMap(Token glob, Token alias)
  {
    System.err.println("glob: " + glob + " -> " + alias);
    if (!identifiers.containsKey(alias.image))
    {
      return new ParseException("Missing alias '" + alias + "' at line:" +
      token.beginLine + ", column:" + token.beginColumn);
    }
    else
    {
      globMapping.put(glob.image, alias.image);
    }
    return null;
  }

  public static void main(String args []) throws IOException
  {
    java.io.InputStream is = null;
    try
    {
      is = foo.Util.readFile("sample/aspects.conf");
      EG2 parser = new EG2(is);
      try
      {
        SimpleNode n = parser.Start();
        n.dump("");
        System.out.println("Thank you.");
      }
      catch (Exception e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
      }
    }
    finally
    {
      is.close();
    }
  }

  final public SimpleNode Start() throws ParseException {
 /*@bgen(jjtree) Start */
  SimpleNode jjtn000 = new SimpleNode(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtn000.jjtSetFirstToken(getToken(1));
    try {
      Expression();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.jjtSetLastToken(getToken(0));
    {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtn000.jjtSetLastToken(getToken(0));
    }
    }
    throw new Error("Missing return statement in function");
  }

  final public void Expression() throws ParseException {
 /*@bgen(jjtree) Expression */
  SimpleNode jjtn000 = new SimpleNode(JJTEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtn000.jjtSetFirstToken(getToken(1));
    try {
      AliasSection();
      MatchersSection();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtn000.jjtSetLastToken(getToken(0));
    }
    }
  }

  final public void AliasSection() throws ParseException {
 /*@bgen(jjtree) AliasSection */
  SimpleNode jjtn000 = new SimpleNode(JJTALIASSECTION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtn000.jjtSetFirstToken(getToken(1));
    try {
      jj_consume_token(ALIASES);
      jj_consume_token(OPEN_BRACE);
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        Alias();
      }
      jj_consume_token(CLOSE_BRACE);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtn000.jjtSetLastToken(getToken(0));
    }
    }
  }

  final public void MatchersSection() throws ParseException {
 /*@bgen(jjtree) MatchersSection */
  SimpleNode jjtn000 = new SimpleNode(JJTMATCHERSSECTION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtn000.jjtSetFirstToken(getToken(1));
    try {
      jj_consume_token(MATCHERS);
      jj_consume_token(OPEN_BRACE);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case METHOD_GLOB:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        Matcher();
      }
      jj_consume_token(CLOSE_BRACE);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtn000.jjtSetLastToken(getToken(0));
    }
    }
  }

  final public void Alias() throws ParseException {
 /*@bgen(jjtree) Alias */
  SimpleNode jjtn000 = new SimpleNode(JJTALIAS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtn000.jjtSetFirstToken(getToken(1));Token id = null;
  Token fqcn = null;
    try {
      jj_consume_token(IDENTIFIER);
    id = token;
      jj_consume_token(27);
      jj_consume_token(FQCN);
    fqcn = token;
      jj_consume_token(28);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.jjtSetLastToken(getToken(0));
    saveAlias(id, fqcn);
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtn000.jjtSetLastToken(getToken(0));
    }
    }
  }

  final public void Matcher() throws ParseException {
 /*@bgen(jjtree) Matcher */
  SimpleNode jjtn000 = new SimpleNode(JJTMATCHER);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtn000.jjtSetFirstToken(getToken(1));Token glob = null;
  Token alias = null;
    try {
      jj_consume_token(METHOD_GLOB);
    glob = token;
      jj_consume_token(MAPTO);
      jj_consume_token(IDENTIFIER);
    alias = token;
      jj_consume_token(28);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.jjtSetLastToken(getToken(0));
    ParseException p = saveGlobMap(glob, alias);
    if (p != null) {if (true) throw p;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtn000.jjtSetLastToken(getToken(0));
    }
    }
  }

  /** Generated Token Manager. */
  public EG2TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200000,0x4000000,};
   }

  /** Constructor with InputStream. */
  public EG2(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public EG2(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new EG2TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public EG2(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new EG2TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public EG2(EG2TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(EG2TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[29];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 29; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
