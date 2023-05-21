package com.server.graph_db.core.operators.select;

import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.Vertex;

public abstract class SelectOperator {

    String fieldName;
    String fieldValue;

    public SelectOperator(String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public abstract Iterable<String> execute() throws Exception;
    public abstract Iterable<Vertex> executeWithVertices () throws Exception;
    public abstract Iterable<String> filterVertices(Iterable<String> verticesIds) throws Exception;
    public abstract boolean isVertexValid(Vertex vertex);
    public abstract boolean isEdgeValid(Edge edge);
    public abstract String getOperator ();
  

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    
}
