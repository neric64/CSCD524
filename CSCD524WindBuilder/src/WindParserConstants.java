/* Generated By:JavaCC: Do not edit this line. WindParserConstants.java */

/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface WindParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 8;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 9;
  /** RegularExpression Id. */
  int CIRCLE = 11;
  /** RegularExpression Id. */
  int BOX = 12;
  /** RegularExpression Id. */
  int STRAIGHT = 13;
  /** RegularExpression Id. */
  int CURVE = 14;
  /** RegularExpression Id. */
  int POINT = 15;
  /** RegularExpression Id. */
  int TORNADO = 16;
  /** RegularExpression Id. */
  int SNAKE = 17;
  /** RegularExpression Id. */
  int HEIGHT = 18;
  /** RegularExpression Id. */
  int SPEED = 19;
  /** RegularExpression Id. */
  int COMMA = 20;
  /** RegularExpression Id. */
  int SEMICOLON = 21;
  /** RegularExpression Id. */
  int PATTERN_DECIMAL = 22;
  /** RegularExpression Id. */
  int LITERAL_NUMBER = 23;
  /** RegularExpression Id. */
  int IDENTIFIER = 24;
  /** RegularExpression Id. */
  int LETTER = 25;
  /** RegularExpression Id. */
  int DIGIT = 26;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SINGLE_LINE_COMMENT = 1;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\f\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\t\"",
    "\"//\"",
    "\"/*\"",
    "<SINGLE_LINE_COMMENT>",
    "\"*/\"",
    "<token of kind 10>",
    "\"circle\"",
    "\"box\"",
    "\"straight\"",
    "\"curve\"",
    "\"point\"",
    "\"tornado\"",
    "\"snake\"",
    "\"height\"",
    "\"knots\"",
    "\",\"",
    "\";\"",
    "<PATTERN_DECIMAL>",
    "<LITERAL_NUMBER>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
  };

}
