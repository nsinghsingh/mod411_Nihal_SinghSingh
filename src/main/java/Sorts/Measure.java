package Sorts;

import java.util.function.Consumer;

public class Measure {

    static <T> long measure(T[] array, Consumer<T[]> sort) {
        long start = System.nanoTime() / 1000000;
        sort.accept(array);
        long stop = System.nanoTime() / 1000000;
        return stop - start;
    }
}
