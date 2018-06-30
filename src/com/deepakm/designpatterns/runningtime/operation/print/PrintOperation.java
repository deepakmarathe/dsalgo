package com.deepakm.designpatterns.runningtime.operation.print;

import com.deepakm.designpatterns.runningtime.operation.Operation;

public class PrintOperation implements Operation {

    private final String printItem;
    private static final String name = "PRINT";

    public PrintOperation(String printItem){
        this.printItem = printItem;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(printItem);
    }
}
