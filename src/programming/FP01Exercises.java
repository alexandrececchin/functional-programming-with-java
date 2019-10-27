package programming;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
//        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printOddNumbersInListFunctional(numbers);


        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
//        courses.forEach(System.out::println);

//        courses.stream().filter(word -> word.contains("Spring")).forEach(System.out::println);
        courses.stream().filter(word -> word.length() >= 4).forEach(System.out::println);

    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
    }
}
