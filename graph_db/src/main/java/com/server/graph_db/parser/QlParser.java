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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, STRING=38, 
		INT=39, FLOAT=40, WS=41;
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
		RULE_path_query = 36, RULE_path = 37, RULE_starting_vertex = 38, RULE_path_level = 39, 
		RULE_vertex_binding = 40, RULE_alias = 41, RULE_variable = 42, RULE_edge_binding = 43, 
		RULE_out_edge_binding = 44, RULE_in_edge_binding = 45, RULE_selectOperators = 46, 
		RULE_selectOperator = 47, RULE_fieldName = 48, RULE_fieldValue = 49, RULE_operator = 50, 
		RULE_where_clause = 51, RULE_return_clause = 52, RULE_return_item = 53, 
		RULE_start = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"command", "crud_command", "vertex_command", "edge_command", "index_command", 
			"create", "delete", "update", "create_vertex", "create_edge", "create_index", 
			"delete_vertex", "delete_edge", "delete_index", "update_vertex", "update_edge", 
			"sourceId", "destinationId", "set_clause", "set_item", "properties", 
			"property", "label", "key", "value", "id", "database_command", "create_database", 
			"delete_database", "drop_database", "switch_database", "get_curr_database", 
			"switch_database_to_default", "drop_default_database", "database_name", 
			"match_query", "path_query", "path", "starting_vertex", "path_level", 
			"vertex_binding", "alias", "variable", "edge_binding", "out_edge_binding", 
			"in_edge_binding", "selectOperators", "selectOperator", "fieldName", 
			"fieldValue", "operator", "where_clause", "return_clause", "return_item", 
			"start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CREATE'", "'DELETE'", "'UPDATE'", "'VERTEX'", "'('", "':'", "')'", 
			"'EDGE'", "'FROM'", "'TO'", "'WITH'", "'INDEX'", "'ON'", "'SET'", "','", 
			"'='", "'{'", "'}'", "'DATABASE'", "'DROP'", "'SWITCH'", "'GET'", "'CURRENT'", 
			"'DEFAULT'", "'MATCH'", "'AS'", "'-'", "'->'", "'<-'", "'<>'", "'<'", 
			"'>'", "'<='", "'>='", "'WHERE'", "'RETURN'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
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
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match_query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				crud_command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				vertex_command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				edge_command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
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
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				create_vertex();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				delete_vertex();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
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
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				create_edge();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				delete_edge();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
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
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				create_index();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
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
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(T__0);
				setState(135);
				create_vertex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				create_edge();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
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
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(T__1);
				setState(141);
				delete_vertex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				delete_edge();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
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
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(T__2);
				setState(147);
				update_vertex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
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
			setState(151);
			match(T__0);
			setState(152);
			match(T__3);
			setState(153);
			match(T__4);
			setState(154);
			id();
			setState(155);
			match(T__5);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(156);
				label();
				}
			}

			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(159);
				properties();
				}
			}

			setState(162);
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
			setState(164);
			match(T__0);
			setState(165);
			match(T__7);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(166);
				label();
				}
			}

			setState(169);
			match(T__8);
			setState(170);
			sourceId();
			setState(171);
			match(T__9);
			setState(172);
			destinationId();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(173);
				match(T__10);
				setState(174);
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
			setState(177);
			match(T__0);
			setState(178);
			match(T__11);
			setState(179);
			match(T__12);
			setState(180);
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
			setState(182);
			match(T__1);
			setState(183);
			match(T__3);
			setState(184);
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
			setState(186);
			match(T__1);
			setState(187);
			match(T__7);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(188);
				label();
				}
			}

			setState(191);
			match(T__8);
			setState(192);
			sourceId();
			setState(193);
			match(T__9);
			setState(194);
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
			setState(196);
			match(T__1);
			setState(197);
			match(T__11);
			setState(198);
			match(T__12);
			setState(199);
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
			setState(201);
			match(T__2);
			setState(202);
			match(T__3);
			setState(203);
			id();
			setState(204);
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
			setState(206);
			match(T__2);
			setState(207);
			match(T__7);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(208);
				label();
				}
			}

			setState(211);
			match(T__8);
			setState(212);
			sourceId();
			setState(213);
			match(T__9);
			setState(214);
			destinationId();
			setState(215);
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
			setState(217);
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
			setState(219);
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
			setState(221);
			match(T__13);
			setState(222);
			set_item();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(223);
				match(T__14);
				setState(224);
				set_item();
				}
				}
				setState(229);
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
			setState(230);
			key();
			setState(231);
			match(T__15);
			setState(232);
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
			setState(234);
			match(T__16);
			setState(235);
			property();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(236);
				match(T__14);
				setState(237);
				property();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(243);
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
			setState(245);
			key();
			setState(246);
			match(T__5);
			setState(247);
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
			setState(249);
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
			setState(251);
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
			setState(253);
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
			setState(255);
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
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				create_database();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				delete_database();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				drop_database();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(260);
				switch_database();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(261);
				get_curr_database();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(262);
				switch_database_to_default();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				drop_default_database();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(264);
				get_curr_database();
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
			setState(267);
			match(T__0);
			setState(268);
			match(T__18);
			setState(269);
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
			setState(271);
			match(T__1);
			setState(272);
			match(T__18);
			setState(273);
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
			setState(275);
			match(T__19);
			setState(276);
			match(T__18);
			setState(277);
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
			setState(279);
			match(T__20);
			setState(280);
			match(T__18);
			setState(281);
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
			setState(283);
			match(T__21);
			setState(284);
			match(T__22);
			setState(285);
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
			setState(287);
			match(T__20);
			setState(288);
			match(T__18);
			setState(289);
			match(T__9);
			setState(290);
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
			setState(292);
			match(T__19);
			setState(293);
			match(T__23);
			setState(294);
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
			setState(296);
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
		public Path_queryContext path_query() {
			return getRuleContext(Path_queryContext.class,0);
		}
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
			setState(298);
			match(T__24);
			setState(299);
			path_query();
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

	public static class Path_queryContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Return_clauseContext return_clause() {
			return getRuleContext(Return_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Path_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterPath_query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitPath_query(this);
		}
	}

	public final Path_queryContext path_query() throws RecognitionException {
		Path_queryContext _localctx = new Path_queryContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_path_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			path();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(302);
				where_clause();
				}
			}

			setState(305);
			return_clause();
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

	public static class PathContext extends ParserRuleContext {
		public Starting_vertexContext starting_vertex() {
			return getRuleContext(Starting_vertexContext.class,0);
		}
		public List<Path_levelContext> path_level() {
			return getRuleContexts(Path_levelContext.class);
		}
		public Path_levelContext path_level(int i) {
			return getRuleContext(Path_levelContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			starting_vertex();
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__26 || _la==T__28) {
				{
				{
				setState(308);
				path_level();
				}
				}
				setState(313);
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

	public static class Starting_vertexContext extends ParserRuleContext {
		public Vertex_bindingContext vertex_binding() {
			return getRuleContext(Vertex_bindingContext.class,0);
		}
		public Starting_vertexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starting_vertex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterStarting_vertex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitStarting_vertex(this);
		}
	}

	public final Starting_vertexContext starting_vertex() throws RecognitionException {
		Starting_vertexContext _localctx = new Starting_vertexContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_starting_vertex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			vertex_binding();
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

	public static class Path_levelContext extends ParserRuleContext {
		public Edge_bindingContext edge_binding() {
			return getRuleContext(Edge_bindingContext.class,0);
		}
		public Vertex_bindingContext vertex_binding() {
			return getRuleContext(Vertex_bindingContext.class,0);
		}
		public Path_levelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterPath_level(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitPath_level(this);
		}
	}

	public final Path_levelContext path_level() throws RecognitionException {
		Path_levelContext _localctx = new Path_levelContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_path_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			edge_binding();
			setState(317);
			vertex_binding();
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

	public static class Vertex_bindingContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public SelectOperatorsContext selectOperators() {
			return getRuleContext(SelectOperatorsContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public Vertex_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vertex_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterVertex_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitVertex_binding(this);
		}
	}

	public final Vertex_bindingContext vertex_binding() throws RecognitionException {
		Vertex_bindingContext _localctx = new Vertex_bindingContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_vertex_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(T__4);
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(320);
				id();
				}
			}

			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(323);
				match(T__5);
				setState(324);
				label();
				}
			}

			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(327);
				selectOperators();
				}
			}

			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(330);
				alias();
				}
			}

			setState(333);
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

	public static class AliasContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__25);
			setState(336);
			variable();
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
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

	public static class Edge_bindingContext extends ParserRuleContext {
		public Out_edge_bindingContext out_edge_binding() {
			return getRuleContext(Out_edge_bindingContext.class,0);
		}
		public In_edge_bindingContext in_edge_binding() {
			return getRuleContext(In_edge_bindingContext.class,0);
		}
		public Edge_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterEdge_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitEdge_binding(this);
		}
	}

	public final Edge_bindingContext edge_binding() throws RecognitionException {
		Edge_bindingContext _localctx = new Edge_bindingContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_edge_binding);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				out_edge_binding();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				in_edge_binding();
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

	public static class Out_edge_bindingContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public SelectOperatorsContext selectOperators() {
			return getRuleContext(SelectOperatorsContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public Out_edge_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_out_edge_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterOut_edge_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitOut_edge_binding(this);
		}
	}

	public final Out_edge_bindingContext out_edge_binding() throws RecognitionException {
		Out_edge_bindingContext _localctx = new Out_edge_bindingContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_out_edge_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(T__26);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(345);
				label();
				}
			}

			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(348);
				match(T__10);
				setState(349);
				selectOperators();
				}
			}

			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(352);
				alias();
				}
			}

			setState(355);
			match(T__27);
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

	public static class In_edge_bindingContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public SelectOperatorsContext selectOperators() {
			return getRuleContext(SelectOperatorsContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public In_edge_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_edge_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterIn_edge_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitIn_edge_binding(this);
		}
	}

	public final In_edge_bindingContext in_edge_binding() throws RecognitionException {
		In_edge_bindingContext _localctx = new In_edge_bindingContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_in_edge_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(T__28);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(358);
				label();
				}
			}

			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(361);
				match(T__10);
				setState(362);
				selectOperators();
				}
			}

			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(365);
				alias();
				}
			}

			setState(368);
			match(T__26);
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

	public static class SelectOperatorsContext extends ParserRuleContext {
		public List<SelectOperatorContext> selectOperator() {
			return getRuleContexts(SelectOperatorContext.class);
		}
		public SelectOperatorContext selectOperator(int i) {
			return getRuleContext(SelectOperatorContext.class,i);
		}
		public SelectOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSelectOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSelectOperators(this);
		}
	}

	public final SelectOperatorsContext selectOperators() throws RecognitionException {
		SelectOperatorsContext _localctx = new SelectOperatorsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_selectOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__16);
			setState(371);
			selectOperator();
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(372);
				match(T__14);
				setState(373);
				selectOperator();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(379);
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

	public static class SelectOperatorContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public FieldValueContext fieldValue() {
			return getRuleContext(FieldValueContext.class,0);
		}
		public SelectOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterSelectOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitSelectOperator(this);
		}
	}

	public final SelectOperatorContext selectOperator() throws RecognitionException {
		SelectOperatorContext _localctx = new SelectOperatorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_selectOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			fieldName();
			setState(382);
			operator();
			setState(383);
			fieldValue();
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

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
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

	public static class FieldValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QlParser.STRING, 0); }
		public TerminalNode INT() { return getToken(QlParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QlParser.FLOAT, 0); }
		public FieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitFieldValue(this);
		}
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_fieldValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
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

	public static class Where_clauseContext extends ParserRuleContext {
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitWhere_clause(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(T__34);
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

	public static class Return_clauseContext extends ParserRuleContext {
		public List<Return_itemContext> return_item() {
			return getRuleContexts(Return_itemContext.class);
		}
		public Return_itemContext return_item(int i) {
			return getRuleContext(Return_itemContext.class,i);
		}
		public Return_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterReturn_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitReturn_clause(this);
		}
	}

	public final Return_clauseContext return_clause() throws RecognitionException {
		Return_clauseContext _localctx = new Return_clauseContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_return_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(T__35);
			setState(394);
			return_item();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(395);
				match(T__14);
				setState(396);
				return_item();
				}
				}
				setState(401);
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

	public static class Return_itemContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public Return_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).enterReturn_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlListener ) ((QlListener)listener).exitReturn_item(this);
		}
	}

	public final Return_itemContext return_item() throws RecognitionException {
		Return_itemContext _localctx = new Return_itemContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_return_item);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				variable();
				setState(404);
				match(T__36);
				setState(405);
				fieldName();
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
		enterRule(_localctx, 108, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u019e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\5\2t\n\2\3\3\3\3\3"+
		"\3\5\3y\n\3\3\4\3\4\3\4\5\4~\n\4\3\5\3\5\3\5\5\5\u0083\n\5\3\6\3\6\5\6"+
		"\u0087\n\6\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\b\3\b\3\b\3\b\5\b\u0093\n\b"+
		"\3\t\3\t\3\t\5\t\u0098\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a0\n\n\3\n\5"+
		"\n\u00a3\n\n\3\n\3\n\3\13\3\13\3\13\5\13\u00aa\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00b2\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\5\16\u00c0\n\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u00d4\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00e4"+
		"\n\24\f\24\16\24\u00e7\13\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7"+
		"\26\u00f1\n\26\f\26\16\26\u00f4\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\5\34\u010c\n\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3$\3$\3%\3%\3%\3&\3&\5&\u0132\n&\3&\3&\3\'\3\'\7\'\u0138\n\'\f\'\16"+
		"\'\u013b\13\'\3(\3(\3)\3)\3)\3*\3*\5*\u0144\n*\3*\3*\5*\u0148\n*\3*\5"+
		"*\u014b\n*\3*\5*\u014e\n*\3*\3*\3+\3+\3+\3,\3,\3-\3-\5-\u0159\n-\3.\3"+
		".\5.\u015d\n.\3.\3.\5.\u0161\n.\3.\5.\u0164\n.\3.\3.\3/\3/\5/\u016a\n"+
		"/\3/\3/\5/\u016e\n/\3/\5/\u0171\n/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0179"+
		"\n\60\f\60\16\60\u017c\13\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u0190\n\66\f\66"+
		"\16\66\u0193\13\66\3\67\3\67\3\67\3\67\3\67\5\67\u019a\n\67\38\38\38\2"+
		"\29\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`bdfhjln\2\4\3\2(*\4\2\22\22 $\2\u0193\2s\3\2\2\2\4x\3"+
		"\2\2\2\6}\3\2\2\2\b\u0082\3\2\2\2\n\u0086\3\2\2\2\f\u008c\3\2\2\2\16\u0092"+
		"\3\2\2\2\20\u0097\3\2\2\2\22\u0099\3\2\2\2\24\u00a6\3\2\2\2\26\u00b3\3"+
		"\2\2\2\30\u00b8\3\2\2\2\32\u00bc\3\2\2\2\34\u00c6\3\2\2\2\36\u00cb\3\2"+
		"\2\2 \u00d0\3\2\2\2\"\u00db\3\2\2\2$\u00dd\3\2\2\2&\u00df\3\2\2\2(\u00e8"+
		"\3\2\2\2*\u00ec\3\2\2\2,\u00f7\3\2\2\2.\u00fb\3\2\2\2\60\u00fd\3\2\2\2"+
		"\62\u00ff\3\2\2\2\64\u0101\3\2\2\2\66\u010b\3\2\2\28\u010d\3\2\2\2:\u0111"+
		"\3\2\2\2<\u0115\3\2\2\2>\u0119\3\2\2\2@\u011d\3\2\2\2B\u0121\3\2\2\2D"+
		"\u0126\3\2\2\2F\u012a\3\2\2\2H\u012c\3\2\2\2J\u012f\3\2\2\2L\u0135\3\2"+
		"\2\2N\u013c\3\2\2\2P\u013e\3\2\2\2R\u0141\3\2\2\2T\u0151\3\2\2\2V\u0154"+
		"\3\2\2\2X\u0158\3\2\2\2Z\u015a\3\2\2\2\\\u0167\3\2\2\2^\u0174\3\2\2\2"+
		"`\u017f\3\2\2\2b\u0183\3\2\2\2d\u0185\3\2\2\2f\u0187\3\2\2\2h\u0189\3"+
		"\2\2\2j\u018b\3\2\2\2l\u0199\3\2\2\2n\u019b\3\2\2\2pt\5H%\2qt\5\4\3\2"+
		"rt\5\66\34\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\3\3\2\2\2uy\5\6\4\2vy\5\b"+
		"\5\2wy\5\n\6\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\5\3\2\2\2z~\5\22\n\2{~\5"+
		"\30\r\2|~\5\36\20\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\7\3\2\2\2\177\u0083"+
		"\5\24\13\2\u0080\u0083\5\32\16\2\u0081\u0083\5 \21\2\u0082\177\3\2\2\2"+
		"\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\t\3\2\2\2\u0084\u0087\5"+
		"\26\f\2\u0085\u0087\5\34\17\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2"+
		"\u0087\13\3\2\2\2\u0088\u0089\7\3\2\2\u0089\u008d\5\22\n\2\u008a\u008d"+
		"\5\24\13\2\u008b\u008d\5\26\f\2\u008c\u0088\3\2\2\2\u008c\u008a\3\2\2"+
		"\2\u008c\u008b\3\2\2\2\u008d\r\3\2\2\2\u008e\u008f\7\4\2\2\u008f\u0093"+
		"\5\30\r\2\u0090\u0093\5\32\16\2\u0091\u0093\5\34\17\2\u0092\u008e\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\17\3\2\2\2\u0094\u0095"+
		"\7\5\2\2\u0095\u0098\5\36\20\2\u0096\u0098\5 \21\2\u0097\u0094\3\2\2\2"+
		"\u0097\u0096\3\2\2\2\u0098\21\3\2\2\2\u0099\u009a\7\3\2\2\u009a\u009b"+
		"\7\6\2\2\u009b\u009c\7\7\2\2\u009c\u009d\5\64\33\2\u009d\u009f\7\b\2\2"+
		"\u009e\u00a0\5.\30\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2"+
		"\3\2\2\2\u00a1\u00a3\5*\26\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\7\t\2\2\u00a5\23\3\2\2\2\u00a6\u00a7\7\3\2"+
		"\2\u00a7\u00a9\7\n\2\2\u00a8\u00aa\5.\30\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\13\2\2\u00ac\u00ad\5\"\22\2"+
		"\u00ad\u00ae\7\f\2\2\u00ae\u00b1\5$\23\2\u00af\u00b0\7\r\2\2\u00b0\u00b2"+
		"\5*\26\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\25\3\2\2\2\u00b3"+
		"\u00b4\7\3\2\2\u00b4\u00b5\7\16\2\2\u00b5\u00b6\7\17\2\2\u00b6\u00b7\5"+
		"\60\31\2\u00b7\27\3\2\2\2\u00b8\u00b9\7\4\2\2\u00b9\u00ba\7\6\2\2\u00ba"+
		"\u00bb\5\64\33\2\u00bb\31\3\2\2\2\u00bc\u00bd\7\4\2\2\u00bd\u00bf\7\n"+
		"\2\2\u00be\u00c0\5.\30\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\7\13\2\2\u00c2\u00c3\5\"\22\2\u00c3\u00c4\7"+
		"\f\2\2\u00c4\u00c5\5$\23\2\u00c5\33\3\2\2\2\u00c6\u00c7\7\4\2\2\u00c7"+
		"\u00c8\7\16\2\2\u00c8\u00c9\7\17\2\2\u00c9\u00ca\5\60\31\2\u00ca\35\3"+
		"\2\2\2\u00cb\u00cc\7\5\2\2\u00cc\u00cd\7\6\2\2\u00cd\u00ce\5\64\33\2\u00ce"+
		"\u00cf\5&\24\2\u00cf\37\3\2\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d3\7\n\2"+
		"\2\u00d2\u00d4\5.\30\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\7\13\2\2\u00d6\u00d7\5\"\22\2\u00d7\u00d8\7\f\2\2"+
		"\u00d8\u00d9\5$\23\2\u00d9\u00da\5&\24\2\u00da!\3\2\2\2\u00db\u00dc\5"+
		"\64\33\2\u00dc#\3\2\2\2\u00dd\u00de\5\64\33\2\u00de%\3\2\2\2\u00df\u00e0"+
		"\7\20\2\2\u00e0\u00e5\5(\25\2\u00e1\u00e2\7\21\2\2\u00e2\u00e4\5(\25\2"+
		"\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\'\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\5\60\31\2\u00e9"+
		"\u00ea\7\22\2\2\u00ea\u00eb\5\62\32\2\u00eb)\3\2\2\2\u00ec\u00ed\7\23"+
		"\2\2\u00ed\u00f2\5,\27\2\u00ee\u00ef\7\21\2\2\u00ef\u00f1\5,\27\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7\24\2\2\u00f6"+
		"+\3\2\2\2\u00f7\u00f8\5\60\31\2\u00f8\u00f9\7\b\2\2\u00f9\u00fa\5\62\32"+
		"\2\u00fa-\3\2\2\2\u00fb\u00fc\7(\2\2\u00fc/\3\2\2\2\u00fd\u00fe\7(\2\2"+
		"\u00fe\61\3\2\2\2\u00ff\u0100\t\2\2\2\u0100\63\3\2\2\2\u0101\u0102\7("+
		"\2\2\u0102\65\3\2\2\2\u0103\u010c\58\35\2\u0104\u010c\5:\36\2\u0105\u010c"+
		"\5<\37\2\u0106\u010c\5> \2\u0107\u010c\5@!\2\u0108\u010c\5B\"\2\u0109"+
		"\u010c\5D#\2\u010a\u010c\5@!\2\u010b\u0103\3\2\2\2\u010b\u0104\3\2\2\2"+
		"\u010b\u0105\3\2\2\2\u010b\u0106\3\2\2\2\u010b\u0107\3\2\2\2\u010b\u0108"+
		"\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\67\3\2\2\2\u010d"+
		"\u010e\7\3\2\2\u010e\u010f\7\25\2\2\u010f\u0110\5F$\2\u01109\3\2\2\2\u0111"+
		"\u0112\7\4\2\2\u0112\u0113\7\25\2\2\u0113\u0114\5F$\2\u0114;\3\2\2\2\u0115"+
		"\u0116\7\26\2\2\u0116\u0117\7\25\2\2\u0117\u0118\5F$\2\u0118=\3\2\2\2"+
		"\u0119\u011a\7\27\2\2\u011a\u011b\7\25\2\2\u011b\u011c\5F$\2\u011c?\3"+
		"\2\2\2\u011d\u011e\7\30\2\2\u011e\u011f\7\31\2\2\u011f\u0120\7\25\2\2"+
		"\u0120A\3\2\2\2\u0121\u0122\7\27\2\2\u0122\u0123\7\25\2\2\u0123\u0124"+
		"\7\f\2\2\u0124\u0125\7\32\2\2\u0125C\3\2\2\2\u0126\u0127\7\26\2\2\u0127"+
		"\u0128\7\32\2\2\u0128\u0129\7\25\2\2\u0129E\3\2\2\2\u012a\u012b\7(\2\2"+
		"\u012bG\3\2\2\2\u012c\u012d\7\33\2\2\u012d\u012e\5J&\2\u012eI\3\2\2\2"+
		"\u012f\u0131\5L\'\2\u0130\u0132\5h\65\2\u0131\u0130\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\5j\66\2\u0134K\3\2\2\2\u0135"+
		"\u0139\5N(\2\u0136\u0138\5P)\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2"+
		"\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013aM\3\2\2\2\u013b\u0139\3"+
		"\2\2\2\u013c\u013d\5R*\2\u013dO\3\2\2\2\u013e\u013f\5X-\2\u013f\u0140"+
		"\5R*\2\u0140Q\3\2\2\2\u0141\u0143\7\7\2\2\u0142\u0144\5\64\33\2\u0143"+
		"\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0146\7\b"+
		"\2\2\u0146\u0148\5.\30\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u014a\3\2\2\2\u0149\u014b\5^\60\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u014d\3\2\2\2\u014c\u014e\5T+\2\u014d\u014c\3\2\2\2\u014d\u014e"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\7\t\2\2\u0150S\3\2\2\2\u0151"+
		"\u0152\7\34\2\2\u0152\u0153\5V,\2\u0153U\3\2\2\2\u0154\u0155\7(\2\2\u0155"+
		"W\3\2\2\2\u0156\u0159\5Z.\2\u0157\u0159\5\\/\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0157\3\2\2\2\u0159Y\3\2\2\2\u015a\u015c\7\35\2\2\u015b\u015d\5.\30\2"+
		"\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015f"+
		"\7\r\2\2\u015f\u0161\5^\60\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0163\3\2\2\2\u0162\u0164\5T+\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2"+
		"\2\u0164\u0165\3\2\2\2\u0165\u0166\7\36\2\2\u0166[\3\2\2\2\u0167\u0169"+
		"\7\37\2\2\u0168\u016a\5.\30\2\u0169\u0168\3\2\2\2\u0169\u016a\3\2\2\2"+
		"\u016a\u016d\3\2\2\2\u016b\u016c\7\r\2\2\u016c\u016e\5^\60\2\u016d\u016b"+
		"\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u0171\5T+\2\u0170"+
		"\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\7\35"+
		"\2\2\u0173]\3\2\2\2\u0174\u0175\7\23\2\2\u0175\u017a\5`\61\2\u0176\u0177"+
		"\7\21\2\2\u0177\u0179\5`\61\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2\2\2"+
		"\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017d\u017e\7\24\2\2\u017e_\3\2\2\2\u017f\u0180\5b\62\2\u0180"+
		"\u0181\5f\64\2\u0181\u0182\5d\63\2\u0182a\3\2\2\2\u0183\u0184\7(\2\2\u0184"+
		"c\3\2\2\2\u0185\u0186\t\2\2\2\u0186e\3\2\2\2\u0187\u0188\t\3\2\2\u0188"+
		"g\3\2\2\2\u0189\u018a\7%\2\2\u018ai\3\2\2\2\u018b\u018c\7&\2\2\u018c\u0191"+
		"\5l\67\2\u018d\u018e\7\21\2\2\u018e\u0190\5l\67\2\u018f\u018d\3\2\2\2"+
		"\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192k\3"+
		"\2\2\2\u0193\u0191\3\2\2\2\u0194\u019a\5V,\2\u0195\u0196\5V,\2\u0196\u0197"+
		"\7\'\2\2\u0197\u0198\5b\62\2\u0198\u019a\3\2\2\2\u0199\u0194\3\2\2\2\u0199"+
		"\u0195\3\2\2\2\u019am\3\2\2\2\u019b\u019c\5\2\2\2\u019co\3\2\2\2#sx}\u0082"+
		"\u0086\u008c\u0092\u0097\u009f\u00a2\u00a9\u00b1\u00bf\u00d3\u00e5\u00f2"+
		"\u010b\u0131\u0139\u0143\u0147\u014a\u014d\u0158\u015c\u0160\u0163\u0169"+
		"\u016d\u0170\u017a\u0191\u0199";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}