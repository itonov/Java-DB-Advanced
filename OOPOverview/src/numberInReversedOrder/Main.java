package numberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputNum = reader.readLine();
        DecimalNumber num = new DecimalNumber(inputNum);
        num.printReversed();
    }
}
