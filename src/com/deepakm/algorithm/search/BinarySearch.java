package com.deepakm.algorithm.search;

public class BinarySearch implements Search {
    private int[] container;

    public BinarySearch(int[] container) {
        this.container = container;
    }

    @Override
    public boolean contains(long item) {
        return contains(container, 0, container.length, item);
    }

    private boolean contains(int[] container, int i, int length, long item) {
        if (length > 1) {
            int mid = 1 + (length - 1) / 2;
            if (container[mid] == item) return true;
            if (container[mid] > item) return contains(container, 1, mid - 1, item);
            return contains(container, mid + 1, length, item);
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch(new int[]{1, 2, 3, 4, 5});
        boolean contains = binarySearch.contains(4);
        System.out.println(contains);
    }
}
