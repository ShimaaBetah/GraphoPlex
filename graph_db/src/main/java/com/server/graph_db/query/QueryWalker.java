package com.server.graph_db.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.server.graph_db.alghorithms.AStar;
import com.server.graph_db.alghorithms.Dijkstra;
import com.server.graph_db.alghorithms.ShortestPathAlghorithm;
import com.server.graph_db.alghorithms.heuristics.Euclidean;
import com.server.graph_db.alghorithms.heuristics.Hueristic;
import com.server.graph_db.alghorithms.heuristics.Manhattan;
import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.core.index.GlobalSecondaryIndexManager;
import com.server.graph_db.core.operators.select.SelectOperator;
import com.server.graph_db.core.operators.select.SelectOperatorFactory;
import com.server.graph_db.core.traversers.GlobalTraverserManager;
import com.server.graph_db.core.traversers.bindings.EdgeBinding;
import com.server.graph_db.core.traversers.bindings.Path;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.parser.QlBaseListener;
import com.server.graph_db.parser.QlParser.Create_databaseContext;
import com.server.graph_db.parser.QlParser.Create_edgeContext;
import com.server.graph_db.parser.QlParser.Create_indexContext;
import com.server.graph_db.parser.QlParser.Create_vertexContext;
import com.server.graph_db.parser.QlParser.Crud_commandContext;
import com.server.graph_db.parser.QlParser.Database_commandContext;
import com.server.graph_db.parser.QlParser.Delete_databaseContext;
import com.server.graph_db.parser.QlParser.Delete_edgeContext;
import com.server.graph_db.parser.QlParser.Delete_indexContext;
import com.server.graph_db.parser.QlParser.Delete_vertexContext;
import com.server.graph_db.parser.QlParser.DestinationIdContext;
import com.server.graph_db.parser.QlParser.Drop_databaseContext;
import com.server.graph_db.parser.QlParser.Drop_default_databaseContext;
import com.server.graph_db.parser.QlParser.Edge_bindingContext;
import com.server.graph_db.parser.QlParser.Get_curr_databaseContext;
import com.server.graph_db.parser.QlParser.IdContext;
import com.server.graph_db.parser.QlParser.LabelContext;
import com.server.graph_db.parser.QlParser.Match_queryContext;
import com.server.graph_db.parser.QlParser.PathContext;
import com.server.graph_db.parser.QlParser.Path_levelContext;
import com.server.graph_db.parser.QlParser.Path_queryContext;
import com.server.graph_db.parser.QlParser.PropertiesContext;
import com.server.graph_db.parser.QlParser.PropertyContext;
import com.server.graph_db.parser.QlParser.Return_clauseContext;
import com.server.graph_db.parser.QlParser.Return_itemContext;
import com.server.graph_db.parser.QlParser.SelectOperatorContext;
import com.server.graph_db.parser.QlParser.Set_clauseContext;
import com.server.graph_db.parser.QlParser.Set_itemContext;
import com.server.graph_db.parser.QlParser.Shortest_path_queryContext;
import com.server.graph_db.parser.QlParser.SourceIdContext;
import com.server.graph_db.parser.QlParser.Starting_vertexContext;
import com.server.graph_db.parser.QlParser.Switch_databaseContext;
import com.server.graph_db.parser.QlParser.Switch_database_to_defaultContext;
import com.server.graph_db.parser.QlParser.Update_edgeContext;
import com.server.graph_db.parser.QlParser.Update_vertexContext;
import com.server.graph_db.parser.QlParser.Vertex_bindingContext;
import com.server.graph_db.query.crud.CrudQuery;
import com.server.graph_db.query.crud.crudcommands.edgecommands.CreateEdgeCommand;
import com.server.graph_db.query.crud.crudcommands.edgecommands.DeleteEdgeCommand;
import com.server.graph_db.query.crud.crudcommands.edgecommands.UpdateEdgeCommand;
import com.server.graph_db.query.crud.crudcommands.indexcommands.CreateIndexCommand;
import com.server.graph_db.query.crud.crudcommands.indexcommands.DeleteIndexCommand;
import com.server.graph_db.query.crud.crudcommands.vertexcommands.CreateVertexCommand;
import com.server.graph_db.query.crud.crudcommands.vertexcommands.DeleteVertexCommand;
import com.server.graph_db.query.crud.crudcommands.vertexcommands.UpdateVertexCommand;
import com.server.graph_db.query.databaseconfig.DatabaseConfigQuery;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.CreateDatabaseCommand;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.DeleteDatabaseCommand;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.DropDatabaseCommand;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.DropDefaultCommand;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.GetCurrentDatabaseCommand;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.SwitchDatabaseCommand;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.SwitchToDefaultCommand;
import com.server.graph_db.query.match.MatchQuery;
import com.server.graph_db.query.match.path.PathCommand;
import com.server.graph_db.query.match.path.ReturnClause;
import com.server.graph_db.query.match.path.ReturnClause.ReturnedValue;
import com.server.graph_db.query.match.shortestPath.ShortestPathCommand;

