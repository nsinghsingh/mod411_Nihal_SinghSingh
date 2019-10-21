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
        String[] liste = new String[100000];
        Arrays.fill(liste, "test");
        AB411_06_InsertionSort<String> stringSort = new AB411_06_InsertionSort<>();
        long duration = measure(liste, stringSort::sort);
        System.out.println(duration + " ms");
    }

}
