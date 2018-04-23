package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();
        String[] inputPeople = reader.readLine().split(";");
        String[] inputProducts = reader.readLine().split(";");

        for (String person : inputPeople) {
            String name = person.split("=")[0];
            int money = Integer.parseInt(person.split("=")[1]);
            if (name.equalsIgnoreCase("")) {
                System.out.println("Name cannot be empty");
            } else if (money < 0) {
                System.out.println("Money cannot be negative");
            } else {
                people.put(name, new Person(name, money));
            }
        }

        for (String product : inputProducts) {
            String name = product.split("=")[0];
            int cost = Integer.parseInt(product.split("=")[1]);
            if (name.equalsIgnoreCase("")) {
                System.out.println("Name cannot be empty");
            } else if (cost < 0) {
                System.out.println("Money cannot be negative");
            } else {
                products.put(name, new Product(name, cost));
            }
        }

        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String personName = tokens[0];
            String productName = tokens[1];

            if (people.containsKey(personName) && people.get(personName).getMoney() < products.get(productName).getCost()) {
                System.out.println(personName + " can't afford " + productName);
            } else if (people.containsKey(personName)){
                people.get(personName).setMoney(people.get(personName).getMoney() - products.get(productName).getCost());
                people.get(personName).addProduct(products.get(productName));
                System.out.println(personName + " bought " + productName);
            }

            input = reader.readLine();
        }

        for (Map.Entry<String, Person> kvp : people.entrySet()) {
            System.out.print(kvp.getKey() + " -");
            List<Product> bag = kvp.getValue().getProducts();
            if (bag.isEmpty()) {
                System.out.print(" Nothing bought");
            } else {
                for (int i = 0; i < bag.size(); i++) {
                    System.out.print(" " + bag.get(0).getName());
                    if (i + 1 < bag.size()) {
                        System.out.print(",");
                    }
                }
            }
            System.out.println();
        }
    }
}
