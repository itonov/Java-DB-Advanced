import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            students.add(input);
            input = reader.readLine();
        }

        String firstStartOption = "02";
        String secondStartOption = "+3592";

        students.stream().filter(st -> st.split(" ")[2].startsWith(firstStartOption)
                || st.split(" ")[2].startsWith(secondStartOption))
                .forEach(st -> System.out.println(st.split(" ")[0] + " " + st.split(" ")[1]));
    }
}
