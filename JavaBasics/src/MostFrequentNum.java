import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MostFrequentNum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int position = 0;
        int bestCount = 0;

        for (int i = 0; i < input.length; i++) {
            int count = 0;
            for (int num : input) {
                if (input[i] == num) {
                    count++;
                }
            }

            if (count > bestCount) {
                position = i;
                bestCount = count;
            }
        }

        System.out.println(input[position]);
    }
}
