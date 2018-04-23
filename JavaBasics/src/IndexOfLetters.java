import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IndexOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] input = reader.readLine().toCharArray();
        List<Integer> indexes = new ArrayList<>();

        for (char c : input){
            for (int i = 0; i < alphabet.length; i++) {
                if (c == alphabet[i]) {
                    indexes.add(i);
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " -> " + indexes.get(i));
        }
    }
}
