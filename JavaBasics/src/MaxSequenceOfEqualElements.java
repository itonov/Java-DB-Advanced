import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int start = 0;
        int length = 1;

        int bestStart = 0;
        int bestLength = 1;

        for (int i = input.length - 2; i >= 0; i--) {
            if (input[i + 1] == input[i]) {
                length++;
            } else {
                start = i;
                length = 1;
            }

            if (length >= bestLength) {
                bestStart = i;
                bestLength = length;
            }
        }

        for (int i = bestStart; i < input.length; i++) {
            System.out.print(input[i] + " ");
            bestLength--;
            if (bestLength == 0) {
                break;
            }
        }
    }
}
