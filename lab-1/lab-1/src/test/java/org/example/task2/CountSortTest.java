package org.example.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSortTest {

    @Test
    public void checkDefaultArraySort() {
        int[] arr = {12, 7, 92, 5, 18, 4, 32, 48, 11, 74};
        int[] expectedArr = {4, 5, 7, 11, 12, 18, 32, 48, 74, 92};
        CountSort.sort(arr);
        Assertions.assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void checkEmptyArraySort() {
        int[] arr = {};
        int[] expectedArr = {};
        CountSort.sort(arr);
        Assertions.assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void checkNegativeElementsSort() {
        int[] arr = {-5, -2, 0, 44};
        int[] expectedArr = {-5, -2, 0, 44};
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CountSort.sort(arr);
        });

        String expectedMessage = "Negative array element occurred";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
        Assertions.assertArrayEquals(expectedArr, arr);
    }
}
