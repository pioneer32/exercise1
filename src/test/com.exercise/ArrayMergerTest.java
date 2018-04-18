package com.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ArrayMergerTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new int[][][]{
            {{}, {}, {}},
            {{1}, {1}, {}},
            {{1}, {}, {1}},
            {{1, 2}, {1}, {2}},
            {{1, 2}, {2}, {1}},
            {{1, 1}, {1}, {1}},
            {{-2, -1}, {-1}, {-2}},
            {{-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8}, {-3, -1, 1, 3, 5, 7}, {-2, 0, 2, 4, 6, 8}},
            {{-3, -2, -1, 0, 1, 2, 4, 6, 8}, {-2, 0, 2, 4, 6, 8}, {-3, -1, 1}},
            {{-3, -2, -1, 0, 1, 2, 4, 6, 8}, {-3, -1, 1}, {-2, 0, 2, 4, 6, 8}},

            {{1, 1, 1, 2, 3, 3, 4, 5}, {1, 1, 3, 5}, {1, 2, 3, 4}}
        });
    }

    private int[] expected, a, b;

    public ArrayMergerTest(int[] expected, int[] a, int[] b) {
        this.expected = expected;
        this.a = a;
        this.b = b;
    }

    @Test
    public void testmergeByLoop() {
        assertArrayEquals(expected, ArrayMerger.mergeByLoop(a, b));
    }

    @Test
    public void testMergepStreams() {
        assertArrayEquals(expected, ArrayMerger.mergeByStreams(a, b));
    }
}
