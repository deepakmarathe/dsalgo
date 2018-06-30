package com.deepakm.designpatterns.runningtime;

import com.deepakm.designpatterns.runningtime.operation.Operation;

public class Profiler {

    private Operation operation;

    private long startTime, endTime;

    public Profiler(Operation operation) {
        this.operation = operation;
    }

    private void start() {
        startTime = System.nanoTime();
    }

    private void end() {
        endTime = System.nanoTime();
    }

    public void profile() {
        start();
        operation.run();
        end();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void printResult() {
        System.out.println(exportResult());
    }

    public String exportResult(){
        return "operation : " + operation.getName() + ", elapsed time is : " + getElapsedTime();
    }
}
