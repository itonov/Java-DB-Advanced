import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.asList(reader.readLine().split(" "));
        List<Integer> nums = input.stream().filter(FindAndSumIntegers::isNumeric).map(Integer::valueOf)
                .collect(Collectors.toList());

        if (nums.isEmpty()) {
            System.out.println("No match");
        } else {
            System.out.println(nums.stream().mapToInt(Integer::valueOf).sum());
        }
    }

    public static boolean isNumeric(String string) {
        try {
            int num = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
