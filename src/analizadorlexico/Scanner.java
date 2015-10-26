/* The following code was generated by JFlex 1.6.1 */

package analizadorlexico;

import Tablas.sym;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/Users/Spartan/Documents/NetBeansProjects/AnalizadorLexico/src/analizadorlexico/Lexer.flex</tt>
 */
public class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\1\1\5\1\5\1\2\22\0\1\3\2\0\1\7"+
    "\1\0\1\4\2\0\1\36\1\37\1\30\1\26\1\46\1\27\1\45"+
    "\1\6\1\75\11\74\1\34\1\44\1\0\1\35\3\0\3\70\1\21"+
    "\1\14\1\10\1\33\1\12\1\72\2\70\1\13\1\70\1\15\1\20"+
    "\1\70\1\32\1\23\1\71\1\16\1\24\1\17\1\11\3\70\1\40"+
    "\1\0\1\41\1\31\1\73\1\0\3\47\1\61\1\54\1\50\1\67"+
    "\1\52\1\65\2\47\1\53\1\47\1\55\1\60\1\47\1\66\1\63"+
    "\1\62\1\56\1\64\1\57\1\51\3\47\1\42\1\0\1\43\7\0"+
    "\1\5\252\0\2\25\115\0\1\22\u1ea8\0\1\5\1\5\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\1\1\4\10\1\1\5"+
    "\1\6\1\7\1\10\2\1\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\12\1\2\22\5\0"+
    "\1\23\1\0\1\24\3\0\1\25\1\0\1\26\1\0"+
    "\1\27\1\0\1\30\1\0\3\30\1\23\1\30\1\24"+
    "\3\30\1\25\2\30\1\27\1\0\1\31\1\0\1\32"+
    "\1\0\1\33\2\0\1\34\1\35\1\36\1\30\1\31"+
    "\1\30\1\32\1\30\1\33\2\30\1\34\1\35\1\0"+
    "\1\37\1\40\1\0\1\30\1\37\1\40\1\30\1\41"+
    "\1\0\1\41\1\30\2\42";

  private static int [] zzUnpackAction() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\76\0\76\0\174\0\76\0\272\0\370\0\u0136"+
    "\0\u0174\0\u01b2\0\u01f0\0\u022e\0\u026c\0\u02aa\0\u02e8\0\76"+
    "\0\76\0\u0326\0\76\0\u0364\0\u03a2\0\76\0\76\0\76"+
    "\0\76\0\76\0\76\0\76\0\76\0\76\0\u03e0\0\u041e"+
    "\0\u045c\0\u049a\0\u04d8\0\u0516\0\u0554\0\u0592\0\u05d0\0\u060e"+
    "\0\u064c\0\76\0\272\0\u068a\0\u06c8\0\u0706\0\u0744\0\76"+
    "\0\u0782\0\76\0\u07c0\0\u07fe\0\u083c\0\76\0\u087a\0\76"+
    "\0\u08b8\0\76\0\u08f6\0\u03e0\0\u0934\0\u0972\0\u09b0\0\u09ee"+
    "\0\u03e0\0\u0a2c\0\u03e0\0\u0a6a\0\u0aa8\0\u0ae6\0\u03e0\0\u0b24"+
    "\0\u0b62\0\u03e0\0\u0ba0\0\76\0\u0bde\0\76\0\u0c1c\0\76"+
    "\0\u0c5a\0\u0c98\0\76\0\76\0\76\0\u0934\0\u03e0\0\u0cd6"+
    "\0\u03e0\0\u0d14\0\u03e0\0\u0d52\0\u0d90\0\u03e0\0\u03e0\0\u0dce"+
    "\0\76\0\76\0\u0e0c\0\u0e4a\0\u03e0\0\u03e0\0\u0e88\0\76"+
    "\0\u0ec6\0\u03e0\0\u0f04\0\76\0\u03e0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\0\1\7\1\2"+
    "\1\10\1\11\1\2\1\12\1\13\1\14\1\2\1\15"+
    "\3\2\1\16\1\2\1\17\1\20\1\21\1\22\1\23"+
    "\1\2\1\24\1\25\1\2\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\37\1\42\1\43\1\44\1\37\1\45\3\37\1\46"+
    "\1\37\1\47\1\37\1\50\2\2\1\17\1\2\1\51"+
    "\1\52\77\0\1\3\74\0\1\53\2\5\2\53\1\0"+
    "\70\53\7\0\1\54\106\0\1\55\37\0\1\55\27\0"+
    "\1\56\37\0\1\56\37\0\1\57\1\0\1\60\35\0"+
    "\1\57\1\0\1\60\32\0\1\61\16\0\1\62\20\0"+
    "\1\61\12\0\1\62\23\0\1\63\37\0\1\63\41\0"+
    "\1\64\37\0\1\64\31\0\1\65\37\0\1\65\31\0"+
    "\1\66\4\0\1\67\32\0\1\66\4\0\1\67\50\0"+
    "\1\70\61\0\1\71\1\0\1\72\35\0\1\71\1\0"+
    "\1\72\53\0\1\73\51\0\12\74\1\0\2\74\5\0"+
    "\2\74\13\0\24\74\1\75\2\74\10\0\10\74\1\76"+
    "\1\74\1\0\2\74\5\0\2\74\13\0\11\74\1\76"+
    "\12\74\1\75\2\74\10\0\2\74\1\77\7\74\1\0"+
    "\2\74\5\0\2\74\13\0\3\74\1\77\20\74\1\75"+
    "\2\74\10\0\4\74\1\100\1\74\1\101\3\74\1\0"+
    "\2\74\5\0\2\74\13\0\5\74\1\100\1\74\1\101"+
    "\14\74\1\75\2\74\10\0\3\74\1\102\6\74\1\0"+
    "\2\74\5\0\1\103\1\74\13\0\4\74\1\102\12\74"+
    "\1\103\4\74\1\75\2\74\10\0\4\74\1\104\5\74"+
    "\1\0\2\74\5\0\2\74\13\0\5\74\1\104\16\74"+
    "\1\75\2\74\10\0\10\74\1\105\1\74\1\0\2\74"+
    "\5\0\2\74\13\0\11\74\1\105\12\74\1\75\2\74"+
    "\10\0\4\74\1\106\5\74\1\0\2\74\5\0\2\74"+
    "\13\0\5\74\1\106\16\74\1\75\2\74\10\0\1\107"+
    "\4\74\1\110\4\74\1\0\2\74\5\0\2\74\13\0"+
    "\1\74\1\107\4\74\1\110\15\74\1\75\2\74\10\0"+
    "\4\74\1\111\1\74\1\112\3\74\1\0\2\74\5\0"+
    "\2\74\13\0\5\74\1\111\1\74\1\112\14\74\1\75"+
    "\2\74\74\0\2\51\7\54\1\113\66\54\23\0\1\114"+
    "\37\0\1\114\37\0\1\115\37\0\1\115\4\0\1\115"+
    "\35\0\1\116\33\0\1\116\31\0\1\117\37\0\1\117"+
    "\6\0\1\117\36\0\1\120\33\0\1\120\34\0\1\121"+
    "\37\0\1\121\4\0\1\121\21\0\1\122\37\0\1\122"+
    "\35\0\1\123\37\0\1\123\51\0\1\124\33\0\1\124"+
    "\44\0\1\125\50\0\12\126\1\0\2\126\5\0\2\126"+
    "\13\0\24\126\1\0\2\126\10\0\12\74\1\0\1\127"+
    "\1\74\5\0\2\74\13\0\14\74\1\127\7\74\1\75"+
    "\2\74\10\0\12\74\1\0\2\74\1\115\4\0\2\74"+
    "\13\0\16\74\1\130\4\74\1\130\1\75\2\74\10\0"+
    "\12\74\1\0\2\74\5\0\1\131\1\74\13\0\17\74"+
    "\1\131\4\74\1\75\2\74\10\0\12\74\1\117\2\74"+
    "\5\0\2\74\13\0\13\74\1\132\6\74\1\132\1\74"+
    "\1\75\2\74\10\0\12\74\1\0\2\74\5\0\1\133"+
    "\1\74\13\0\17\74\1\133\4\74\1\75\2\74\10\0"+
    "\12\74\1\0\2\74\1\121\4\0\2\74\13\0\16\74"+
    "\1\134\4\74\1\134\1\75\2\74\10\0\6\74\1\135"+
    "\3\74\1\0\2\74\5\0\2\74\13\0\7\74\1\135"+
    "\14\74\1\75\2\74\10\0\6\74\1\136\3\74\1\0"+
    "\2\74\5\0\2\74\13\0\7\74\1\136\14\74\1\75"+
    "\2\74\10\0\12\74\1\0\2\74\5\0\1\137\1\74"+
    "\13\0\17\74\1\137\4\74\1\75\2\74\6\54\1\5"+
    "\1\113\66\54\13\0\1\140\37\0\1\140\36\0\1\141"+
    "\37\0\1\141\42\0\1\142\37\0\1\142\40\0\1\143"+
    "\37\0\1\143\21\0\3\74\1\144\6\74\1\0\2\74"+
    "\5\0\2\74\13\0\4\74\1\144\17\74\1\75\2\74"+
    "\10\0\4\74\1\145\5\74\1\0\2\74\5\0\2\74"+
    "\13\0\5\74\1\145\16\74\1\75\2\74\10\0\11\74"+
    "\1\146\1\0\2\74\5\0\2\74\13\0\12\74\1\146"+
    "\11\74\1\75\2\74\10\0\12\74\1\0\1\74\1\147"+
    "\5\0\2\74\13\0\15\74\1\147\6\74\1\75\2\74"+
    "\14\0\1\150\37\0\1\150\44\0\1\151\37\0\1\151"+
    "\22\0\4\74\1\152\5\74\1\0\2\74\5\0\2\74"+
    "\13\0\5\74\1\152\16\74\1\75\2\74\10\0\12\74"+
    "\1\0\1\153\1\74\5\0\2\74\13\0\14\74\1\153"+
    "\7\74\1\75\2\74\15\0\1\154\37\0\1\154\30\0"+
    "\5\74\1\155\4\74\1\0\2\74\5\0\2\74\13\0"+
    "\6\74\1\155\15\74\1\75\2\74";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3906];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\12\1\2\11\1\1\1\11"+
    "\2\1\11\11\13\1\1\11\5\0\1\11\1\0\1\11"+
    "\3\0\1\11\1\0\1\11\1\0\1\11\1\0\1\1"+
    "\1\0\15\1\1\0\1\11\1\0\1\11\1\0\1\11"+
    "\2\0\3\11\12\1\1\0\2\11\1\0\4\1\1\11"+
    "\1\0\2\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */

