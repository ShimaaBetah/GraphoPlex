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
		T__38=39, STRING=40, INT=41, FLOAT=42, WS=43;
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
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "STRING", "INT", 
			"FLOAT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CREATE'", "'DELETE'", "'UPDATE'", "'VERTEX'", "'('", "':'", "')'", 
			"'EDGE'", "'FROM'", "'TO'", "'WITH'", "'INDEX'", "'ON'", "'SET'", "','", 
			"'='", "'{'", "'}'", "'DATABASE'", "'DROP'", "'SWITCH'", "'GET'", "'CURRENT'", 
			"'DEFAULT'", "'MATCH'", "'[('", "']'", "'AS'", "'-'", "'->'", "'<-'", 
			"'<>'", "'<'", "'>'", "'<='", "'>='", "'WHERE'", "'RETURN'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "STRING", "INT", "FLOAT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u011b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3(\3(\3)\3)\7)\u0100\n)\f)\16)\u0103\13)\3*\6*\u0106\n*\r"+
		"*\16*\u0107\3+\6+\u010b\n+\r+\16+\u010c\3+\3+\6+\u0111\n+\r+\16+\u0112"+
		"\3,\6,\u0116\n,\r,\16,\u0117\3,\3,\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-\3\2\6\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2\u011f\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5`\3\2\2\2\7g\3\2\2\2\tn\3\2\2\2\13u\3"+
		"\2\2\2\rw\3\2\2\2\17y\3\2\2\2\21{\3\2\2\2\23\u0080\3\2\2\2\25\u0085\3"+
		"\2\2\2\27\u0088\3\2\2\2\31\u008d\3\2\2\2\33\u0093\3\2\2\2\35\u0096\3\2"+
		"\2\2\37\u009a\3\2\2\2!\u009c\3\2\2\2#\u009e\3\2\2\2%\u00a0\3\2\2\2\'\u00a2"+
		"\3\2\2\2)\u00ab\3\2\2\2+\u00b0\3\2\2\2-\u00b7\3\2\2\2/\u00bb\3\2\2\2\61"+
		"\u00c3\3\2\2\2\63\u00cb\3\2\2\2\65\u00d1\3\2\2\2\67\u00d4\3\2\2\29\u00d6"+
		"\3\2\2\2;\u00d9\3\2\2\2=\u00db\3\2\2\2?\u00de\3\2\2\2A\u00e1\3\2\2\2C"+
		"\u00e4\3\2\2\2E\u00e6\3\2\2\2G\u00e8\3\2\2\2I\u00eb\3\2\2\2K\u00ee\3\2"+
		"\2\2M\u00f4\3\2\2\2O\u00fb\3\2\2\2Q\u00fd\3\2\2\2S\u0105\3\2\2\2U\u010a"+
		"\3\2\2\2W\u0115\3\2\2\2YZ\7E\2\2Z[\7T\2\2[\\\7G\2\2\\]\7C\2\2]^\7V\2\2"+
		"^_\7G\2\2_\4\3\2\2\2`a\7F\2\2ab\7G\2\2bc\7N\2\2cd\7G\2\2de\7V\2\2ef\7"+
		"G\2\2f\6\3\2\2\2gh\7W\2\2hi\7R\2\2ij\7F\2\2jk\7C\2\2kl\7V\2\2lm\7G\2\2"+
		"m\b\3\2\2\2no\7X\2\2op\7G\2\2pq\7T\2\2qr\7V\2\2rs\7G\2\2st\7Z\2\2t\n\3"+
		"\2\2\2uv\7*\2\2v\f\3\2\2\2wx\7<\2\2x\16\3\2\2\2yz\7+\2\2z\20\3\2\2\2{"+
		"|\7G\2\2|}\7F\2\2}~\7I\2\2~\177\7G\2\2\177\22\3\2\2\2\u0080\u0081\7H\2"+
		"\2\u0081\u0082\7T\2\2\u0082\u0083\7Q\2\2\u0083\u0084\7O\2\2\u0084\24\3"+
		"\2\2\2\u0085\u0086\7V\2\2\u0086\u0087\7Q\2\2\u0087\26\3\2\2\2\u0088\u0089"+
		"\7Y\2\2\u0089\u008a\7K\2\2\u008a\u008b\7V\2\2\u008b\u008c\7J\2\2\u008c"+
		"\30\3\2\2\2\u008d\u008e\7K\2\2\u008e\u008f\7P\2\2\u008f\u0090\7F\2\2\u0090"+
		"\u0091\7G\2\2\u0091\u0092\7Z\2\2\u0092\32\3\2\2\2\u0093\u0094\7Q\2\2\u0094"+
		"\u0095\7P\2\2\u0095\34\3\2\2\2\u0096\u0097\7U\2\2\u0097\u0098\7G\2\2\u0098"+
		"\u0099\7V\2\2\u0099\36\3\2\2\2\u009a\u009b\7.\2\2\u009b \3\2\2\2\u009c"+
		"\u009d\7?\2\2\u009d\"\3\2\2\2\u009e\u009f\7}\2\2\u009f$\3\2\2\2\u00a0"+
		"\u00a1\7\177\2\2\u00a1&\3\2\2\2\u00a2\u00a3\7F\2\2\u00a3\u00a4\7C\2\2"+
		"\u00a4\u00a5\7V\2\2\u00a5\u00a6\7C\2\2\u00a6\u00a7\7D\2\2\u00a7\u00a8"+
		"\7C\2\2\u00a8\u00a9\7U\2\2\u00a9\u00aa\7G\2\2\u00aa(\3\2\2\2\u00ab\u00ac"+
		"\7F\2\2\u00ac\u00ad\7T\2\2\u00ad\u00ae\7Q\2\2\u00ae\u00af\7R\2\2\u00af"+
		"*\3\2\2\2\u00b0\u00b1\7U\2\2\u00b1\u00b2\7Y\2\2\u00b2\u00b3\7K\2\2\u00b3"+
		"\u00b4\7V\2\2\u00b4\u00b5\7E\2\2\u00b5\u00b6\7J\2\2\u00b6,\3\2\2\2\u00b7"+
		"\u00b8\7I\2\2\u00b8\u00b9\7G\2\2\u00b9\u00ba\7V\2\2\u00ba.\3\2\2\2\u00bb"+
		"\u00bc\7E\2\2\u00bc\u00bd\7W\2\2\u00bd\u00be\7T\2\2\u00be\u00bf\7T\2\2"+
		"\u00bf\u00c0\7G\2\2\u00c0\u00c1\7P\2\2\u00c1\u00c2\7V\2\2\u00c2\60\3\2"+
		"\2\2\u00c3\u00c4\7F\2\2\u00c4\u00c5\7G\2\2\u00c5\u00c6\7H\2\2\u00c6\u00c7"+
		"\7C\2\2\u00c7\u00c8\7W\2\2\u00c8\u00c9\7N\2\2\u00c9\u00ca\7V\2\2\u00ca"+
		"\62\3\2\2\2\u00cb\u00cc\7O\2\2\u00cc\u00cd\7C\2\2\u00cd\u00ce\7V\2\2\u00ce"+
		"\u00cf\7E\2\2\u00cf\u00d0\7J\2\2\u00d0\64\3\2\2\2\u00d1\u00d2\7]\2\2\u00d2"+
		"\u00d3\7*\2\2\u00d3\66\3\2\2\2\u00d4\u00d5\7_\2\2\u00d58\3\2\2\2\u00d6"+
		"\u00d7\7C\2\2\u00d7\u00d8\7U\2\2\u00d8:\3\2\2\2\u00d9\u00da\7/\2\2\u00da"+
		"<\3\2\2\2\u00db\u00dc\7/\2\2\u00dc\u00dd\7@\2\2\u00dd>\3\2\2\2\u00de\u00df"+
		"\7>\2\2\u00df\u00e0\7/\2\2\u00e0@\3\2\2\2\u00e1\u00e2\7>\2\2\u00e2\u00e3"+
		"\7@\2\2\u00e3B\3\2\2\2\u00e4\u00e5\7>\2\2\u00e5D\3\2\2\2\u00e6\u00e7\7"+
		"@\2\2\u00e7F\3\2\2\2\u00e8\u00e9\7>\2\2\u00e9\u00ea\7?\2\2\u00eaH\3\2"+
		"\2\2\u00eb\u00ec\7@\2\2\u00ec\u00ed\7?\2\2\u00edJ\3\2\2\2\u00ee\u00ef"+
		"\7Y\2\2\u00ef\u00f0\7J\2\2\u00f0\u00f1\7G\2\2\u00f1\u00f2\7T\2\2\u00f2"+
		"\u00f3\7G\2\2\u00f3L\3\2\2\2\u00f4\u00f5\7T\2\2\u00f5\u00f6\7G\2\2\u00f6"+
		"\u00f7\7V\2\2\u00f7\u00f8\7W\2\2\u00f8\u00f9\7T\2\2\u00f9\u00fa\7P\2\2"+
		"\u00faN\3\2\2\2\u00fb\u00fc\7\60\2\2\u00fcP\3\2\2\2\u00fd\u0101\t\2\2"+
		"\2\u00fe\u0100\t\3\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102R\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0106\t\4\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108T\3\2\2\2\u0109\u010b\t\4\2\2\u010a\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0110\7\60\2\2\u010f\u0111\t\4\2\2\u0110\u010f\3"+
		"\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"V\3\2\2\2\u0114\u0116\t\5\2\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2\2\2"+
		"\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a"+
		"\b,\2\2\u011aX\3\2\2\2\b\2\u0101\u0107\u010c\u0112\u0117\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}