public class QueryWalker extends QlBaseListener {

    Query query;
    Map<String, String> ruleMapping = new HashMap<String, String>();

    GlobalVertexService globalVertexService;
    GlobalSecondaryIndexManager globalSecondaryIndexManager;
    GlobalDatabaseService globalDatabaseService;
    GlobalTraverserManager globalTraverserManager;
    SelectOperatorFactory selectOperatorFactory;

    public QueryWalker(GlobalVertexService globalVertexService, GlobalSecondaryIndexManager globalSecondaryIndexManager,
            GlobalDatabaseService globalDatabaseService, GlobalTraverserManager globalTraverserManager,
            SelectOperatorFactory selectOperatorFactory) {
        this.globalVertexService = globalVertexService;
        this.globalSecondaryIndexManager = globalSecondaryIndexManager;
        this.globalDatabaseService = globalDatabaseService;
        this.globalTraverserManager = globalTraverserManager;
        this.selectOperatorFactory = selectOperatorFactory;
    }

    @Override
    public void enterCrud_command(Crud_commandContext ctx) {
        query = new CrudQuery(globalVertexService, globalSecondaryIndexManager);
    }

    @Override
    public void enterDatabase_command(Database_commandContext ctx) {
        query = new DatabaseConfigQuery(globalDatabaseService);
    }

    @Override
    public void enterMatch_query(Match_queryContext ctx) {
        query = new MatchQuery(globalVertexService, globalTraverserManager);
    }

    @Override
    public void exitCreate_vertex(Create_vertexContext ctx) {
        // create builder for create vertex command
        IdContext idContext = ctx.id();
        CreateVertexCommand.Builder builder = new CreateVertexCommand.Builder(idContext.getText());
        LabelContext labelContext = ctx.label();
        if (labelContext != null) {
            builder.setLabel(labelContext.getText());
        }
        PropertiesContext propertiesContext = ctx.properties();
        if (propertiesContext != null) {
            // get the context of property
            List<PropertyContext> propertyContext = propertiesContext.property();
            Map<String, String> properties = new HashMap<String, String>();
            for (PropertyContext property : propertyContext) {
                properties.put(property.key().getText(), getTextInQoutes(property.value().getText()));
            }
            builder.setProperties(properties);
        }

        // add the command to the query
        query.setCommand(builder.build());
    }

    @Override
    public void exitUpdate_vertex(Update_vertexContext ctx) {
        // get id , label and set clause
        IdContext idContext = ctx.id();
        Set_clauseContext setClauseContext = ctx.set_clause();

        Map<String, String> properties = new HashMap<String, String>();
        // loop on set items
        List<Set_itemContext> setItemContexts = setClauseContext.set_item();
        for (Set_itemContext setItemContext : setItemContexts) {
            properties.put(setItemContext.key().getText(), getTextInQoutes(setItemContext.value().getText()));
        }

        // create builder for update vertex command
        UpdateVertexCommand.Builder builder = new UpdateVertexCommand.Builder(idContext.getText(), properties);
        query.setCommand(builder.build());
    }

