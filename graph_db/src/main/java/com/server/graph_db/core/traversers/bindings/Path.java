package com.server.graph_db.core.traversers.bindings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Path {
    VertexBinding startVertexBinding;
    ArrayList<VertexBinding> vertexBindings;
    ArrayList<EdgeBinding> edgeBindings;

    public Path(VertexBinding startVertexBinding) {
        this.startVertexBinding = startVertexBinding;
        this.vertexBindings = new ArrayList<>();
        this.edgeBindings = new ArrayList<>();
    }

    public Path() {

    }

    public void addVertexBinding(VertexBinding vertexBinding) {
        vertexBindings.add(vertexBinding);
    }

    public void addEdgeBinding(EdgeBinding edgeBinding) {
        edgeBindings.add(edgeBinding);
    }

    public VertexBinding getStartVertexBinding() {
        return startVertexBinding;
    }

    public ArrayList<VertexBinding> getVertexBindings() {
        return vertexBindings;
    }

    public ArrayList<EdgeBinding> getEdgeBindings() {
        return edgeBindings;
    }

    public int getLength() {
        return vertexBindings.size();
    }

    public Set<String> getAliases() throws Exception {
        Set<String> aliases = new HashSet<>();
        if (startVertexBinding.hasAlias())
            aliases.add(startVertexBinding.getAlias());
        for (VertexBinding vertexBinding : vertexBindings) {
            if (vertexBinding.hasAlias()) {
                if (aliases.contains(vertexBinding.getAlias())) {
                    throw new Exception("Duplicate alias: " + vertexBinding.getAlias());
                }
                aliases.add(vertexBinding.getAlias());
            }
        }
        for (EdgeBinding edgeBinding : edgeBindings) {
            if (edgeBinding.hasAlias()){
                if (aliases.contains(edgeBinding.getAlias())) {
                    throw new Exception("Duplicate alias: " + edgeBinding.getAlias());
                }
                aliases.add(edgeBinding.getAlias());
            }
        }
        return aliases;
    }

}
