import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            students.add(input);
            input = reader.readLine();
        }

        for (String student : students) {
            String[] studentGrades = Arrays.copyOfRange(student.split(" "), 2, student.split(" ").length);
            int gradesCounter = 0;

            for (String studentGrade : studentGrades) {
                if (Integer.parseInt(studentGrade) <= 3) {
                    gradesCounter++;
                }
            }

            if (gradesCounter >= 2) {
                System.out.println(student.split(" ")[0] + " " + student.split(" ")[1]);
            }
        }
    }
}
