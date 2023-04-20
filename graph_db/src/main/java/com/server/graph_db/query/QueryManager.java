package com.server.graph_db.query;

import org.antlr.runtime.CommonToken;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.database.GlobalDatabaseService;
import com.server.graph_db.index.GlobalSecondaryIndexManager;
import com.server.graph_db.parser.QlLexer;
import com.server.graph_db.parser.QlParser;
import com.server.graph_db.vertex.GlobalVertexService;

@Component
public class QueryManager {

    @Autowired
    GlobalVertexService globalVertexService;

    @Autowired
    GlobalSecondaryIndexManager globalSecondaryIndexManager;

    @Autowired
    GlobalDatabaseService globalDatabaseService;

    public void Parse(String query) throws Exception {

        // parse using antlr and print the parse tree

        QlLexer lexer = new QlLexer(CharStreams.fromString(query));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QlParser parser = new QlParser(tokens);

        // walk the tree
        ParseTreeWalker walker = new ParseTreeWalker();
        QueryWalker listener = new QueryWalker(globalVertexService, globalSecondaryIndexManager, globalDatabaseService);

        walker.walk(listener, parser.command());
        Query queryObj = listener.getQuery();
        queryObj.execute();

    }
}
