package averageGrades;

import java.util.Arrays;

public class Student {
    private String name;
    private double[] grades;

    public Student(String name, double... grades) {
        this.name = name;
        this.grades = grades;
    }

    public double averageGrade() {
        return Arrays.stream(this.grades).average().getAsDouble();
    }

    public String getName() {
        return this.name;
    }
}
