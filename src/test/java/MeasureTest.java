import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasureTest {

    @Test
    void measure() {
        Integer[] liste = Structures.makeArray(100000);
        AB411_06_InsertionSort<Integer> integerSort = new AB411_06_InsertionSort<>();
        long duration = Measure.measure(liste, integerSort::sort);
        liste = Structures.makeArray(100000);
        AB411_07_BubbleSort<Integer> integerSort2 = new  AB411_07_BubbleSort<>();
        long duration2 = Measure.measure(liste, integerSort2::sort);
        System.out.println(duration + " ms");
        System.out.println(duration2 + " ms");
        assertTrue(duration < duration2);
    }
}