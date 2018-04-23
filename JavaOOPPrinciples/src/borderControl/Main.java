package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Entrant> entrants = new ArrayList<>();
        List<Birthable> birthables = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String name = tokens[1];

            switch (tokens[0]) {
                case "Robot":
                    String id = tokens[2];
                    entrants.add(new Robot(name, id));
                    break;
                case "Citizen":
                    int age = Integer.parseInt(tokens[2]);
                    id = tokens[3];
                    String birthdate = tokens[4];
                    birthables.add(new Citizen(name, age, id, birthdate));
                    break;
                case "Pet":
                    birthdate = tokens[2];
                    birthables.add(new Pet(name, birthdate));
                default:
                    break;
            }
            input = reader.readLine();
        }

        String neededYear = reader.readLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthdate().endsWith(neededYear)) {
                System.out.println(birthable.getBirthdate());
            }
        }
    }
}
