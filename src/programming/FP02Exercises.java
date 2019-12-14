package programming;

import java.util.List;

import static java.lang.String.format;

public class FP02Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int square = numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
        System.out.println(format("Square result = %s", square));

        int cube = numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
        System.out.println(format("Cube result = %s", cube));

        int sumOdd = numbers.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum);
        System.out.println(format("Odd result = %s", sumOdd));
    }

}