    @Override
    public void exitDelete_vertex(Delete_vertexContext ctx) {
        IdContext idContext = ctx.id();
        query.setCommand(new DeleteVertexCommand(idContext.getText()));
    }

    @Override
    public void exitCreate_edge(Create_edgeContext ctx) {
        SourceIdContext sourceIdContext = ctx.sourceId();
        DestinationIdContext destinationIdContext = ctx.destinationId();
        String label = ctx.label() == null ? "" : ctx.label().getText();
        CreateEdgeCommand.Builder builder = new CreateEdgeCommand.Builder(sourceIdContext.getText(),
                destinationIdContext.getText(), label);
        PropertiesContext propertiesContext = ctx.properties();
        if (propertiesContext != null) {
            List<PropertyContext> propertyContext = propertiesContext.property();
            Map<String, String> properties = new HashMap<String, String>();
            for (PropertyContext property : propertyContext) {
                properties.put(property.key().getText(), getTextInQoutes(property.value().getText()));
            }

            builder.setProperties(properties);
        }

        query.setCommand(builder.build());
    }

    @Override
    public void exitUpdate_edge(Update_edgeContext ctx) {
        String sourceId = ctx.sourceId().getText();
        String destinationId = ctx.destinationId().getText();
        Set_clauseContext setClauseContext = ctx.set_clause();
        Map<String, String> properties = new HashMap<String, String>();
        // loop on set items
        List<Set_itemContext> setItemContexts = setClauseContext.set_item();
        for (Set_itemContext setItemContext : setItemContexts) {
            properties.put(setItemContext.key().getText(), getTextInQoutes(setItemContext.value().getText()));
        }
        String label = ctx.label() == null ? "" : ctx.label().getText();

        UpdateEdgeCommand.Builder builder = new UpdateEdgeCommand.Builder(sourceId, destinationId, label, properties);
        query.setCommand(builder.build());

    }

    @Override
    public void exitDelete_edge(Delete_edgeContext ctx) {
        String sourceId = ctx.sourceId().getText();
        String destinationId = ctx.destinationId().getText();
        String label = ctx.label() == null ? "" : ctx.label().getText();
        System.out.println("label: " + label);

        DeleteEdgeCommand.Builder builder = new DeleteEdgeCommand.Builder(sourceId, destinationId, label);
        query.setCommand(builder.build());
    }

    @Override
    public void exitCreate_index(Create_indexContext ctx) {
        String key = ctx.key().getText();
        CreateIndexCommand.Builder builder = new CreateIndexCommand.Builder(key);
        query.setCommand(builder.build());
    }

    @Override
    public void exitDelete_index(Delete_indexContext ctx) {
        String key = ctx.key().getText();
        DeleteIndexCommand.Builder builder = new DeleteIndexCommand.Builder(key);
        query.setCommand(builder.build());
    }

    @Override
    public void exitCreate_database(Create_databaseContext ctx) {
        String databaseName = ctx.database_name().getText();
        CreateDatabaseCommand createDatabaseCommand = new CreateDatabaseCommand(databaseName);
        query.setCommand(createDatabaseCommand);
    }

    @Override
    public void exitDelete_database(Delete_databaseContext ctx) {
        String databaseName = ctx.database_name().getText();
        DeleteDatabaseCommand deleteDatabaseCommand = new DeleteDatabaseCommand(databaseName);
        query.setCommand(deleteDatabaseCommand);
    }

    @Override
    public void exitSwitch_database(Switch_databaseContext ctx) {
        String databaseName = ctx.database_name().getText();
        SwitchDatabaseCommand switchDatabaseCommand = new SwitchDatabaseCommand(databaseName);
        query.setCommand(switchDatabaseCommand);
    }

    @Override
    public void exitDrop_database(Drop_databaseContext ctx) {
        String databaseName = ctx.database_name().getText();
        DropDatabaseCommand dropDatabaseCommand = new DropDatabaseCommand(databaseName);
        query.setCommand(dropDatabaseCommand);
    }

