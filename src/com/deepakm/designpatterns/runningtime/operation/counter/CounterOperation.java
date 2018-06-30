package com.deepakm.designpatterns.runningtime.operation.counter;

import com.deepakm.designpatterns.runningtime.operation.Operation;

public class CounterOperation implements Operation {
    private int limit;
    private final String name;

    public CounterOperation(String name, int limit){
        this.limit = limit;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        long counter = 0;

        for(int i=0;i<limit;i++){
            counter = counter + 1;
        }
    }
}
