package com.server.graph_db.query;

public abstract class Command {
    Result result;
    public abstract void execute() throws Exception;
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }
}
