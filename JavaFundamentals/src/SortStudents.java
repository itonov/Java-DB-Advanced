import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            students.add(input);
            input = reader.readLine();
        }

        students.stream().sorted(Comparator.comparing((String s) -> s.split(" ")[1])
                .thenComparing(Comparator.comparing((String s) -> s.split(" ")[0]).reversed()))
                .forEach(System.out::println);
    }
}
