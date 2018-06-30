package com.deepakm.designpatterns.runningtime.main;

import com.deepakm.designpatterns.runningtime.Profiler;
import com.deepakm.designpatterns.runningtime.operation.Operation;
import com.deepakm.designpatterns.runningtime.operation.counter.CounterOperation;
import com.deepakm.designpatterns.runningtime.operation.Loop;
import com.deepakm.designpatterns.runningtime.operation.print.PrintOperation;

public class Application {

    public static void main(String[] args) {


        Operation printOperation = new PrintOperation( "hello");
        Profiler profiler = new Profiler(printOperation);
        profiler.profile();
        profiler.printResult();

        Operation loopOperation = new Loop(10, printOperation);
        profiler = new Profiler(loopOperation);
        profiler.profile();
        profiler.printResult();

        loopOperation = new Loop(1, new CounterOperation("counter", 1000));
        profiler = new Profiler(loopOperation);
        profiler.profile();
        profiler.printResult();

        Operation counterOperation = new CounterOperation("counter", 10);
        profiler = new Profiler(counterOperation);
        profiler.profile();
        profiler.printResult();

    }

}
