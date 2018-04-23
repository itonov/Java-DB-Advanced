import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split(" "));
        char letter = reader.readLine().charAt(0);

        System.out.println(names.stream().sorted().filter(s -> s.toLowerCase().charAt(0) == letter).findFirst().get());
    }
}