    @Override
    public void exitSwitch_database_to_default(Switch_database_to_defaultContext ctx) {
        SwitchToDefaultCommand switchToDefaultDatabaseCommand = new SwitchToDefaultCommand();
        query.setCommand(switchToDefaultDatabaseCommand);
    }

    @Override
    public void exitDrop_default_database(Drop_default_databaseContext ctx) {
        DropDefaultCommand dropDefaultDatabaseCommand = new DropDefaultCommand();
        query.setCommand(dropDefaultDatabaseCommand);
    }

    @Override
    public void exitGet_curr_database (Get_curr_databaseContext ctx) {
        GetCurrentDatabaseCommand getCurrDatabaseCommand = new GetCurrentDatabaseCommand();
        query.setCommand(getCurrDatabaseCommand);
    }

    @Override
    public void exitPath_query(Path_queryContext ctx) {
        // get path context
        PathContext pathContext = ctx.path();
        Starting_vertexContext startingVertexContext = pathContext.starting_vertex();
        Path path = new Path(extractVertexBinding(startingVertexContext.vertex_binding()));
       List <Path_levelContext> pathLevelsContext = pathContext.path_level();
       for(Path_levelContext pathLevelContext : pathLevelsContext){
           Vertex_bindingContext vertexBindingContext = pathLevelContext.vertex_binding();
           VertexBinding vertexBinding = extractVertexBinding(vertexBindingContext);
           path.addVertexBinding(vertexBinding);
           Edge_bindingContext edgeBindingContext = pathLevelContext.edge_binding();
           EdgeBinding edgeBinding = extractEdgeBinding(edgeBindingContext);
           path.addEdgeBinding(edgeBinding);
       }
       Return_clauseContext returnClauseContext = ctx.return_clause();
       ReturnClause returnClause = new ReturnClause();
        List<Return_itemContext> returnItemsContext = returnClauseContext.return_item();
        for(Return_itemContext returnItemContext : returnItemsContext){
           ReturnedValue returnValue = new ReturnedValue(returnItemContext.variable().getText());
           if(returnItemContext.fieldName() != null){
               returnValue.setFieldName(returnItemContext.fieldName().getText());
           }
            returnClause.addReturnedValue(returnValue);
        }

        PathCommand pathCommand = new PathCommand(path);
        pathCommand.setReturnClause(returnClause);


        query.setCommand(pathCommand);
    }

    @Override
    public void exitShortest_path_query(Shortest_path_queryContext ctx) {
        String sourceId = ctx.sourceId().getText();
        String destinationId = ctx.destinationId().getText();
        String costField = ctx.cost().getText();
        ShortestPathAlghorithm shortestPathAlghorithm;
        if (ctx.heuristic() == null) {
            shortestPathAlghorithm = new Dijkstra(globalVertexService);
        } else {
            Hueristic hueristic = null;
            // getting the huerstic function child of hueristic ctx 
            if(ctx.heuristic().heuristic_function().manhattan() != null){
                String x = ctx.heuristic().heuristic_function().manhattan().first_variable().getText();
                String y = ctx.heuristic().heuristic_function().manhattan().second_variable().getText();
                hueristic = new Manhattan(x,y);
            }
            else if (ctx.heuristic().heuristic_function().euclidean()!=null){
                String x = ctx.heuristic().heuristic_function().euclidean().first_variable().getText();
                String y = ctx.heuristic().heuristic_function().euclidean().second_variable().getText();
                hueristic = new Euclidean(x,y);

            }
            shortestPathAlghorithm = new AStar(globalVertexService, hueristic);
        }


        ShortestPathCommand shortestPathCommand = new ShortestPathCommand(shortestPathAlghorithm,sourceId, destinationId, costField); 
        query.setCommand(shortestPathCommand);
    }

    
    // throw error when cannot match the query
   
    
    public Query getQuery() {
        return query;
    }

