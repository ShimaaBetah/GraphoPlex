package com.server.graph_db.core.traversers.bindings;

import java.util.ArrayList;

import com.server.graph_db.core.operators.select.SelectOperator;

public class EdgeBinding {
    String label;
    String alias;
    ArrayList<SelectOperator> selectOperators;
    boolean isOutgoing;

    private EdgeBinding(Builder builder) {
        this.label = builder.label;
        this.alias = builder.alias;
        this.selectOperators = builder.selectOperators;
        this.isOutgoing = builder.isOutgoing;
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

    public ArrayList<SelectOperator> getSelectOperators() {
        return selectOperators;
    }

    public boolean isAnonymous() {
        return label == null && selectOperators == null;
    }

    public boolean isOutgoing() {
        return isOutgoing;
    }



    

    

    public static class Builder {
        String label = null;
        String alias = null;
        ArrayList<SelectOperator> selectOperators = null;
        boolean isOutgoing ;


        public Builder(boolean isOutgoing) {
            this.isOutgoing = isOutgoing;
        }

        

        public Builder setLabel( String label) {
            this.label = label;
            return this;
        }

        public Builder setAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder setSelectOperators(ArrayList<SelectOperator> selectOperators) {
            this.selectOperators = selectOperators;
            return this;
        }

        public Builder setOutgoing(boolean isOutgoing) {
            this.isOutgoing = isOutgoing;
            return this;
        }

        public EdgeBinding build() {
            return new EdgeBinding(this);
        }
    }
}
