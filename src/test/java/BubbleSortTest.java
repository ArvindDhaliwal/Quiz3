package com.jwetherell.algorithms.sorts.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.jwetherell.algorithms.sorts.BubbleSort;

public class BubbleSortTest {

    @Test
    public void testSortIntegers() {
        Integer[] unsorted = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortStrings() {
        String[] unsorted = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};
        String[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortEmptyArray() {
        Integer[] unsorted = {};
        Integer[] expected = {};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortSingleElement() {
        Integer[] unsorted = {42};
        Integer[] expected = {42};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortAlreadySorted() {
        Integer[] unsorted = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortDescending() {
        Integer[] unsorted = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayWithDuplicates() {
        Integer[] unsorted = {5, 3, 8, 5, 2, 8, 1};
        Integer[] expected = {1, 2, 3, 5, 5, 8, 8};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayWithNegativeValues() {
        Integer[] unsorted = {-5, 3, -8, 4, 2};
        Integer[] expected = {-8, -5, 2, 3, 4};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortLargeArray() {
        Integer[] unsorted = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            unsorted[i] = (int) (Math.random() * 1000); // Random values between 0 and 999
        }
        Integer[] result = BubbleSort.sort(unsorted);
        // Test if the result is sorted
        for (int i = 1; i < result.length; i++) {
            assertTrue(result[i-1] <= result[i]);
        }
    }
}
