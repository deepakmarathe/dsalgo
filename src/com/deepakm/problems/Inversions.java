package com.deepakm.problems;

/**
 * Count the number of inversions in the array.
 * Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 * <p>
 * Example :
 * 2, 4, 1, 3, 5 has three inversions (2,1), (4, 1), (4, 3)
 */
public class Inversions {
    private int[] input;

    public Inversions(int[] input) {
        this.input = input;
    }

    public int inversionsBruteForce() {
        int inversions = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    public int inversionsEnhancedMergeSort() {
        int a[] = new int[input.length];
        return inversionsEnhancedMergeSort(a, 0, input.length - 1);
    }

    private int inversionsEnhancedMergeSort(int[] a, int left, int right) {
        int mid, inversionsCount = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inversionsCount = inversionsEnhancedMergeSort(a, left, mid);
            inversionsCount += inversionsEnhancedMergeSort(a, mid + 1, right);
            inversionsCount += merge(a, left, mid + 1, right);
        }
        return inversionsCount;
    }

    private int merge(int[] a, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        int inversionsCount = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (input[i] < input[j]) {
                a[k++] = input[i++];
            } else {
                a[k++] = input[j++];
                inversionsCount += (mid - i);
            }
        }
        while (i <= mid - 1) {
            a[k++] = input[i++];
        }
        while (j <= right) {
            a[k++] = input[j++];
        }
        for (i = left; i <= right; i++) {
            input[i] = a[i];
        }
        return inversionsCount;
    }


    public static void main(String[] args) {
        int a[] = {1, 20, 6, 4, 5};
        Inversions inversions = new Inversions(a);
        int inversionCount = inversions.inversionsBruteForce();
        System.out.println("Inversion count bruteforce : " + inversionCount);

        inversionCount = inversions.inversionsEnhancedMergeSort();
        System.out.println("Inversion count enhancedMergeSort : " + inversionCount);
    }
}
