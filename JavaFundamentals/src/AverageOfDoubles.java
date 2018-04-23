import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> input = Arrays.stream(reader.readLine().split(" ")).map(Double::valueOf).collect(Collectors.toList());

        if (input.isEmpty()) {
            System.out.println("No match");
        } else {
            System.out.printf("%.2f", DoubleStream.of(input.stream().mapToDouble(x -> x).toArray()).average().getAsDouble());
        }
    }
}
