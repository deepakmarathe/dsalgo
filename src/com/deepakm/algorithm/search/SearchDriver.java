package com.deepakm.algorithm.search;

public class SearchDriver {
    private Search search;

    public SearchDriver(Search search){
        this.search = search;
    }

    public boolean contains(long item){
        return this.search.contains(item);
    }

    public static void main(String[] args) {
        int []container = new int[]{1, 2, 3, 4, 5};

        Search search = new LinearSearch(container);
        SearchDriver driver = new SearchDriver(search);
        boolean contains = driver.contains(2);
        System.out.println(contains);

        search = new BinarySearch(container);
        driver = new SearchDriver(search);
        contains = driver.contains(4);
        System.out.println(contains);

        search = new JumpSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        contains = search.contains(7);
        System.out.println(contains);
    }
}

