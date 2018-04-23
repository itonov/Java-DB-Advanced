import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitStringIn20Chars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        if (input.length() < 20) {
            int diff = 20 - input.length();
            StringBuilder sb = new StringBuilder(input);
            for (int i = 0; i < diff; i++) {
                sb.append("*");
            }
            System.out.print(sb.toString());
        } else {
            System.out.println(input.substring(0, 20));
        }
    }
}
