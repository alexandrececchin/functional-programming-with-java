package programming;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printOddNumbersInListFunctional(numbers);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter( n -> n % 2 != 0).forEach(System.out::println);
    }
}
