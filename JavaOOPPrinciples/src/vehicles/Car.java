package vehicles;

import java.text.DecimalFormat;

public class Car implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Car(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption + 0.9;
    }

    @Override
    public void refuel(double amount) {
        this.fuelQuantity += amount;
    }

    @Override
    public void drive(double distance) {
        if (this.fuelQuantity < distance * this.fuelConsumption) {
            throw new IllegalArgumentException("Car needs refueling");
        }
        this.fuelQuantity -= this.fuelConsumption * distance;
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Car travelled " + df.format(distance) + " km");
    }

    @Override
    public double getRemainingFuel() {
        return this.fuelQuantity;
    }
}
