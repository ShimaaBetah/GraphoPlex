package com.server.graph_db.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryManagerController {

    @Autowired
    QueryManager queryManager;


    @PostMapping("/query")
    // function to execute query and return bad request if query is not valid or have errors
    public ResponseEntity<String> executeQuery(@RequestBody QueryRequest query) {
        try {
            Query queryObj = queryManager.Parse(query.query);
            return ResponseEntity.ok().body(queryObj.getResult().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    static class QueryRequest {
        public String query;
    }
    
}
