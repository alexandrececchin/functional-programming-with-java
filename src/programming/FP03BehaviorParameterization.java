package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        filterAndPrint(numbers, x -> x % 2 == 0);
//        filterAndPrint(numbers, x -> x % 2 != 0);

        List squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);
        System.out.println("Square numbers " + squaredNumbers);

        List cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
        System.out.println("Cube numbers " + cubedNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> squareFunction) {
        return numbers.stream().map(squareFunction).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        System.out.println("###### Print Numbers #########");
        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