    public VertexBinding extractVertexBinding(Vertex_bindingContext vertexBindingContext) {
        VertexBinding.Builder builder = new VertexBinding.Builder();
        if (vertexBindingContext.id() != null) {
            builder.setId(vertexBindingContext.id().getText());
        }
        if (vertexBindingContext.label() != null) {
            builder.setLabel(vertexBindingContext.label().getText());
        }
        if (vertexBindingContext.selectOperators() != null) {
            List<SelectOperatorContext> selectOperatorsContexts = vertexBindingContext.selectOperators()
            .selectOperator();
            ArrayList<SelectOperator> selectOperators = new ArrayList<SelectOperator>();
            for (SelectOperatorContext selectOperatorContext : selectOperatorsContexts) {
                String fieldName = selectOperatorContext.fieldName().getText();
                String fieldValue = getTextInQoutes(selectOperatorContext.fieldValue().getText());
                String operator = selectOperatorContext.operator().getText();
                selectOperators.add(selectOperatorFactory.getSelectOperator(operator, fieldName, fieldValue));
            }
            builder.setSelectOperators(selectOperators);
        }
        if(vertexBindingContext.alias()!=null){
            builder.setAlias(vertexBindingContext.alias().variable().getText());
        }
        return builder.build();
    }
    private EdgeBinding extractEdgeBinding(Edge_bindingContext edgeBindingContext) {
        EdgeBinding.Builder builder;
        if(edgeBindingContext.out_edge_binding()!=null){
            builder = new EdgeBinding.Builder(true);
            if(edgeBindingContext.out_edge_binding().label()!=null){
                builder.setLabel(edgeBindingContext.out_edge_binding().label().getText());
            }
            if(edgeBindingContext.out_edge_binding().selectOperators()!=null){
                List<SelectOperatorContext> selectOperatorsContexts = edgeBindingContext.out_edge_binding().selectOperators()
                .selectOperator();
                ArrayList<SelectOperator> selectOperators = new ArrayList<SelectOperator>();
                for (SelectOperatorContext selectOperatorContext : selectOperatorsContexts) {
                    String fieldName = selectOperatorContext.fieldName().getText();
                    String fieldValue = getTextInQoutes(selectOperatorContext.fieldValue().getText());
                    String operator = selectOperatorContext.operator().getText();
                    selectOperators.add(selectOperatorFactory.getSelectOperator(operator, fieldName, fieldValue));

                }
                builder.setSelectOperators(selectOperators);
            }
            if(edgeBindingContext.out_edge_binding().alias()!=null){
                builder.setAlias(edgeBindingContext.out_edge_binding().alias().variable().getText());
            }
        }else{
            builder = new EdgeBinding.Builder(false);
            if(edgeBindingContext.in_edge_binding().label()!=null){
                builder.setLabel(edgeBindingContext.in_edge_binding().label().getText());
            }
            if(edgeBindingContext.in_edge_binding().selectOperators()!=null){
                List<SelectOperatorContext> selectOperatorsContexts = edgeBindingContext.in_edge_binding().selectOperators()
                .selectOperator();
                ArrayList<SelectOperator> selectOperators = new ArrayList<SelectOperator>();
                for (SelectOperatorContext selectOperatorContext : selectOperatorsContexts) {
                    String fieldName = selectOperatorContext.fieldName().getText();
                    String fieldValue = getTextInQoutes(selectOperatorContext.fieldValue().getText());
                    String operator = selectOperatorContext.operator().getText();
                    selectOperators.add(selectOperatorFactory.getSelectOperator( operator,fieldName, fieldValue));
                }
                builder.setSelectOperators(selectOperators);
            }
            if(edgeBindingContext.in_edge_binding().alias()!=null){
                builder.setAlias(edgeBindingContext.in_edge_binding().alias().variable().getText());
            }
        }
        return builder.build();
    }




    public static String getTextInQoutes(String text){
        // if it start with " and end with " then remove the quotes
        if(text.charAt(0) == '"' && text.charAt(text.length()-1) == '"'){
            return text.substring(1, text.length()-1);
        }
        return text;
    }

    

       
    
    
}
