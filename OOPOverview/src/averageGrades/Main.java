package averageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int studentsCount = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] input = reader.readLine().split(" ");
            students.add(new Student(input[0], Arrays.stream(Arrays.copyOfRange(input, 1, input.length))
                    .mapToDouble(Double::valueOf).toArray()));
        }

        students = students.stream().filter(s -> s.averageGrade() >= 5.50)
                .sorted(Comparator.comparing(Student::getName).thenComparing((s2, s1) -> Double.compare(s1.averageGrade(), s2.averageGrade())))
                .collect(Collectors.toList());

        for (Student student : students) {
            System.out.printf("%s -> %.2f%n", student.getName(), student.averageGrade());
        }
    }
}
