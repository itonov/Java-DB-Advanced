import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VarInHexadecimalFormat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String hexFormat = reader.readLine();
        System.out.println(Integer.parseInt(hexFormat, 16));
    }
}
