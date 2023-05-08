package com.server.graph_db.query;

public abstract class Query {


    public abstract void execute() throws Exception;
    public abstract Command getCommand();
    public abstract void setCommand(Command command);
    public Result getResult() {
        return getCommand().getResult();
    }
   

}
