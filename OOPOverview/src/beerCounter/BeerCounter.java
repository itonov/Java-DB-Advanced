package beerCounter;

public class BeerCounter {
    private static int beerInStock;
    private static int beersDrankCount;

    public static void buyBeer(int bottlesCount) {
        beerInStock += bottlesCount;
    }

    public static void drinkBeer(int bottlesCount) {
        beerInStock -= bottlesCount;
        beersDrankCount += bottlesCount;
    }

    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeersDrankCount() {
        return beersDrankCount;
    }
}
