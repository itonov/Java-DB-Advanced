package vehicles;

public interface Vehicle {
    void refuel(double amount);

    void drive(double distance);

    double getRemainingFuel();
}
