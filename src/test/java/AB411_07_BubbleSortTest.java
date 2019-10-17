import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AB411_07_BubbleSortTest {

    @Test
    void bubblesort() {
        AB411_07_BubbleSort sort = new AB411_07_BubbleSort();
        int[] result = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        sort.bubblesort(liste);
        assertArrayEquals(result,liste);
        int[] liste2 = {0, 2, 8, 1, 5, 7, 9, 3, 6, 4};
        sort.bubblesort(liste2);
        assertArrayEquals(result,liste2);
        int[] liste3 = {9, 3, 7, 2, 4, 6, 8, 5, 1, 0};
        sort.bubblesort(liste3);
        assertArrayEquals(result,liste3);
    }
}