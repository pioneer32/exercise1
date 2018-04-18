package com.exercise;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This is a solution of the following test task:
 * A function/class should merge two arrays of sorted integers. The output should be a sorted array containing all
 * the elements from both input arrays, including any duplicates.
 *
 * @author Vladislav Churakov
 */
public class ArrayMerger {

    /**
     * Checks whether the argument isn't sorted
     *
     * @param arr an array of ints
     * @return true if the array is disordered, otherwise - false
     */
    private static boolean isDisordered(int[] arr) {
        if (arr.length < 2) return false;
        int i = arr.length - 1;
        do {
            if (arr[i - 1] > arr[i]) return true;
        } while (--i > 0);
        return false;
    }

    /**
     * Merges two sorted arrays of ints using a classic approach.
     * Returns a sorted array of ints that contains all the elements from both input arrays, including any duplicates.
     *
     * @param a a sorted array of ints
     * @param b a sorted array of ints
     * @return a sorted array of ints containing all elements from a and b
     * @throws IllegalArgumentException in a case if one of the arguments is not a sorted array
     */
    public static int[] mergeLoop(int[] a, int[] b) throws IllegalArgumentException {
        if (isDisordered(a)) throw new IllegalArgumentException("Array A is not sorted");
        if (isDisordered(b)) throw new IllegalArgumentException("Array B is not sorted");
        int posA = 0, posB = 0, retPos = 0, totalItems = a.length + b.length;
        final int[] ab = new int[totalItems];
        while (totalItems-- > 0) {
            if (posA < a.length && (!(posB < b.length) || a[posA] < b[posB])) {
                ab[retPos++] = a[posA++];
            } else {
                ab[retPos++] = b[posB++];
            }
        }

        return ab;
    }

    /**
     * Merges two sorted arrays of ints using Streams
     * Returns a sorted array of ints that contains all the elements from both input arrays, including any duplicates.
     *
     * @param a a sorted array of ints
     * @param b a sorted array of ints
     * @return a sorted array of ints containing all elements from a and b
     */
    public static int[] mergeStreams(int[] a, int[] b) {
        return Stream
            .concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }

}

