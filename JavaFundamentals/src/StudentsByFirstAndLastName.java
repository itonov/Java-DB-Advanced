import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> firstNames = new ArrayList<>();
        List<String> lastNames = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String firstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            firstNames.add(firstName);
            lastNames.add(lastName);
            input = reader.readLine();
        }

        for (int i = 0; i < firstNames.size(); i++) {
            if (firstNames.get(i).compareTo(lastNames.get(i)) < 0) {
                System.out.println(firstNames.get(i) + " " + lastNames.get(i));
            }
        }
    }
}
