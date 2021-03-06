package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}


public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));

        Comparator<Course> comparingByNoOfStudentsIncrease = Comparator.comparing(Course::getNoOfStudents);

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsIncrease).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecrease = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsDecrease).collect(Collectors.toList()));


        Comparator<Course> comparingByNoOfStudentsAndReviews = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndReviews).collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndReviews).limit(5).collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndReviews).skip(3).collect(Collectors.toList()));

        System.out.println(courses);
        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));
        System.out.println(courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

        System.out.println(courses.stream().max(comparingByNoOfStudentsDecrease));

        System.out.println(courses.stream().min(comparingByNoOfStudentsDecrease).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsDecrease).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).findFirst());

        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findFirst());

        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findAny());


        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).sum());//88000

        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).average());//OptionalDouble[22000.0]

        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).count());//4

        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).max());

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //Get Course with highest review in the category
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore)))));
        // Get the name of the courses group by category
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));


        //Working with HOC
        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);

    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
}
