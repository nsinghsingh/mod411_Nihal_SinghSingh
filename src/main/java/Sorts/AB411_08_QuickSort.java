package Sorts;

public class AB411_08_QuickSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] array) {
        sort(array, 0, array.length - 1); // die ganze Reihung sortieren
    }

    private void sort(T[] array, int left, int right) {

        int up = left; // linke Grenze
        int down = right; // rechte Grenze
        final T pivot = array[(left + right) / 2]; // ausgewähltes Element

        do {
            // Suche des grössten Elementes von link an
            while (array[up].compareTo(pivot) < 0)
                up++;

            // Suchen des kleinsten Elementes von rechts an
            while (pivot.compareTo(array[down]) < 0)
                down--;

            // Austauschen der Elemente
            if (up <= down) {
                final T temp = array[up];
                array[up] = array[down];
                array[down] = temp;
                up++;
                down--;
            }
        } while (up <= down); // Überschneidung

        if (left < down)
            sort(array, left, down); // linke Hälfte sortieren
        if (up < right)
            sort(array, up, right); // rechte Hälfte sortieren
    }

}
