package com.exercise;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 1, 3, 5};
        int[] b = {1, 2, 3, 4};

        // Hopefully, it's going to print [1,1,1,2,3,3,4,5] two times :)
        System.out.println(Arrays.toString(ArrayMerger.mergeByLoop(a, b)));
        System.out.println(Arrays.toString(ArrayMerger.mergeByStreams(a, b)));
    }
}

