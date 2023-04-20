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
		T__24=25, STRING=26, INT=27, FLOAT=28, WS=29;
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
			"STRING", "INT", "FLOAT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CREATE'", "'DELETE'", "'UPDATE'", "'VERTEX'", "'('", "':'", "')'", 
			"'EDGE'", "'FROM'", "'TO'", "'WITH'", "'INDEX'", "'ON'", "'SET'", "','", 
			"'='", "'{'", "'}'", "'DATABASE'", "'DROP'", "'SWITCH'", "'GET'", "'CURRENT'", 
			"'DEFAULT'", "'MATCH'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "STRING", "INT", "FLOAT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u00b8\n\33"+
		"\f\33\16\33\u00bb\13\33\3\34\6\34\u00be\n\34\r\34\16\34\u00bf\3\35\6\35"+
		"\u00c3\n\35\r\35\16\35\u00c4\3\35\3\35\6\35\u00c9\n\35\r\35\16\35\u00ca"+
		"\3\36\6\36\u00ce\n\36\r\36\16\36\u00cf\3\36\3\36\2\2\37\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\6\5\2C\\"+
		"aac|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2\u00d7\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2"+
		"\5D\3\2\2\2\7K\3\2\2\2\tR\3\2\2\2\13Y\3\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21"+
		"_\3\2\2\2\23d\3\2\2\2\25i\3\2\2\2\27l\3\2\2\2\31q\3\2\2\2\33w\3\2\2\2"+
		"\35z\3\2\2\2\37~\3\2\2\2!\u0080\3\2\2\2#\u0082\3\2\2\2%\u0084\3\2\2\2"+
		"\'\u0086\3\2\2\2)\u008f\3\2\2\2+\u0094\3\2\2\2-\u009b\3\2\2\2/\u009f\3"+
		"\2\2\2\61\u00a7\3\2\2\2\63\u00af\3\2\2\2\65\u00b5\3\2\2\2\67\u00bd\3\2"+
		"\2\29\u00c2\3\2\2\2;\u00cd\3\2\2\2=>\7E\2\2>?\7T\2\2?@\7G\2\2@A\7C\2\2"+
		"AB\7V\2\2BC\7G\2\2C\4\3\2\2\2DE\7F\2\2EF\7G\2\2FG\7N\2\2GH\7G\2\2HI\7"+
		"V\2\2IJ\7G\2\2J\6\3\2\2\2KL\7W\2\2LM\7R\2\2MN\7F\2\2NO\7C\2\2OP\7V\2\2"+
		"PQ\7G\2\2Q\b\3\2\2\2RS\7X\2\2ST\7G\2\2TU\7T\2\2UV\7V\2\2VW\7G\2\2WX\7"+
		"Z\2\2X\n\3\2\2\2YZ\7*\2\2Z\f\3\2\2\2[\\\7<\2\2\\\16\3\2\2\2]^\7+\2\2^"+
		"\20\3\2\2\2_`\7G\2\2`a\7F\2\2ab\7I\2\2bc\7G\2\2c\22\3\2\2\2de\7H\2\2e"+
		"f\7T\2\2fg\7Q\2\2gh\7O\2\2h\24\3\2\2\2ij\7V\2\2jk\7Q\2\2k\26\3\2\2\2l"+
		"m\7Y\2\2mn\7K\2\2no\7V\2\2op\7J\2\2p\30\3\2\2\2qr\7K\2\2rs\7P\2\2st\7"+
		"F\2\2tu\7G\2\2uv\7Z\2\2v\32\3\2\2\2wx\7Q\2\2xy\7P\2\2y\34\3\2\2\2z{\7"+
		"U\2\2{|\7G\2\2|}\7V\2\2}\36\3\2\2\2~\177\7.\2\2\177 \3\2\2\2\u0080\u0081"+
		"\7?\2\2\u0081\"\3\2\2\2\u0082\u0083\7}\2\2\u0083$\3\2\2\2\u0084\u0085"+
		"\7\177\2\2\u0085&\3\2\2\2\u0086\u0087\7F\2\2\u0087\u0088\7C\2\2\u0088"+
		"\u0089\7V\2\2\u0089\u008a\7C\2\2\u008a\u008b\7D\2\2\u008b\u008c\7C\2\2"+
		"\u008c\u008d\7U\2\2\u008d\u008e\7G\2\2\u008e(\3\2\2\2\u008f\u0090\7F\2"+
		"\2\u0090\u0091\7T\2\2\u0091\u0092\7Q\2\2\u0092\u0093\7R\2\2\u0093*\3\2"+
		"\2\2\u0094\u0095\7U\2\2\u0095\u0096\7Y\2\2\u0096\u0097\7K\2\2\u0097\u0098"+
		"\7V\2\2\u0098\u0099\7E\2\2\u0099\u009a\7J\2\2\u009a,\3\2\2\2\u009b\u009c"+
		"\7I\2\2\u009c\u009d\7G\2\2\u009d\u009e\7V\2\2\u009e.\3\2\2\2\u009f\u00a0"+
		"\7E\2\2\u00a0\u00a1\7W\2\2\u00a1\u00a2\7T\2\2\u00a2\u00a3\7T\2\2\u00a3"+
		"\u00a4\7G\2\2\u00a4\u00a5\7P\2\2\u00a5\u00a6\7V\2\2\u00a6\60\3\2\2\2\u00a7"+
		"\u00a8\7F\2\2\u00a8\u00a9\7G\2\2\u00a9\u00aa\7H\2\2\u00aa\u00ab\7C\2\2"+
		"\u00ab\u00ac\7W\2\2\u00ac\u00ad\7N\2\2\u00ad\u00ae\7V\2\2\u00ae\62\3\2"+
		"\2\2\u00af\u00b0\7O\2\2\u00b0\u00b1\7C\2\2\u00b1\u00b2\7V\2\2\u00b2\u00b3"+
		"\7E\2\2\u00b3\u00b4\7J\2\2\u00b4\64\3\2\2\2\u00b5\u00b9\t\2\2\2\u00b6"+
		"\u00b8\t\3\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\66\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be"+
		"\t\4\2\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c08\3\2\2\2\u00c1\u00c3\t\4\2\2\u00c2\u00c1\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c8\7\60\2\2\u00c7\u00c9\t\4\2\2\u00c8\u00c7\3\2\2\2"+
		"\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb:\3"+
		"\2\2\2\u00cc\u00ce\t\5\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b\36"+
		"\2\2\u00d2<\3\2\2\2\b\2\u00b9\u00bf\u00c4\u00ca\u00cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}