import javax.swing.*;
import java.util.Arrays;
import java.util.function.Consumer;

public class Measure {

    static <T> long measure(T[] array, Consumer<T[]> sort) {
        long start = System.nanoTime() / 1000000;
        sort.accept(array);
        long stop = System.nanoTime() / 1000000;
        return stop - start;
    }

    public static void main(String[] args) {
        Integer[] liste = Structures.makeArray(100000);
        AB411_06_InsertionSort<Integer> integerSort = new AB411_06_InsertionSort<>();
        long duration = Measure.measure(liste, integerSort::sort);
        System.out.println(duration + " ms");
    }

}
