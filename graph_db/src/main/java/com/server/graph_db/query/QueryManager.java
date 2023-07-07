package com.server.graph_db.query;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.core.index.GlobalSecondaryIndexManager;
import com.server.graph_db.core.operators.select.SelectOperatorFactory;
import com.server.graph_db.core.traversers.GlobalTraverserManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.parser.QlLexer;
import com.server.graph_db.parser.QlParser;

@Component
public class QueryManager {

    @Autowired
    GlobalVertexService globalVertexService;

    @Autowired
    GlobalSecondaryIndexManager globalSecondaryIndexManager;

    @Autowired
    GlobalDatabaseService globalDatabaseService;

    @Autowired
    GlobalTraverserManager globalTraverserManager;

    @Autowired
    SelectOperatorFactory selectOperatorFactory;

    public Query Parse(String query) throws Exception {

        // parse using antlr and print the parse tree

        QlLexer lexer = new QlLexer(CharStreams.fromString(query));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QlParser parser = new QlParser(tokens);
        CustomErrorListener errorListener = new CustomErrorListener();
        parser.addErrorListener(errorListener);
        lexer.addErrorListener(errorListener);

        // walk the tree
        ParseTreeWalker walker = new ParseTreeWalker();
        QueryWalker listener = new QueryWalker(globalVertexService, globalSecondaryIndexManager, globalDatabaseService,
                globalTraverserManager, selectOperatorFactory);

        walker.walk(listener, parser.command());
        Query queryObj = listener.getQuery();
        queryObj.execute();

        return queryObj;

    }
}
