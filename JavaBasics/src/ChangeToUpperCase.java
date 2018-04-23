import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeToUpperCase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = reader.readLine();
        Pattern p = Pattern.compile("<upcase>(\\w* ?\\w*)</upcase>");
        Matcher m = p.matcher(inputText);
        while (m.find()) {
            String replacement = m.group(1).toUpperCase();
            inputText = inputText.replace(m.group(), replacement);
        }

        System.out.println(inputText);
    }
}
