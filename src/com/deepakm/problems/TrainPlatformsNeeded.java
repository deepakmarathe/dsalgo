package com.deepakm.problems;

import java.util.Arrays;

public class TrainPlatformsNeeded {

    private int[] arrival;
    private int[] departure;

    public TrainPlatformsNeeded(int arrival[], int departure[]) {

        this.arrival = arrival;
        this.departure = departure;
    }

    public int compute() {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0;
        int j = 0;
        int platformsNeeded = 0;
        int results = 1;
        while (i < arrival.length && j < departure.length) {
            if (arrival[i] < departure[j]) {
                platformsNeeded++;
                i++;
                if (platformsNeeded > results) {
                    results = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                j++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        TrainPlatformsNeeded trainPlatformsNeeded = new TrainPlatformsNeeded(arrival, departure);
        int result = trainPlatformsNeeded.compute();
        System.out.println("Total platforms needed : " + result);
    }
}
