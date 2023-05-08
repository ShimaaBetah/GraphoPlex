package com.server.graph_db.query;

public abstract class Result {

    String message;
    long totalExecutionTime = 0;

    public Result() {
    }

    public long getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public void setTotalExecutionTime(long totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString(){
    	return message +"\nTotal Execution Time: "+totalExecutionTime+"ms";
    }
    
}
