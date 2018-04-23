import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            students.add(input);
            input = reader.readLine();
        }

        students.stream().filter(s -> Arrays.asList(s.split(" ")).contains("6"))
                .forEach(st -> System.out.println(st.split(" ")[0] + " " + st.split(" ")[1]));
    }
}
