package com.jwetherell.algorithms.sorts;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    private static final Random RAND = new Random();

    public static enum PIVOT_TYPE {
        FIRST, MIDDLE, RANDOM
    }

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    private QuickSort() { }

    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE pivotType, T[] unsorted) {
        type = pivotType; // Set the pivot type globally
        sort(0, unsorted.length - 1, unsorted);
        return unsorted;
    }

    private static <T extends Comparable<T>> void sort(int start, int finish, T[] unsorted) {
        if (start < finish) {
            int pivotIndex = partition(start, finish, unsorted);
            sort(start, pivotIndex - 1, unsorted); // Sort the left partition
            sort(pivotIndex, finish, unsorted); // Sort the right partition
        }
    }

    private static <T extends Comparable<T>> int partition(int start, int finish, T[] unsorted) {
        T pivot = choosePivot(start, finish, unsorted);
        int s = start;
        int f = finish;
        while (s <= f) {
            while (unsorted[s].compareTo(pivot) < 0) s++; // Move left to right
            while (unsorted[f].compareTo(pivot) > 0) f--; // Move right to left
            if (s <= f) {
                swap(s, f, unsorted); // Swap elements at s and f
                s++;
                f--;
            }
        }
        return s; // Return the partition point
    }

    private static <T extends Comparable<T>> T choosePivot(int start, int finish, T[] unsorted) {
        int pivotIndex;
        if (type == PIVOT_TYPE.RANDOM) {
            pivotIndex = RAND.nextInt(finish - start + 1) + start; // Random pivot
        } else if (type == PIVOT_TYPE.MIDDLE) {
            pivotIndex = (start + finish) / 2; // Middle pivot
        } else {
            pivotIndex = start; // First element as pivot
        }
        T pivot = unsorted[pivotIndex];
        swap(pivotIndex, finish, unsorted); // Move pivot to the end for partitioning
        return pivot;
    }

    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}
