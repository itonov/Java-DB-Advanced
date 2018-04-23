import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        Boolean foundNum = false;

        for (int i = 0; i < input.size(); i++) {
            int leftSum = 0;
            int rightSum = 0;

            if (i > 0 && i < input.size() - 1) {
                for (int j = 0; j < i; j++) {
                    leftSum += input.get(j);
                }

                for (int j = i + 1; j < input.size(); j++) {
                    rightSum += input.get(j);
                }
            } else if (i == 0) {
                for (int j = i + 1; j < input.size(); j++) {
                    rightSum += input.get(j);
                }
            } else if (i == input.size() - 1) {
                for (int j = 0; j < i; j++) {
                    leftSum += input.get(j);
                }
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                foundNum = true;
                break;
            }
        }

        if (!foundNum) {
            System.out.println("no");
        }

    }
}
