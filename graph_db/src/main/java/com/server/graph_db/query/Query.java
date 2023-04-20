package com.server.graph_db.query;

public interface Query {
    public void execute() throws Exception;
    public Command getCommand();
    public void setCommand(Command command);

}
