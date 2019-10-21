import java.util.function.Function;

public class Faculty {

    public static void main(String[] args) {

        Function<Long, Long> faculty = (input) -> {
            for (long i = input - 1; i > 0; i--) {
                input = input * i;
            }
            return input;
        };
        System.out.println(faculty.apply((long) 12));
    }
}
