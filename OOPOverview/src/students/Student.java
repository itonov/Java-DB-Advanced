package students;

public class Student {
    private static int counter = 0;

    private String name;

    public Student(String name) {
        this.name = name;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
