package com.server.graph_db.operators.select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.redis.RedisIndexDataManager;
import com.server.graph_db.vertex.LocalVertexService;

@Component
public class SelectOperatorFactory {

    @Autowired
    RedisIndexDataManager redisIndexDataManager;

    @Autowired
    LocalVertexService vertexService;

    
    public  SelectOperator getSelectOperator(String operatorName, String fieldName, String fieldValue){
        System.out.println("In getSelectOperator");
        System.out.println(operatorName);
        switch(operatorName){
            case "=":
                return new EqualSelectOperator(fieldName, fieldValue, redisIndexDataManager, vertexService);
            default:
                return null;
        }
    }
}
