/* Generated By:JavaCC: Do not edit this line. LogoGram.java */
package fr.esiea.main.grammaire;
import java.io.StringReader;
import java.lang.*;


/*

 @Author lebec, ouadah
 @Since 12/06/2012

*/



public class LogoGram implements LogoGramConstants {

/*
 * programme: Repeate
Repeate: arg [ liste_operation ]

liste_operation: operation liste_operation
| 

operation: MOT arg_opt

arg_opt: arg
|

arg: NOMBRE

*/
  static final public java.util.List<Object> Programme() throws ParseException {
        java.util.List<Object> e;
        java.util.Map<String, Integer> map;
    map = ListeVariables();
    jj_consume_token(10);
    e = ListeOperation(map);
    jj_consume_token(0);
          e.add(map);
          System.out.println("Mes variables : "+map);
          {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public java.util.Map<String, Integer> ListeVariables() throws ParseException {
        java.util.Map<String,Integer> variables = new java.util.HashMap<String, Integer>();
        Token t;
        Token arg;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MOT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      t = jj_consume_token(MOT);
      jj_consume_token(11);
      arg = jj_consume_token(NOMBRE);
                variables.put(t.image,Integer.parseInt(arg.image));
    }
         {if (true) return variables;}
    throw new Error("Missing return statement in function");
  }

  static final public java.util.List<Object> ListeOperation(java.util.Map<String, Integer> map) throws ParseException {
        java.util.List<Object> listeOperation = new java.util.ArrayList<Object>();
        java.util.List<Object> o;

        Token t;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MC_REPETE:
      case MOT:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      o = Operation(map);
                 listeOperation.add(o);
                 //System.out.println("Etat de ma liste d'operation : "+listeOperation.toString());

    }
              {if (true) return listeOperation;}
    throw new Error("Missing return statement in function");
  }

  static final public java.util.List<Object> Operation(java.util.Map<String, Integer> map) throws ParseException {
        java.util.List<Object> listeExpression = new java.util.ArrayList<Object>();
        java.util.List<Object> listeRepete;


        String o;
        Token t;
        Token arg;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MC_REPETE:
      jj_consume_token(MC_REPETE);
      o = Arg(map);
      jj_consume_token(LBRACKET);
      listeRepete = ListeOperation(map);
      jj_consume_token(RBRACKET);
                 listeRepete.add(new OperationLogo("REPETE",Integer.parseInt(o)));
                 {if (true) return listeRepete;}
      break;
    case MOT:
      t = jj_consume_token(MOT);
      o = ArgOptionnel(map);
                         listeExpression.add(new FonctionLogo(t.image,Integer.parseInt(o)));
                        // System.out.println("Etat de ma liste d'expression : "+listeExpression.toString());
                         {if (true) return listeExpression;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public String ArgOptionnel(java.util.Map<String, Integer> map) throws ParseException {
        String t;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NOMBRE:
      case 12:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      t = Arg(map);
                {if (true) return t;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public String Arg(java.util.Map<String, Integer> map) throws ParseException {
        Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOMBRE:
      t = jj_consume_token(NOMBRE);
                {if (true) return new String(String.valueOf(t.image));}
      break;
    case 12:
      jj_consume_token(12);
      t = jj_consume_token(MOT);
                {if (true) return new String(String.valueOf(map.get(t.image)));}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LogoGramTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8,0xc,0xc,0x1002,0x1002,};
   }

  /** Constructor with InputStream. */
  public LogoGram(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public LogoGram(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LogoGramTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public LogoGram(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LogoGramTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public LogoGram(LogoGramTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LogoGramTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
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
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[13];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 5; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 13; i++) {
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
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
