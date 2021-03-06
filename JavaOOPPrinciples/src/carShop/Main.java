package carShop;

public class Main {
    public static void main(String[] args) {
        Car seat = new Seat("Leon", "gray", 110, "Spain", 11111.1);
        Car audi = new Audi("Leon", "gray", 110, "Spain", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format("%s is %s color and have %s horse power",
                car.getModel(), car.getColor(), car.getHorsePower()));
        System.out.println(car.toString());
    }
}
