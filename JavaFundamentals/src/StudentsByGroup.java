import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Map<String, String>, Integer> students = new HashMap<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];
            int group = Integer.parseInt(tokens[2]);
            students.put(new TreeMap<String, String>() {{ put(firstName, secondName); }}, group);
            input = reader.readLine();
        }

        students.entrySet().stream().filter(s -> s.getValue() == 2).map(Map.Entry::getKey)
                .forEach(s -> s.forEach((key, value) -> System.out.println(key + " " + value)));


    }
}