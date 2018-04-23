package vehicles;

import java.text.DecimalFormat;

public class Truck implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Truck(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption + 1.6;
    }

    @Override
    public void refuel(double amount) {
        this.fuelQuantity += amount * 0.95;
    }

    @Override
    public void drive(double distance) {
        if (this.fuelQuantity < distance * this.fuelConsumption) {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        this.fuelQuantity -= this.fuelConsumption * distance;
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Truck travelled " + df.format(distance) + " km");
    }

    @Override
    public double getRemainingFuel() {
        return this.fuelQuantity;
    }
}
