public class AB411_07_BubbleSort {

    public void bubblesort(int[] array){
        for (int n = array.length; n>1; --n) {
            for ( int i = 0; i < n - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int a = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = a;
                }
            }
        }
    }

    public static void main(String[] args) {
        AB411_07_BubbleSort sort = new AB411_07_BubbleSort();
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        sort.bubblesort(liste);
        for (int value : liste) System.out.print(value + " ");
    }
}
