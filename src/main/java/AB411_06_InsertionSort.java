
public class AB411_06_InsertionSort {

    public void insertionsort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int value = numbers[i];
            int j = i;
            while ((j > 0) && (numbers[j - 1] > value)) {
                numbers[j] = numbers[j - 1];
                j = j - 1;
                numbers[j] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        AB411_06_InsertionSort sort = new AB411_06_InsertionSort();
        sort.insertionsort(liste);
        for (int value : liste) System.out.print(value + " ");
    }
}
