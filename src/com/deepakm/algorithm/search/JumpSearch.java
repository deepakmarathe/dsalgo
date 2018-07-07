package com.deepakm.algorithm.search;

public class JumpSearch implements Search {

    private int[] container;

    public JumpSearch(int container[]) {
        this.container = container;
    }

    @Override
    public boolean contains(long item) {
        int n = container.length;
        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        while (container[Math.min(step, n) - 1] < item) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return false;
            }
        }
        while (container[prev] < item) {
            prev++;
            if (prev == Math.min(step, n)) {
                return false;
            }
        }
        if (container[prev] == item) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Search search = new JumpSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        boolean contains = search.contains(7);
        System.out.println(contains);
    }
}
