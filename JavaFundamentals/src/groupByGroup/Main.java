package groupByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);
            people.add(new Person(name, group));
            input = reader.readLine();
        }

        people.stream().collect(Collectors.groupingBy(Person::getGroup))
                .forEach((s, t) -> System.out.printf("%d - %s%n", s.intValue(),
                        t.toString().replaceAll("\\[|]", "")));

    }
}
