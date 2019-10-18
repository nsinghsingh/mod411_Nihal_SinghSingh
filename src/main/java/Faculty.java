import java.util.function.Function;

public class Faculty {

    public static void main(String[] args) {

        Function<Integer, Integer> faculty = (input) -> {
            for (int i = input - 1; i > 0; i--) {
                input = input * i;
            }
            return input;
        };
        System.out.println(faculty.apply(10));
    }
}
