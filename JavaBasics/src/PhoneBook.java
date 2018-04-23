import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, String> phoneBook = new TreeMap<>();

        while (!"end".equalsIgnoreCase(input)) {
            if (input.equalsIgnoreCase("listall")){
                for (Map.Entry<String, String> kvp : phoneBook.entrySet()) {
                    System.out.println(kvp.getKey() + " -> " + kvp.getValue());
                }
            } else {
                String[] tokens = input.split(" ");
                String name = tokens[1];

                switch (tokens[0]) {
                    case "A":
                        String number = tokens[2];
                        phoneBook.put(name, number);
                        break;
                    case "S":
                        if (phoneBook.containsKey(name)) {
                            System.out.println(name + " -> " + phoneBook.get(name));
                        } else {
                            System.out.printf("Contact %s does not exist.%n", name);
                        }
                        break;
                    default:
                        break;
                }
            }
            input = reader.readLine();
        }
    }
}
