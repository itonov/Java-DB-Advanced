import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            students.put(firstName + " " + lastName, age);
            input = reader.readLine();
        }

        students.entrySet().stream().filter(st -> st.getValue() >= 18 && st.getValue() <= 24)
                .forEach(st -> System.out.println(st.getKey() + " " + st.getValue()));
    }
}
