package com.deepakm.designpatterns.runningtime.operation;

public class Loop implements Operation{

    private long iterations;
    private Operation operation;
    private static final String name = "LOOP";

    public Loop(long iterations, Operation operation) {
        this.iterations = iterations;
        this.operation = operation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
    for(long i = 0; i< iterations; i++){
            operation.run();
        }
    }
}
