package beerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            int[] beersCount = Arrays.stream(input.split(" ")).mapToInt(Integer::valueOf).toArray();
            int beersBought = beersCount[0];
            int beersDrank = beersCount[1];
            BeerCounter.buyBeer(beersBought);
            BeerCounter.drinkBeer(beersDrank);
            input = reader.readLine();
        }

        System.out.printf("%d %d", BeerCounter.getBeerInStock(), BeerCounter.getBeersDrankCount());
    }
}
