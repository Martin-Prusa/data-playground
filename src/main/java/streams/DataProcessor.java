package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().anyMatch(i -> i.getType() == GradeType.A);
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream()
                .map(i -> i.getAge())
                .toList();
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(student -> student.getAge() >= minAge).toList();
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.MALE).toList().size();
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.FEMALE).collect(Collectors.averagingDouble(student -> student.getAge()));
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().map(student -> student.getAge()).reduce(1, (acc, i) -> acc*i);
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().filter(grade -> grade.getType() != GradeType.F).map(grade -> grade.getType().getValue()).reduce(1, (acc, grade) -> acc * grade);
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return student.getGrades().stream().filter(grade -> grade.getSubject() == Subject.MATH).max(Comparator.comparing(grade -> grade.getType().getValue()));
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        return students.stream().map(student -> student.getAge()).sorted().toList();
    }

    // endregion
}
