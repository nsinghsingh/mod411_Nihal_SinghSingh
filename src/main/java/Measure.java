import javax.lang.model.type.NullType;
import java.util.Arrays;
import java.util.function.Consumer;

public class Measure {

    public <T> long measure(T[] array, Consumer<T[]> sort){
        long start = System.nanoTime() / 1000000;
        sort.accept(array);
        long stop = System.nanoTime() / 1000000;
        long time = stop - start;
        return time;
    }

    public static void main(String[] args) {
        Measure time = new Measure();
        String[] liste = new String[1000000];
        Arrays.fill(liste, "test");
        AB411_06_InsertionSort<String> stringSort = new AB411_06_InsertionSort<>();
        long duration = time.measure(liste, stringSort::insertionsort);
        System.out.println(duration);
    }

}
