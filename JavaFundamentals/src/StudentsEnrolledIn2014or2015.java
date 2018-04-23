import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsEnrolledIn2014or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            students.add(input);
            input = reader.readLine();
        }

        students.stream().filter(s -> s.split(" ")[0].endsWith("14") || s.split(" ")[0].endsWith("15"))
                .forEach(s -> System.out.println(s.split(" ")[1] + " " + s.split(" ")[2] + " " +
                        s.split(" ")[3] + " " + s.split(" ")[4]));
    }
}
