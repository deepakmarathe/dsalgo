package com.deepakm.algorithm.search;

public class LinearSearch implements Search{

    private int[] container;

    public LinearSearch(int array[]){
        this.container = array;
    }

    @Override
    public boolean contains(long item) {
        for (int i = 0; i < container.length; i++) {
            if (item == container[i])
                return true;
        }
        return false;
    }
}
