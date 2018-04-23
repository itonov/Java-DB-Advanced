import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CensorEmailAddresses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String email = reader.readLine();
        String text = reader.readLine();
        String domain = email.substring(email.indexOf("@"));
        int starsCount = email.substring(0, email.indexOf("@")).length();
        StringBuilder replacement = new StringBuilder();

        for (int i = 0; i < starsCount; i++) {
            replacement.append("*");
        }
        replacement.append(domain);
        System.out.println(text.replaceAll(email, replacement.toString()));
    }
}
