package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<SoundProducible> animals = new ArrayList<>();

        while (true) {
            String animalType = reader.readLine();
            if ("beast!".equalsIgnoreCase(animalType)) {
                break;
            }
            String[] animalTokens = reader.readLine().split(" ");
            String name = animalTokens[0];
            int age = Integer.parseInt(animalTokens[1]);
            String gender = animalTokens[2];

            if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
                System.out.println("Invalid input");
            } else if (!animalType.equalsIgnoreCase("cat") && !animalType.equalsIgnoreCase("dog")
                    && !animalType.equalsIgnoreCase("frog") && !animalType.equalsIgnoreCase("tomcat")
                    && !animalType.equalsIgnoreCase("kitten")) {
                System.out.println("Invalid input");
            } else {
                switch (animalType) {
                    case "Cat":
                        try {
                            animals.add(new Cat(name, age, gender));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Dog":
                        try {
                            animals.add(new Dog(name, age, gender));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Kitten":
                        try {
                            animals.add(new Kitten(name, age));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Tomcat":
                        try {
                            animals.add(new Tomcat(name, age));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Frog":
                        try {
                            animals.add(new Frog(name, age, gender));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        for (SoundProducible animal : animals) {
            System.out.println(animal.toString());
            animal.produceSound();
        }
    }
}
