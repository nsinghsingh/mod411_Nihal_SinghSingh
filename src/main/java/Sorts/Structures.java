package Sorts;

import java.util.Random;

public class Structures {

    static Random random = new Random();

    public static Integer[] makeArray(int count) {
        Integer[] array = new Integer[count];
        for (long i = 0; i < count; i++) {
            array[(int) i] = random.nextInt();
        }
        return array;
    }

}
