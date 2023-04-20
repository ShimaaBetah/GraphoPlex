package com.server.graph_db.query.crud.crudcommands.vertexcommands;

import java.util.Map;

public class UpdateVertexCommand extends CrudVertexCommand {
    String label = null;
    Map<String, String> properties;

public UpdateVertexCommand(String vertexId, String label, Map<String, String> properties) {
    super(vertexId);
    this.label = label;
    this.properties = properties;
}

public String getLabel() {
    return label;

}

public Map<String, String> getProperties() {
    return properties;
}

public void setLabel(String label) {
    this.label = label;
}

public void setProperties(Map<String, String> properties) {
    this.properties = properties;
}

@Override
public void execute() {
    if(this.label!=null){
        globalVertexService.updateVertex(vertexId, label, properties);
    }
    else{
        globalVertexService.updateVertex(vertexId, properties);
    }
}

public static class Builder {
    String vertexId;
    String label = null;
    Map<String, String> properties = null;

    public Builder(String vertexId, Map<String, String> properties) {
        this.vertexId = vertexId;
        this.properties = properties;
    }

    public Builder setLabel(String label) {
        this.label = label;
        return this;
    }
    public UpdateVertexCommand build() {
        return new UpdateVertexCommand(vertexId, label, properties);
    }
}

}