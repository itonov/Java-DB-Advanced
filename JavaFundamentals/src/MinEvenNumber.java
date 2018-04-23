import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> numbers = Arrays.stream(reader.readLine().split(" ")).map(Double::valueOf)
                .collect(Collectors.toList());

        if (numbers.isEmpty()) {
            System.out.println("No match");
        } else {
            numbers.stream().filter(n -> n % 2.0 == 0).sorted(Double::compare).limit(1).forEach(s -> System.out.printf("%.2f", s));
        }
    }
}