/**
 * Retorna un nuevo Symbol con su identificador de Token y la línea y columna actual.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}
/**
 * Retorna un nuevo Symbol con su identificador de Token, la línea y columna actual,
 * además se incluye el valor del tokensken. El valor es utilizado para tokens como 
 * identificadores y números.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}
public String lexeme;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 210) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {   return new java_cup.runtime.Symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return newSym( sym.error);
            }
          case 35: break;
          case 2: 
            { /*Null*/
            }
          case 36: break;
          case 3: 
            { /*Ignore*/
            }
          case 37: break;
          case 4: 
            { return newSym( sym.DIV);
            }
          case 38: break;
          case 5: 
            { return newSym( sym.SUMA);
            }
          case 39: break;
          case 6: 
            { return newSym(sym.RESTA);
            }
          case 40: break;
          case 7: 
            { return newSym( sym.MULT);
            }
          case 41: break;
          case 8: 
            { return newSym( sym.EXP1);
            }
          case 42: break;
          case 9: 
            { return newSym( sym.PRI);
            }
          case 43: break;
          case 10: 
            { return newSym( sym.PRD);
            }
          case 44: break;
          case 11: 
            { return newSym( sym.PCI);
            }
          case 45: break;
          case 12: 
            { return newSym( sym.PCD);
            }
          case 46: break;
          case 13: 
            { return newSym( sym.LLI);
            }
          case 47: break;
          case 14: 
            { return newSym( sym.LLD);
            }
          case 48: break;
          case 15: 
            { return newSym( sym.PCOMMA);
            }
          case 49: break;
          case 16: 
            { return newSym( sym.POINT);
            }
          case 50: break;
          case 17: 
            { return newSym( sym.COMMA);
            }
          case 51: break;
          case 18: 
            { lexeme=yytext(); return newSym( sym.NUM);
            }
          case 52: break;
          case 19: 
            { return newSym( sym.LT);
            }
          case 53: break;
          case 20: 
            { return newSym( sym.EQ);
            }
          case 54: break;
          case 21: 
            { return newSym( sym.IF);
            }
          case 55: break;
          case 22: 
            { return newSym( sym.EXP2);
            }
          case 56: break;
          case 23: 
            { return newSym( sym.GT);
            }
          case 57: break;
          case 24: 
            { lexeme=yytext(); return newSym( sym.ID);
            }
          case 58: break;
          case 25: 
            { return newSym( sym.FOR);
            }
          case 59: break;
          case 26: 
            { return newSym( sym.LEQ);
            }
          case 60: break;
          case 27: 
            { return newSym( sym.NEQ);
            }
          case 61: break;
          case 28: 
            { return newSym( sym.INT);
            }
          case 62: break;
          case 29: 
            { return newSym( sym.GEQ);
            }
          case 63: break;
          case 30: 
            { return newSym( sym.ASIGN);
            }
          case 64: break;
          case 31: 
            { return newSym( sym.ELSE);
            }
          case 65: break;
          case 32: 
            { return newSym( sym.VOID);
            }
          case 66: break;
          case 33: 
            { return newSym( sym.WHILE);
            }
          case 67: break;
          case 34: 
            { return newSym( sym.RETURN);
            }
          case 68: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
