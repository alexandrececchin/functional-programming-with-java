package programming;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class FP02Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        int square = numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
//        System.out.println(format("Square result = %s", square));
//
//        int cube = numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
//        System.out.println(format("Cube result = %s", cube));
//
//        int sumOdd = numbers.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum);
//        System.out.println(format("Odd result = %s", sumOdd));
//
//        System.out.println("#################");
//        // Print all the distinct values from de list
//        numbers.stream().distinct().forEach(System.out::println);
//        System.out.println("#################");
//        // Print all the numbers sorted
//        numbers.stream().sorted().forEach(System.out::println);

//        List<Integer> doubleNumbers = doubleList(numbers);
//        System.out.println(doubleNumbers);
        List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(format("Even List %s", evenNumbers));

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<Integer> coursesLength = courses.stream().map(c -> c.length()).collect(Collectors.toList());
        System.out.println(format("Courses Length List %s", coursesLength));
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).collect(Collectors.toList());
    }

}
