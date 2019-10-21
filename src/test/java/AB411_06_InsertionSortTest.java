import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AB411_06_InsertionSortTest {

    @Test
    void insertionsort() {
        AB411_06_InsertionSort<Integer> integerSort = new AB411_06_InsertionSort<>();
        Integer[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        Integer[] result = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        integerSort.sort(liste);
        assertArrayEquals(result, liste);
        AB411_06_InsertionSort<String> stringSort = new AB411_06_InsertionSort<>();
        String[] liste2 = {"c", "v", "b", "a", "h"};
        String[] result2 = {"a", "b", "c", "h", "v"};
        stringSort.sort(liste2);
        assertArrayEquals(result2, liste2);
        AB411_06_InsertionSort<Float> floatSort = new AB411_06_InsertionSort<>();
        Float[] liste3 = {0.9f, 0.3f, 0.7f, 0.2f, 0.4f, 0.6f, 1.8f, 1.5f, 2.1f, 3.0f};
        Float[] result3 = {0.2f, 0.3f, 0.4f, 0.6f, 0.7f, 0.9f, 1.5f, 1.8f, 2.1f, 3.0f};
        floatSort.sort(liste3);
        assertArrayEquals(result3, liste3);
    }
}