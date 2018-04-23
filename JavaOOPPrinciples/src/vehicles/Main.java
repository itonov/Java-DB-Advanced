package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carTokens = reader.readLine().split(" ");
        String[] truckTokens = reader.readLine().split(" ");
        int linesCount = Integer.parseInt(reader.readLine());

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        for (int i = 0; i < linesCount; i++) {
            String[] inputTokens = reader.readLine().split(" ");
            double value = Double.parseDouble(inputTokens[2]);

            switch (inputTokens[0]) {
                case "Drive":
                    switch (inputTokens[1]) {
                        case "Car":
                            try {
                                car.drive(value);
                            } catch (IllegalArgumentException iae) {
                                System.out.println(iae.getMessage());
                            }
                            break;
                        case "Truck":
                            try {
                                truck.drive(value);
                            } catch (IllegalArgumentException iae) {
                                System.out.println(iae.getMessage());
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "Refuel":
                    switch (inputTokens[1]) {
                        case "Car":
                            car.refuel(value);
                            break;
                        case "Truck":
                            truck.refuel(value);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getRemainingFuel());
        System.out.printf("Truck: %.2f", truck.getRemainingFuel());
    }
}
