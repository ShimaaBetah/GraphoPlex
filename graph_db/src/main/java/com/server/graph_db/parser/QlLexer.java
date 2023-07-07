// Generated from Ql.g4 by ANTLR 4.7.2
package com.server.graph_db.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, STRING=48, INT=49, FLOAT=50, WS=51, QOUTED_STRING=52;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "STRING", "INT", 
			"FLOAT", "WS", "QOUTED_STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CREATE'", "'DELETE'", "'UPDATE'", "'VERTEX'", "'('", "':'", "')'", 
			"'EDGE'", "'FROM'", "'TO'", "'WITH'", "'INDEX'", "'ON'", "'SET'", "','", 
			"'='", "'{'", "'}'", "'DATABASE'", "'DROP'", "'SWITCH'", "'GET'", "'CURRENT'", 
			"'DEFAULT'", "'MATCH'", "'SHORTEST'", "'PATH'", "'WITH COST ='", "'USING HUERISTIC'", 
			"'MANHATTAN'", "'x ='", "'y ='", "'EUCLIDEAN'", "'[('", "']'", "'AS'", 
			"'-'", "'->'", "'<-'", "'<>'", "'<'", "'>'", "'<='", "'>='", "'WHERE'", 
			"'RETURN'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"STRING", "INT", "FLOAT", "WS", "QOUTED_STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public QlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u017e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3"+
		".\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\61\3\61\7\61\u0158\n"+
		"\61\f\61\16\61\u015b\13\61\3\62\6\62\u015e\n\62\r\62\16\62\u015f\3\63"+
		"\6\63\u0163\n\63\r\63\16\63\u0164\3\63\3\63\6\63\u0169\n\63\r\63\16\63"+
		"\u016a\3\64\6\64\u016e\n\64\r\64\16\64\u016f\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\7\65\u0178\n\65\f\65\16\65\u017b\13\65\3\65\3\65\2\2\66\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66\3\2\6\6\2\62;C"+
		"\\aac|\3\2\62;\5\2\13\f\17\17\"\"\3\2$$\2\u0184\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5r\3\2\2\2\7y\3\2\2\2\t\u0080"+
		"\3\2\2\2\13\u0087\3\2\2\2\r\u0089\3\2\2\2\17\u008b\3\2\2\2\21\u008d\3"+
		"\2\2\2\23\u0092\3\2\2\2\25\u0097\3\2\2\2\27\u009a\3\2\2\2\31\u009f\3\2"+
		"\2\2\33\u00a5\3\2\2\2\35\u00a8\3\2\2\2\37\u00ac\3\2\2\2!\u00ae\3\2\2\2"+
		"#\u00b0\3\2\2\2%\u00b2\3\2\2\2\'\u00b4\3\2\2\2)\u00bd\3\2\2\2+\u00c2\3"+
		"\2\2\2-\u00c9\3\2\2\2/\u00cd\3\2\2\2\61\u00d5\3\2\2\2\63\u00dd\3\2\2\2"+
		"\65\u00e3\3\2\2\2\67\u00ec\3\2\2\29\u00f1\3\2\2\2;\u00fd\3\2\2\2=\u010d"+
		"\3\2\2\2?\u0117\3\2\2\2A\u011b\3\2\2\2C\u011f\3\2\2\2E\u0129\3\2\2\2G"+
		"\u012c\3\2\2\2I\u012e\3\2\2\2K\u0131\3\2\2\2M\u0133\3\2\2\2O\u0136\3\2"+
		"\2\2Q\u0139\3\2\2\2S\u013c\3\2\2\2U\u013e\3\2\2\2W\u0140\3\2\2\2Y\u0143"+
		"\3\2\2\2[\u0146\3\2\2\2]\u014c\3\2\2\2_\u0153\3\2\2\2a\u0155\3\2\2\2c"+
		"\u015d\3\2\2\2e\u0162\3\2\2\2g\u016d\3\2\2\2i\u0173\3\2\2\2kl\7E\2\2l"+
		"m\7T\2\2mn\7G\2\2no\7C\2\2op\7V\2\2pq\7G\2\2q\4\3\2\2\2rs\7F\2\2st\7G"+
		"\2\2tu\7N\2\2uv\7G\2\2vw\7V\2\2wx\7G\2\2x\6\3\2\2\2yz\7W\2\2z{\7R\2\2"+
		"{|\7F\2\2|}\7C\2\2}~\7V\2\2~\177\7G\2\2\177\b\3\2\2\2\u0080\u0081\7X\2"+
		"\2\u0081\u0082\7G\2\2\u0082\u0083\7T\2\2\u0083\u0084\7V\2\2\u0084\u0085"+
		"\7G\2\2\u0085\u0086\7Z\2\2\u0086\n\3\2\2\2\u0087\u0088\7*\2\2\u0088\f"+
		"\3\2\2\2\u0089\u008a\7<\2\2\u008a\16\3\2\2\2\u008b\u008c\7+\2\2\u008c"+
		"\20\3\2\2\2\u008d\u008e\7G\2\2\u008e\u008f\7F\2\2\u008f\u0090\7I\2\2\u0090"+
		"\u0091\7G\2\2\u0091\22\3\2\2\2\u0092\u0093\7H\2\2\u0093\u0094\7T\2\2\u0094"+
		"\u0095\7Q\2\2\u0095\u0096\7O\2\2\u0096\24\3\2\2\2\u0097\u0098\7V\2\2\u0098"+
		"\u0099\7Q\2\2\u0099\26\3\2\2\2\u009a\u009b\7Y\2\2\u009b\u009c\7K\2\2\u009c"+
		"\u009d\7V\2\2\u009d\u009e\7J\2\2\u009e\30\3\2\2\2\u009f\u00a0\7K\2\2\u00a0"+
		"\u00a1\7P\2\2\u00a1\u00a2\7F\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7Z\2\2"+
		"\u00a4\32\3\2\2\2\u00a5\u00a6\7Q\2\2\u00a6\u00a7\7P\2\2\u00a7\34\3\2\2"+
		"\2\u00a8\u00a9\7U\2\2\u00a9\u00aa\7G\2\2\u00aa\u00ab\7V\2\2\u00ab\36\3"+
		"\2\2\2\u00ac\u00ad\7.\2\2\u00ad \3\2\2\2\u00ae\u00af\7?\2\2\u00af\"\3"+
		"\2\2\2\u00b0\u00b1\7}\2\2\u00b1$\3\2\2\2\u00b2\u00b3\7\177\2\2\u00b3&"+
		"\3\2\2\2\u00b4\u00b5\7F\2\2\u00b5\u00b6\7C\2\2\u00b6\u00b7\7V\2\2\u00b7"+
		"\u00b8\7C\2\2\u00b8\u00b9\7D\2\2\u00b9\u00ba\7C\2\2\u00ba\u00bb\7U\2\2"+
		"\u00bb\u00bc\7G\2\2\u00bc(\3\2\2\2\u00bd\u00be\7F\2\2\u00be\u00bf\7T\2"+
		"\2\u00bf\u00c0\7Q\2\2\u00c0\u00c1\7R\2\2\u00c1*\3\2\2\2\u00c2\u00c3\7"+
		"U\2\2\u00c3\u00c4\7Y\2\2\u00c4\u00c5\7K\2\2\u00c5\u00c6\7V\2\2\u00c6\u00c7"+
		"\7E\2\2\u00c7\u00c8\7J\2\2\u00c8,\3\2\2\2\u00c9\u00ca\7I\2\2\u00ca\u00cb"+
		"\7G\2\2\u00cb\u00cc\7V\2\2\u00cc.\3\2\2\2\u00cd\u00ce\7E\2\2\u00ce\u00cf"+
		"\7W\2\2\u00cf\u00d0\7T\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2\7G\2\2\u00d2"+
		"\u00d3\7P\2\2\u00d3\u00d4\7V\2\2\u00d4\60\3\2\2\2\u00d5\u00d6\7F\2\2\u00d6"+
		"\u00d7\7G\2\2\u00d7\u00d8\7H\2\2\u00d8\u00d9\7C\2\2\u00d9\u00da\7W\2\2"+
		"\u00da\u00db\7N\2\2\u00db\u00dc\7V\2\2\u00dc\62\3\2\2\2\u00dd\u00de\7"+
		"O\2\2\u00de\u00df\7C\2\2\u00df\u00e0\7V\2\2\u00e0\u00e1\7E\2\2\u00e1\u00e2"+
		"\7J\2\2\u00e2\64\3\2\2\2\u00e3\u00e4\7U\2\2\u00e4\u00e5\7J\2\2\u00e5\u00e6"+
		"\7Q\2\2\u00e6\u00e7\7T\2\2\u00e7\u00e8\7V\2\2\u00e8\u00e9\7G\2\2\u00e9"+
		"\u00ea\7U\2\2\u00ea\u00eb\7V\2\2\u00eb\66\3\2\2\2\u00ec\u00ed\7R\2\2\u00ed"+
		"\u00ee\7C\2\2\u00ee\u00ef\7V\2\2\u00ef\u00f0\7J\2\2\u00f08\3\2\2\2\u00f1"+
		"\u00f2\7Y\2\2\u00f2\u00f3\7K\2\2\u00f3\u00f4\7V\2\2\u00f4\u00f5\7J\2\2"+
		"\u00f5\u00f6\7\"\2\2\u00f6\u00f7\7E\2\2\u00f7\u00f8\7Q\2\2\u00f8\u00f9"+
		"\7U\2\2\u00f9\u00fa\7V\2\2\u00fa\u00fb\7\"\2\2\u00fb\u00fc\7?\2\2\u00fc"+
		":\3\2\2\2\u00fd\u00fe\7W\2\2\u00fe\u00ff\7U\2\2\u00ff\u0100\7K\2\2\u0100"+
		"\u0101\7P\2\2\u0101\u0102\7I\2\2\u0102\u0103\7\"\2\2\u0103\u0104\7J\2"+
		"\2\u0104\u0105\7W\2\2\u0105\u0106\7G\2\2\u0106\u0107\7T\2\2\u0107\u0108"+
		"\7K\2\2\u0108\u0109\7U\2\2\u0109\u010a\7V\2\2\u010a\u010b\7K\2\2\u010b"+
		"\u010c\7E\2\2\u010c<\3\2\2\2\u010d\u010e\7O\2\2\u010e\u010f\7C\2\2\u010f"+
		"\u0110\7P\2\2\u0110\u0111\7J\2\2\u0111\u0112\7C\2\2\u0112\u0113\7V\2\2"+
		"\u0113\u0114\7V\2\2\u0114\u0115\7C\2\2\u0115\u0116\7P\2\2\u0116>\3\2\2"+
		"\2\u0117\u0118\7z\2\2\u0118\u0119\7\"\2\2\u0119\u011a\7?\2\2\u011a@\3"+
		"\2\2\2\u011b\u011c\7{\2\2\u011c\u011d\7\"\2\2\u011d\u011e\7?\2\2\u011e"+
		"B\3\2\2\2\u011f\u0120\7G\2\2\u0120\u0121\7W\2\2\u0121\u0122\7E\2\2\u0122"+
		"\u0123\7N\2\2\u0123\u0124\7K\2\2\u0124\u0125\7F\2\2\u0125\u0126\7G\2\2"+
		"\u0126\u0127\7C\2\2\u0127\u0128\7P\2\2\u0128D\3\2\2\2\u0129\u012a\7]\2"+
		"\2\u012a\u012b\7*\2\2\u012bF\3\2\2\2\u012c\u012d\7_\2\2\u012dH\3\2\2\2"+
		"\u012e\u012f\7C\2\2\u012f\u0130\7U\2\2\u0130J\3\2\2\2\u0131\u0132\7/\2"+
		"\2\u0132L\3\2\2\2\u0133\u0134\7/\2\2\u0134\u0135\7@\2\2\u0135N\3\2\2\2"+
		"\u0136\u0137\7>\2\2\u0137\u0138\7/\2\2\u0138P\3\2\2\2\u0139\u013a\7>\2"+
		"\2\u013a\u013b\7@\2\2\u013bR\3\2\2\2\u013c\u013d\7>\2\2\u013dT\3\2\2\2"+
		"\u013e\u013f\7@\2\2\u013fV\3\2\2\2\u0140\u0141\7>\2\2\u0141\u0142\7?\2"+
		"\2\u0142X\3\2\2\2\u0143\u0144\7@\2\2\u0144\u0145\7?\2\2\u0145Z\3\2\2\2"+
		"\u0146\u0147\7Y\2\2\u0147\u0148\7J\2\2\u0148\u0149\7G\2\2\u0149\u014a"+
		"\7T\2\2\u014a\u014b\7G\2\2\u014b\\\3\2\2\2\u014c\u014d\7T\2\2\u014d\u014e"+
		"\7G\2\2\u014e\u014f\7V\2\2\u014f\u0150\7W\2\2\u0150\u0151\7T\2\2\u0151"+
		"\u0152\7P\2\2\u0152^\3\2\2\2\u0153\u0154\7\60\2\2\u0154`\3\2\2\2\u0155"+
		"\u0159\t\2\2\2\u0156\u0158\t\2\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2"+
		"\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015ab\3\2\2\2\u015b\u0159"+
		"\3\2\2\2\u015c\u015e\t\3\2\2\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160d\3\2\2\2\u0161\u0163\t\3\2\2"+
		"\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\7\60\2\2\u0167\u0169\t\3\2\2"+
		"\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016bf\3\2\2\2\u016c\u016e\t\4\2\2\u016d\u016c\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\b\64\2\2\u0172h\3\2\2\2\u0173\u0179\7$\2\2\u0174\u0178"+
		"\n\5\2\2\u0175\u0176\7$\2\2\u0176\u0178\7$\2\2\u0177\u0174\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7$\2\2\u017d"+
		"j\3\2\2\2\n\2\u0159\u015f\u0164\u016a\u016f\u0177\u0179\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}