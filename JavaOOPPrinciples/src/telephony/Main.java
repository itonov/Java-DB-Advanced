package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = Arrays.asList(reader.readLine().split(" "));
        List<String> urls = Arrays.asList(reader.readLine().split(" "));
        Smartphone smartphone = new Smartphone();

        for (String number : numbers) {
            boolean containsLetter = false;
            for (char letter : number.toCharArray()){
                if (Character.isLetter(letter)) {
                    containsLetter = true;
                    System.out.println("Invalid number!");
                    break;
                }
            }

            if (!containsLetter) {
                smartphone.call(number);
            }
        }

        for (String url : urls) {
            boolean containsDigits = false;
            for (char letter : url.toCharArray()) {
                if (Character.isDigit(letter)) {
                    containsDigits = true;
                    System.out.println("Invalid URL!");
                    break;
                }
            }

            if (!containsDigits) {
                smartphone.browse(url);
            }
        }
    }
}
