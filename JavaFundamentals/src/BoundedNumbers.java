import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> bounds = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf)
                .collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf)
                .collect(Collectors.toList());

        numbers.stream().filter(n -> n >= bounds.get(0) && n <=  bounds.get(1)).forEach(n -> System.out.print(n + " "));
    }
}
