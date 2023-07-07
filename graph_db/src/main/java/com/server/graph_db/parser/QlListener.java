// Generated from Ql.g4 by ANTLR 4.7.2
package com.server.graph_db.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QlParser}.
 */
public interface QlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QlParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(QlParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(QlParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#crud_command}.
	 * @param ctx the parse tree
	 */
	void enterCrud_command(QlParser.Crud_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#crud_command}.
	 * @param ctx the parse tree
	 */
	void exitCrud_command(QlParser.Crud_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#vertex_command}.
	 * @param ctx the parse tree
	 */
	void enterVertex_command(QlParser.Vertex_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#vertex_command}.
	 * @param ctx the parse tree
	 */
	void exitVertex_command(QlParser.Vertex_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#edge_command}.
	 * @param ctx the parse tree
	 */
	void enterEdge_command(QlParser.Edge_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#edge_command}.
	 * @param ctx the parse tree
	 */
	void exitEdge_command(QlParser.Edge_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#index_command}.
	 * @param ctx the parse tree
	 */
	void enterIndex_command(QlParser.Index_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#index_command}.
	 * @param ctx the parse tree
	 */
	void exitIndex_command(QlParser.Index_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(QlParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(QlParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(QlParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(QlParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(QlParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(QlParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#create_vertex}.
	 * @param ctx the parse tree
	 */
	void enterCreate_vertex(QlParser.Create_vertexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#create_vertex}.
	 * @param ctx the parse tree
	 */
	void exitCreate_vertex(QlParser.Create_vertexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#create_edge}.
	 * @param ctx the parse tree
	 */
	void enterCreate_edge(QlParser.Create_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#create_edge}.
	 * @param ctx the parse tree
	 */
	void exitCreate_edge(QlParser.Create_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#create_index}.
	 * @param ctx the parse tree
	 */
	void enterCreate_index(QlParser.Create_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#create_index}.
	 * @param ctx the parse tree
	 */
	void exitCreate_index(QlParser.Create_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#delete_vertex}.
	 * @param ctx the parse tree
	 */
	void enterDelete_vertex(QlParser.Delete_vertexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#delete_vertex}.
	 * @param ctx the parse tree
	 */
	void exitDelete_vertex(QlParser.Delete_vertexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#delete_edge}.
	 * @param ctx the parse tree
	 */
	void enterDelete_edge(QlParser.Delete_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#delete_edge}.
	 * @param ctx the parse tree
	 */
	void exitDelete_edge(QlParser.Delete_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#delete_index}.
	 * @param ctx the parse tree
	 */
	void enterDelete_index(QlParser.Delete_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#delete_index}.
	 * @param ctx the parse tree
	 */
	void exitDelete_index(QlParser.Delete_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#update_vertex}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_vertex(QlParser.Update_vertexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#update_vertex}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_vertex(QlParser.Update_vertexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#update_edge}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_edge(QlParser.Update_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#update_edge}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_edge(QlParser.Update_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#sourceId}.
	 * @param ctx the parse tree
	 */
	void enterSourceId(QlParser.SourceIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#sourceId}.
	 * @param ctx the parse tree
	 */
	void exitSourceId(QlParser.SourceIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#destinationId}.
	 * @param ctx the parse tree
	 */
	void enterDestinationId(QlParser.DestinationIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#destinationId}.
	 * @param ctx the parse tree
	 */
	void exitDestinationId(QlParser.DestinationIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#cost}.
	 * @param ctx the parse tree
	 */
	void enterCost(QlParser.CostContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#cost}.
	 * @param ctx the parse tree
	 */
	void exitCost(QlParser.CostContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#set_clause}.
	 * @param ctx the parse tree
	 */
	void enterSet_clause(QlParser.Set_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#set_clause}.
	 * @param ctx the parse tree
	 */
	void exitSet_clause(QlParser.Set_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#set_item}.
	 * @param ctx the parse tree
	 */
	void enterSet_item(QlParser.Set_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#set_item}.
	 * @param ctx the parse tree
	 */
	void exitSet_item(QlParser.Set_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(QlParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(QlParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(QlParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(QlParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(QlParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(QlParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(QlParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(QlParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(QlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(QlParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(QlParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(QlParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#database_command}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_command(QlParser.Database_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#database_command}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_command(QlParser.Database_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#create_database}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database(QlParser.Create_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#create_database}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database(QlParser.Create_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#delete_database}.
	 * @param ctx the parse tree
	 */
	void enterDelete_database(QlParser.Delete_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#delete_database}.
	 * @param ctx the parse tree
	 */
	void exitDelete_database(QlParser.Delete_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#drop_database}.
	 * @param ctx the parse tree
	 */
	void enterDrop_database(QlParser.Drop_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#drop_database}.
	 * @param ctx the parse tree
	 */
	void exitDrop_database(QlParser.Drop_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#switch_database}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_database(QlParser.Switch_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#switch_database}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_database(QlParser.Switch_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#get_curr_database}.
	 * @param ctx the parse tree
	 */
	void enterGet_curr_database(QlParser.Get_curr_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#get_curr_database}.
	 * @param ctx the parse tree
	 */
	void exitGet_curr_database(QlParser.Get_curr_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#switch_database_to_default}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_database_to_default(QlParser.Switch_database_to_defaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#switch_database_to_default}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_database_to_default(QlParser.Switch_database_to_defaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#drop_default_database}.
	 * @param ctx the parse tree
	 */
	void enterDrop_default_database(QlParser.Drop_default_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#drop_default_database}.
	 * @param ctx the parse tree
	 */
	void exitDrop_default_database(QlParser.Drop_default_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#database_name}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_name(QlParser.Database_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#database_name}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_name(QlParser.Database_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#match_query}.
	 * @param ctx the parse tree
	 */
	void enterMatch_query(QlParser.Match_queryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#match_query}.
	 * @param ctx the parse tree
	 */
	void exitMatch_query(QlParser.Match_queryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#shortest_path_query}.
	 * @param ctx the parse tree
	 */
	void enterShortest_path_query(QlParser.Shortest_path_queryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#shortest_path_query}.
	 * @param ctx the parse tree
	 */
	void exitShortest_path_query(QlParser.Shortest_path_queryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#heuristic}.
	 * @param ctx the parse tree
	 */
	void enterHeuristic(QlParser.HeuristicContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#heuristic}.
	 * @param ctx the parse tree
	 */
	void exitHeuristic(QlParser.HeuristicContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#heuristic_function}.
	 * @param ctx the parse tree
	 */
	void enterHeuristic_function(QlParser.Heuristic_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#heuristic_function}.
	 * @param ctx the parse tree
	 */
	void exitHeuristic_function(QlParser.Heuristic_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#manhattan}.
	 * @param ctx the parse tree
	 */
	void enterManhattan(QlParser.ManhattanContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#manhattan}.
	 * @param ctx the parse tree
	 */
	void exitManhattan(QlParser.ManhattanContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#euclidean}.
	 * @param ctx the parse tree
	 */
	void enterEuclidean(QlParser.EuclideanContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#euclidean}.
	 * @param ctx the parse tree
	 */
	void exitEuclidean(QlParser.EuclideanContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#first_variable}.
	 * @param ctx the parse tree
	 */
	void enterFirst_variable(QlParser.First_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#first_variable}.
	 * @param ctx the parse tree
	 */
	void exitFirst_variable(QlParser.First_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#second_variable}.
	 * @param ctx the parse tree
	 */
	void enterSecond_variable(QlParser.Second_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#second_variable}.
	 * @param ctx the parse tree
	 */
	void exitSecond_variable(QlParser.Second_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#path_query}.
	 * @param ctx the parse tree
	 */
	void enterPath_query(QlParser.Path_queryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#path_query}.
	 * @param ctx the parse tree
	 */
	void exitPath_query(QlParser.Path_queryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(QlParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(QlParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#starting_vertex}.
	 * @param ctx the parse tree
	 */
	void enterStarting_vertex(QlParser.Starting_vertexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#starting_vertex}.
	 * @param ctx the parse tree
	 */
	void exitStarting_vertex(QlParser.Starting_vertexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#path_level}.
	 * @param ctx the parse tree
	 */
	void enterPath_level(QlParser.Path_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#path_level}.
	 * @param ctx the parse tree
	 */
	void exitPath_level(QlParser.Path_levelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#vertex_binding}.
	 * @param ctx the parse tree
	 */
	void enterVertex_binding(QlParser.Vertex_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#vertex_binding}.
	 * @param ctx the parse tree
	 */
	void exitVertex_binding(QlParser.Vertex_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(QlParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(QlParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(QlParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(QlParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#edge_binding}.
	 * @param ctx the parse tree
	 */
	void enterEdge_binding(QlParser.Edge_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#edge_binding}.
	 * @param ctx the parse tree
	 */
	void exitEdge_binding(QlParser.Edge_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#out_edge_binding}.
	 * @param ctx the parse tree
	 */
	void enterOut_edge_binding(QlParser.Out_edge_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#out_edge_binding}.
	 * @param ctx the parse tree
	 */
	void exitOut_edge_binding(QlParser.Out_edge_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#in_edge_binding}.
	 * @param ctx the parse tree
	 */
	void enterIn_edge_binding(QlParser.In_edge_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#in_edge_binding}.
	 * @param ctx the parse tree
	 */
	void exitIn_edge_binding(QlParser.In_edge_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#selectOperators}.
	 * @param ctx the parse tree
	 */
	void enterSelectOperators(QlParser.SelectOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#selectOperators}.
	 * @param ctx the parse tree
	 */
	void exitSelectOperators(QlParser.SelectOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#selectOperator}.
	 * @param ctx the parse tree
	 */
	void enterSelectOperator(QlParser.SelectOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#selectOperator}.
	 * @param ctx the parse tree
	 */
	void exitSelectOperator(QlParser.SelectOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(QlParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(QlParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void enterFieldValue(QlParser.FieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void exitFieldValue(QlParser.FieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(QlParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(QlParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(QlParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(QlParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#return_clause}.
	 * @param ctx the parse tree
	 */
	void enterReturn_clause(QlParser.Return_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#return_clause}.
	 * @param ctx the parse tree
	 */
	void exitReturn_clause(QlParser.Return_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#return_item}.
	 * @param ctx the parse tree
	 */
	void enterReturn_item(QlParser.Return_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#return_item}.
	 * @param ctx the parse tree
	 */
	void exitReturn_item(QlParser.Return_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(QlParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(QlParser.StartContext ctx);
}