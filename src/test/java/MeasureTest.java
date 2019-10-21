import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MeasureTest {

    @Test
    void measure() {
        String[] liste = new String[100000];
        Arrays.fill(liste, "test");
        AB411_06_InsertionSort<String> stringSort = new AB411_06_InsertionSort<>();
        long duration = Measure.measure(liste, stringSort::sort);
        AB411_07_BubbleSort<String> stringSort2 = new AB411_07_BubbleSort<>();
        long duration2 = Measure.measure(liste, stringSort2::sort);
        System.out.println(duration + " " + duration2);
        assertTrue(duration < duration2);
    }
}