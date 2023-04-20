// Generated from Ql.g4 by ANTLR 4.7.2
package com.server.graph_db.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, STRING=26, INT=27, FLOAT=28, WS=29;
	public static final int
		RULE_command = 0, RULE_crud_command = 1, RULE_vertex_command = 2, RULE_edge_command = 3, 
		RULE_index_command = 4, RULE_create = 5, RULE_delete = 6, RULE_update = 7, 
		RULE_create_vertex = 8, RULE_create_edge = 9, RULE_create_index = 10, 
		RULE_delete_vertex = 11, RULE_delete_edge = 12, RULE_delete_index = 13, 
		RULE_update_vertex = 14, RULE_update_edge = 15, RULE_sourceId = 16, RULE_destinationId = 17, 
		RULE_set_clause = 18, RULE_set_item = 19, RULE_properties = 20, RULE_property = 21, 
		RULE_label = 22, RULE_key = 23, RULE_value = 24, RULE_id = 25, RULE_database_command = 26, 
		RULE_create_database = 27, RULE_delete_database = 28, RULE_drop_database = 29, 
		RULE_switch_database = 30, RULE_get_curr_database = 31, RULE_switch_database_to_default = 32, 
		RULE_drop_default_database = 33, RULE_database_name = 34, RULE_match_query = 35, 
		RULE_start = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"command", "crud_command", "vertex_command", "edge_command", "index_command", 
			"create", "delete", "update", "create_vertex", "create_edge", "create_index", 
			"delete_vertex", "delete_edge", "delete_index", "update_vertex", "update_edge", 
			"sourceId", "destinationId", "set_clause", "set_item", "properties", 
			"property", "label", "key", "value", "id", "database_command", "create_database", 
			"delete_database", "drop_database", "switch_database", "get_curr_database", 
			"switch_database_to_default", "drop_default_database", "database_name", 
			"match_query", "start"
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

	@Override
	public String getGrammarFileName() { return "Ql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CommandContext extends ParserRuleContext {
		public Match_queryContext match_query() {
			return getRuleContext(Match_queryContext.class,0);
		}
		public Crud_commandContext crud_command() {
			return getRuleContext(Crud_commandContext.class,0);
		}
		public Database_commandContext database_command() {
			return getRuleContext(Database_commandContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_command);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match_query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				crud_command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				database_command();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Crud_commandContext extends ParserRuleContext {
		public Vertex_commandContext vertex_command() {
			return getRuleContext(Vertex_commandContext.class,0);
		}
		public Edge_commandContext edge_command() {
			return getRuleContext(Edge_commandContext.class,0);
		}
		public Index_commandContext index_command() {
			return getRuleContext(Index_commandContext.class,0);
		}
		public Crud_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crud_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCrud_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCrud_command(this);
		}
	}

	public final Crud_commandContext crud_command() throws RecognitionException {
		Crud_commandContext _localctx = new Crud_commandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_crud_command);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				vertex_command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				edge_command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				index_command();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vertex_commandContext extends ParserRuleContext {
		public Create_vertexContext create_vertex() {
			return getRuleContext(Create_vertexContext.class,0);
		}
		public Delete_vertexContext delete_vertex() {
			return getRuleContext(Delete_vertexContext.class,0);
		}
		public Update_vertexContext update_vertex() {
			return getRuleContext(Update_vertexContext.class,0);
		}
		public Vertex_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vertex_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterVertex_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitVertex_command(this);
		}
	}

	public final Vertex_commandContext vertex_command() throws RecognitionException {
		Vertex_commandContext _localctx = new Vertex_commandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vertex_command);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				create_vertex();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				delete_vertex();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				update_vertex();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edge_commandContext extends ParserRuleContext {
		public Create_edgeContext create_edge() {
			return getRuleContext(Create_edgeContext.class,0);
		}
		public Delete_edgeContext delete_edge() {
			return getRuleContext(Delete_edgeContext.class,0);
		}
		public Update_edgeContext update_edge() {
			return getRuleContext(Update_edgeContext.class,0);
		}
		public Edge_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterEdge_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitEdge_command(this);
		}
	}

	public final Edge_commandContext edge_command() throws RecognitionException {
		Edge_commandContext _localctx = new Edge_commandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_edge_command);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				create_edge();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				delete_edge();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				update_edge();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_commandContext extends ParserRuleContext {
		public Create_indexContext create_index() {
			return getRuleContext(Create_indexContext.class,0);
		}
		public Delete_indexContext delete_index() {
			return getRuleContext(Delete_indexContext.class,0);
		}
		public Index_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterIndex_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitIndex_command(this);
		}
	}

	public final Index_commandContext index_command() throws RecognitionException {
		Index_commandContext _localctx = new Index_commandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_index_command);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				create_index();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				delete_index();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateContext extends ParserRuleContext {
		public Create_vertexContext create_vertex() {
			return getRuleContext(Create_vertexContext.class,0);
		}
		public Create_edgeContext create_edge() {
			return getRuleContext(Create_edgeContext.class,0);
		}
		public Create_indexContext create_index() {
			return getRuleContext(Create_indexContext.class,0);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCreate(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_create);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(T__0);
				setState(99);
				create_vertex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				create_edge();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				create_index();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteContext extends ParserRuleContext {
		public Delete_vertexContext delete_vertex() {
			return getRuleContext(Delete_vertexContext.class,0);
		}
		public Delete_edgeContext delete_edge() {
			return getRuleContext(Delete_edgeContext.class,0);
		}
		public Delete_indexContext delete_index() {
			return getRuleContext(Delete_indexContext.class,0);
		}
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDelete(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_delete);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(T__1);
				setState(105);
				delete_vertex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				delete_edge();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				delete_index();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateContext extends ParserRuleContext {
		public Update_vertexContext update_vertex() {
			return getRuleContext(Update_vertexContext.class,0);
		}
		public Update_edgeContext update_edge() {
			return getRuleContext(Update_edgeContext.class,0);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitUpdate(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_update);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(T__2);
				setState(111);
				update_vertex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				update_edge();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_vertexContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public Create_vertexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_vertex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCreate_vertex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCreate_vertex(this);
		}
	}

	public final Create_vertexContext create_vertex() throws RecognitionException {
		Create_vertexContext _localctx = new Create_vertexContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_create_vertex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__0);
			setState(116);
			match(T__3);
			setState(117);
			match(T__4);
			setState(118);
			id();
			setState(119);
			match(T__5);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(120);
				label();
				}
			}

			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(123);
				properties();
				}
			}

			setState(126);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_edgeContext extends ParserRuleContext {
		public SourceIdContext sourceId() {
			return getRuleContext(SourceIdContext.class,0);
		}
		public DestinationIdContext destinationId() {
			return getRuleContext(DestinationIdContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public Create_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCreate_edge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCreate_edge(this);
		}
	}

	public final Create_edgeContext create_edge() throws RecognitionException {
		Create_edgeContext _localctx = new Create_edgeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_create_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__0);
			setState(129);
			match(T__7);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(130);
				label();
				}
			}

			setState(133);
			match(T__8);
			setState(134);
			sourceId();
			setState(135);
			match(T__9);
			setState(136);
			destinationId();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(137);
				match(T__10);
				setState(138);
				properties();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_indexContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public Create_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCreate_index(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCreate_index(this);
		}
	}

	public final Create_indexContext create_index() throws RecognitionException {
		Create_indexContext _localctx = new Create_indexContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__0);
			setState(142);
			match(T__11);
			setState(143);
			match(T__12);
			setState(144);
			key();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_vertexContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Delete_vertexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_vertex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDelete_vertex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDelete_vertex(this);
		}
	}

	public final Delete_vertexContext delete_vertex() throws RecognitionException {
		Delete_vertexContext _localctx = new Delete_vertexContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_delete_vertex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__1);
			setState(147);
			match(T__3);
			setState(148);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_edgeContext extends ParserRuleContext {
		public SourceIdContext sourceId() {
			return getRuleContext(SourceIdContext.class,0);
		}
		public DestinationIdContext destinationId() {
			return getRuleContext(DestinationIdContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Delete_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDelete_edge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDelete_edge(this);
		}
	}

	public final Delete_edgeContext delete_edge() throws RecognitionException {
		Delete_edgeContext _localctx = new Delete_edgeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_delete_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__1);
			setState(151);
			match(T__7);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(152);
				label();
				}
			}

			setState(155);
			match(T__8);
			setState(156);
			sourceId();
			setState(157);
			match(T__9);
			setState(158);
			destinationId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_indexContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public Delete_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDelete_index(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDelete_index(this);
		}
	}

	public final Delete_indexContext delete_index() throws RecognitionException {
		Delete_indexContext _localctx = new Delete_indexContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_delete_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__1);
			setState(161);
			match(T__11);
			setState(162);
			match(T__12);
			setState(163);
			key();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_vertexContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Set_clauseContext set_clause() {
			return getRuleContext(Set_clauseContext.class,0);
		}
		public Update_vertexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_vertex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterUpdate_vertex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitUpdate_vertex(this);
		}
	}

	public final Update_vertexContext update_vertex() throws RecognitionException {
		Update_vertexContext _localctx = new Update_vertexContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_update_vertex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__2);
			setState(166);
			match(T__3);
			setState(167);
			id();
			setState(168);
			set_clause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_edgeContext extends ParserRuleContext {
		public SourceIdContext sourceId() {
			return getRuleContext(SourceIdContext.class,0);
		}
		public DestinationIdContext destinationId() {
			return getRuleContext(DestinationIdContext.class,0);
		}
		public Set_clauseContext set_clause() {
			return getRuleContext(Set_clauseContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Update_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterUpdate_edge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitUpdate_edge(this);
		}
	}

	public final Update_edgeContext update_edge() throws RecognitionException {
		Update_edgeContext _localctx = new Update_edgeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_update_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__2);
			setState(171);
			match(T__7);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(172);
				label();
				}
			}

			setState(175);
			match(T__8);
			setState(176);
			sourceId();
			setState(177);
			match(T__9);
			setState(178);
			destinationId();
			setState(179);
			set_clause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceIdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public SourceIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSourceId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSourceId(this);
		}
	}

	public final SourceIdContext sourceId() throws RecognitionException {
		SourceIdContext _localctx = new SourceIdContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sourceId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DestinationIdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public DestinationIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destinationId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDestinationId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDestinationId(this);
		}
	}

	public final DestinationIdContext destinationId() throws RecognitionException {
		DestinationIdContext _localctx = new DestinationIdContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_destinationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_clauseContext extends ParserRuleContext {
		public List<Set_itemContext> set_item() {
			return getRuleContexts(Set_itemContext.class);
		}
		public Set_itemContext set_item(int i) {
			return getRuleContext(Set_itemContext.class,i);
		}
		public Set_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSet_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSet_clause(this);
		}
	}

	public final Set_clauseContext set_clause() throws RecognitionException {
		Set_clauseContext _localctx = new Set_clauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_set_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__13);
			setState(186);
			set_item();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(187);
				match(T__14);
				setState(188);
				set_item();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_itemContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Set_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSet_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSet_item(this);
		}
	}

	public final Set_itemContext set_item() throws RecognitionException {
		Set_itemContext _localctx = new Set_itemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_set_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			key();
			setState(195);
			match(T__15);
			setState(196);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertiesContext extends ParserRuleContext {
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitProperties(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_properties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__16);
			setState(199);
			property();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(200);
				match(T__14);
				setState(201);
				property();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			key();
			setState(210);
			match(T__15);
			setState(211);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QlParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QlParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Database_commandContext extends ParserRuleContext {
		public Create_databaseContext create_database() {
			return getRuleContext(Create_databaseContext.class,0);
		}
		public Delete_databaseContext delete_database() {
			return getRuleContext(Delete_databaseContext.class,0);
		}
		public Drop_databaseContext drop_database() {
			return getRuleContext(Drop_databaseContext.class,0);
		}
		public Switch_databaseContext switch_database() {
			return getRuleContext(Switch_databaseContext.class,0);
		}
		public Get_curr_databaseContext get_curr_database() {
			return getRuleContext(Get_curr_databaseContext.class,0);
		}
		public Switch_database_to_defaultContext switch_database_to_default() {
			return getRuleContext(Switch_database_to_defaultContext.class,0);
		}
		public Drop_default_databaseContext drop_default_database() {
			return getRuleContext(Drop_default_databaseContext.class,0);
		}
		public Database_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDatabase_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDatabase_command(this);
		}
	}

	public final Database_commandContext database_command() throws RecognitionException {
		Database_commandContext _localctx = new Database_commandContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_database_command);
		try {
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				create_database();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				delete_database();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				drop_database();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				switch_database();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
				get_curr_database();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(226);
				switch_database_to_default();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(227);
				drop_default_database();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_databaseContext extends ParserRuleContext {
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Create_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterCreate_database(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitCreate_database(this);
		}
	}

	public final Create_databaseContext create_database() throws RecognitionException {
		Create_databaseContext _localctx = new Create_databaseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_create_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(T__0);
			setState(231);
			match(T__18);
			setState(232);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_databaseContext extends ParserRuleContext {
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Delete_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDelete_database(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDelete_database(this);
		}
	}

	public final Delete_databaseContext delete_database() throws RecognitionException {
		Delete_databaseContext _localctx = new Delete_databaseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_delete_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__1);
			setState(235);
			match(T__18);
			setState(236);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_databaseContext extends ParserRuleContext {
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDrop_database(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDrop_database(this);
		}
	}

	public final Drop_databaseContext drop_database() throws RecognitionException {
		Drop_databaseContext _localctx = new Drop_databaseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_drop_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__19);
			setState(239);
			match(T__18);
			setState(240);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Switch_databaseContext extends ParserRuleContext {
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Switch_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSwitch_database(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSwitch_database(this);
		}
	}

	public final Switch_databaseContext switch_database() throws RecognitionException {
		Switch_databaseContext _localctx = new Switch_databaseContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_switch_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__20);
			setState(243);
			match(T__18);
			setState(244);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Get_curr_databaseContext extends ParserRuleContext {
		public Get_curr_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_curr_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterGet_curr_database(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitGet_curr_database(this);
		}
	}

	public final Get_curr_databaseContext get_curr_database() throws RecognitionException {
		Get_curr_databaseContext _localctx = new Get_curr_databaseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_get_curr_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__21);
			setState(247);
			match(T__22);
			setState(248);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Switch_database_to_defaultContext extends ParserRuleContext {
		public Switch_database_to_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_database_to_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSwitch_database_to_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSwitch_database_to_default(this);
		}
	}

	public final Switch_database_to_defaultContext switch_database_to_default() throws RecognitionException {
		Switch_database_to_defaultContext _localctx = new Switch_database_to_defaultContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_switch_database_to_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__20);
			setState(251);
			match(T__18);
			setState(252);
			match(T__9);
			setState(253);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_default_databaseContext extends ParserRuleContext {
		public Drop_default_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_default_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDrop_default_database(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDrop_default_database(this);
		}
	}

	public final Drop_default_databaseContext drop_default_database() throws RecognitionException {
		Drop_default_databaseContext _localctx = new Drop_default_databaseContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_drop_default_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__19);
			setState(256);
			match(T__23);
			setState(257);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Database_nameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public Database_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterDatabase_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitDatabase_name(this);
		}
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Match_queryContext extends ParserRuleContext {
		public Match_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterMatch_query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitMatch_query(this);
		}
	}

	public final Match_queryContext match_query() throws RecognitionException {
		Match_queryContext _localctx = new Match_queryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_match_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			command();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u010c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\5\2P\n\2\3\3\3\3\3\3\5"+
		"\3U\n\3\3\4\3\4\3\4\5\4Z\n\4\3\5\3\5\3\5\5\5_\n\5\3\6\3\6\5\6c\n\6\3\7"+
		"\3\7\3\7\3\7\5\7i\n\7\3\b\3\b\3\b\3\b\5\bo\n\b\3\t\3\t\3\t\5\tt\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n|\n\n\3\n\5\n\177\n\n\3\n\3\n\3\13\3\13\3\13"+
		"\5\13\u0086\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008e\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u009c\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\5\21\u00b0\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\7\24\u00c0\n\24\f\24\16\24\u00c3\13\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00cd\n\26\f\26\16\26\u00d0\13"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00e7\n\34\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\2\2\'\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\3\3\2\34"+
		"\36\2\u0102\2O\3\2\2\2\4T\3\2\2\2\6Y\3\2\2\2\b^\3\2\2\2\nb\3\2\2\2\fh"+
		"\3\2\2\2\16n\3\2\2\2\20s\3\2\2\2\22u\3\2\2\2\24\u0082\3\2\2\2\26\u008f"+
		"\3\2\2\2\30\u0094\3\2\2\2\32\u0098\3\2\2\2\34\u00a2\3\2\2\2\36\u00a7\3"+
		"\2\2\2 \u00ac\3\2\2\2\"\u00b7\3\2\2\2$\u00b9\3\2\2\2&\u00bb\3\2\2\2(\u00c4"+
		"\3\2\2\2*\u00c8\3\2\2\2,\u00d3\3\2\2\2.\u00d7\3\2\2\2\60\u00d9\3\2\2\2"+
		"\62\u00db\3\2\2\2\64\u00dd\3\2\2\2\66\u00e6\3\2\2\28\u00e8\3\2\2\2:\u00ec"+
		"\3\2\2\2<\u00f0\3\2\2\2>\u00f4\3\2\2\2@\u00f8\3\2\2\2B\u00fc\3\2\2\2D"+
		"\u0101\3\2\2\2F\u0105\3\2\2\2H\u0107\3\2\2\2J\u0109\3\2\2\2LP\5H%\2MP"+
		"\5\4\3\2NP\5\66\34\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\3\3\2\2\2QU\5\6\4"+
		"\2RU\5\b\5\2SU\5\n\6\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\5\3\2\2\2VZ\5\22"+
		"\n\2WZ\5\30\r\2XZ\5\36\20\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\7\3\2\2\2["+
		"_\5\24\13\2\\_\5\32\16\2]_\5 \21\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\t\3"+
		"\2\2\2`c\5\26\f\2ac\5\34\17\2b`\3\2\2\2ba\3\2\2\2c\13\3\2\2\2de\7\3\2"+
		"\2ei\5\22\n\2fi\5\24\13\2gi\5\26\f\2hd\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\r"+
		"\3\2\2\2jk\7\4\2\2ko\5\30\r\2lo\5\32\16\2mo\5\34\17\2nj\3\2\2\2nl\3\2"+
		"\2\2nm\3\2\2\2o\17\3\2\2\2pq\7\5\2\2qt\5\36\20\2rt\5 \21\2sp\3\2\2\2s"+
		"r\3\2\2\2t\21\3\2\2\2uv\7\3\2\2vw\7\6\2\2wx\7\7\2\2xy\5\64\33\2y{\7\b"+
		"\2\2z|\5.\30\2{z\3\2\2\2{|\3\2\2\2|~\3\2\2\2}\177\5*\26\2~}\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\t\2\2\u0081\23\3\2\2\2\u0082"+
		"\u0083\7\3\2\2\u0083\u0085\7\n\2\2\u0084\u0086\5.\30\2\u0085\u0084\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\13\2\2\u0088"+
		"\u0089\5\"\22\2\u0089\u008a\7\f\2\2\u008a\u008d\5$\23\2\u008b\u008c\7"+
		"\r\2\2\u008c\u008e\5*\26\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\25\3\2\2\2\u008f\u0090\7\3\2\2\u0090\u0091\7\16\2\2\u0091\u0092\7\17"+
		"\2\2\u0092\u0093\5\60\31\2\u0093\27\3\2\2\2\u0094\u0095\7\4\2\2\u0095"+
		"\u0096\7\6\2\2\u0096\u0097\5\64\33\2\u0097\31\3\2\2\2\u0098\u0099\7\4"+
		"\2\2\u0099\u009b\7\n\2\2\u009a\u009c\5.\30\2\u009b\u009a\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\13\2\2\u009e\u009f\5"+
		"\"\22\2\u009f\u00a0\7\f\2\2\u00a0\u00a1\5$\23\2\u00a1\33\3\2\2\2\u00a2"+
		"\u00a3\7\4\2\2\u00a3\u00a4\7\16\2\2\u00a4\u00a5\7\17\2\2\u00a5\u00a6\5"+
		"\60\31\2\u00a6\35\3\2\2\2\u00a7\u00a8\7\5\2\2\u00a8\u00a9\7\6\2\2\u00a9"+
		"\u00aa\5\64\33\2\u00aa\u00ab\5&\24\2\u00ab\37\3\2\2\2\u00ac\u00ad\7\5"+
		"\2\2\u00ad\u00af\7\n\2\2\u00ae\u00b0\5.\30\2\u00af\u00ae\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\5"+
		"\"\22\2\u00b3\u00b4\7\f\2\2\u00b4\u00b5\5$\23\2\u00b5\u00b6\5&\24\2\u00b6"+
		"!\3\2\2\2\u00b7\u00b8\5\64\33\2\u00b8#\3\2\2\2\u00b9\u00ba\5\64\33\2\u00ba"+
		"%\3\2\2\2\u00bb\u00bc\7\20\2\2\u00bc\u00c1\5(\25\2\u00bd\u00be\7\21\2"+
		"\2\u00be\u00c0\5(\25\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\'\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c5\5\60\31\2\u00c5\u00c6\7\22\2\2\u00c6\u00c7\5\62\32\2\u00c7)\3\2"+
		"\2\2\u00c8\u00c9\7\23\2\2\u00c9\u00ce\5,\27\2\u00ca\u00cb\7\21\2\2\u00cb"+
		"\u00cd\5,\27\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1"+
		"\u00d2\7\24\2\2\u00d2+\3\2\2\2\u00d3\u00d4\5\60\31\2\u00d4\u00d5\7\22"+
		"\2\2\u00d5\u00d6\5\62\32\2\u00d6-\3\2\2\2\u00d7\u00d8\7\34\2\2\u00d8/"+
		"\3\2\2\2\u00d9\u00da\7\34\2\2\u00da\61\3\2\2\2\u00db\u00dc\t\2\2\2\u00dc"+
		"\63\3\2\2\2\u00dd\u00de\7\34\2\2\u00de\65\3\2\2\2\u00df\u00e7\58\35\2"+
		"\u00e0\u00e7\5:\36\2\u00e1\u00e7\5<\37\2\u00e2\u00e7\5> \2\u00e3\u00e7"+
		"\5@!\2\u00e4\u00e7\5B\"\2\u00e5\u00e7\5D#\2\u00e6\u00df\3\2\2\2\u00e6"+
		"\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\67\3\2\2\2\u00e8\u00e9"+
		"\7\3\2\2\u00e9\u00ea\7\25\2\2\u00ea\u00eb\5F$\2\u00eb9\3\2\2\2\u00ec\u00ed"+
		"\7\4\2\2\u00ed\u00ee\7\25\2\2\u00ee\u00ef\5F$\2\u00ef;\3\2\2\2\u00f0\u00f1"+
		"\7\26\2\2\u00f1\u00f2\7\25\2\2\u00f2\u00f3\5F$\2\u00f3=\3\2\2\2\u00f4"+
		"\u00f5\7\27\2\2\u00f5\u00f6\7\25\2\2\u00f6\u00f7\5F$\2\u00f7?\3\2\2\2"+
		"\u00f8\u00f9\7\30\2\2\u00f9\u00fa\7\31\2\2\u00fa\u00fb\7\25\2\2\u00fb"+
		"A\3\2\2\2\u00fc\u00fd\7\27\2\2\u00fd\u00fe\7\25\2\2\u00fe\u00ff\7\f\2"+
		"\2\u00ff\u0100\7\32\2\2\u0100C\3\2\2\2\u0101\u0102\7\26\2\2\u0102\u0103"+
		"\7\32\2\2\u0103\u0104\7\25\2\2\u0104E\3\2\2\2\u0105\u0106\7\34\2\2\u0106"+
		"G\3\2\2\2\u0107\u0108\7\33\2\2\u0108I\3\2\2\2\u0109\u010a\5\2\2\2\u010a"+
		"K\3\2\2\2\23OTY^bhns{~\u0085\u008d\u009b\u00af\u00c1\u00ce\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}