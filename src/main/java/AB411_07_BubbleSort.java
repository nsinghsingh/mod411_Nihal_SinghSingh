import java.util.function.Function;

public class AB411_07_BubbleSort<T extends Comparable<T>>{


    public void bubblesort(T[] array){
        for (int n = array.length; n > 1; --n) {
            for ( int i = 0; i < n - 1; ++i) {
                if (array[i].compareTo(array[i+1]) > 0) {
                    T a = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = a;
                }
            }
        }
    }



    public static void main(String[] args) {
        AB411_07_BubbleSort<Integer> integerSort = new AB411_07_BubbleSort<>();
        Integer[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        integerSort.bubblesort(liste);
        for (int value : liste) System.out.print(value + " ");
    }
}
