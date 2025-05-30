package com.back;

public class Rq {

    String operation;

    public Rq(String operation) {
        this.operation = operation;
    }

    public String getActionName() {
         return operation.split("\\?", 2)[0];
    }
}
