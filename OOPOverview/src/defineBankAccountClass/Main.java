package defineBankAccountClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<BankAccount> accounts = new ArrayList<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Create":
                    accounts.add(new BankAccount());
                    System.out.printf("Account ID%d created%n", accounts.size());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    accounts.get(id - 1).deposit(amount);
                    System.out.printf("Deposited %f to ID%d%n", amount, id);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    System.out.println(accounts.get(id - 1).getInterest(years));
                    break;
                default:
                    break;
            }

            input = reader.readLine();
        }

    }
}
