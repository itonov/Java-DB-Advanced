import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReverseCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            characters.add(reader.readLine().charAt(0));
        }

        for (int i = characters.size() - 1; i >= 0; i--) {
            System.out.print(characters.get(i));
        }
    }
}
