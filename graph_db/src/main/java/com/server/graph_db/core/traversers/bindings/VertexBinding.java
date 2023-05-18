package com.server.graph_db.core.traversers.bindings;

import java.util.ArrayList;

import com.server.graph_db.core.operators.select.SelectOperator;

public class VertexBinding {
    String id;
    String label;
    ArrayList<SelectOperator> selectOperators;

    String alias;

    private VertexBinding(Builder builder) {
        this.id = builder.id;
        this.label = builder.label;
        this.selectOperators = builder.selectOperators;
        this.alias = builder.alias;
    }

    public boolean hasAlias() {
        return alias != null;
    }

    public String getAlias() {
        return alias;
    }

    public String getLabel() {
        return label;
    }
    public String getId() {
        return id;
    }
    public ArrayList<SelectOperator> getSelectOperators() {
        return selectOperators;
    }

    public boolean isAnonymous() {
        return id == null && label == null && selectOperators == null;
    }

    public boolean hasId() {
        return id != null;
    }

    //create builder class to vertex bindinf class
    public static class Builder {
        String id = null;
        String label = null;
        ArrayList<SelectOperator> selectOperators = null;

        String alias = null;

        

        public Builder setId( String id) {
            this.id = id;
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder setSelectOperators(ArrayList<SelectOperator> selectOperators) {
            this.selectOperators = selectOperators;
            return this;
        }

        public Builder setAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public VertexBinding build() {
            return new VertexBinding(this);
        }
    }



}
