package com.server.graph_db.core.operators.select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.datastore.redis.RedisIndexDataManager;

@Component
public class SelectOperatorFactory {

    @Autowired
    RedisIndexDataManager redisIndexDataManager;

    @Autowired
    LocalVertexService vertexService;

    
    public  SelectOperator getSelectOperator(String operatorName, String fieldName, String fieldValue){
        switch(operatorName){
            case "=":
                return new EqualSelectOperator(fieldName, fieldValue, redisIndexDataManager, vertexService);
            default:
                return null;
        }
    }
}
