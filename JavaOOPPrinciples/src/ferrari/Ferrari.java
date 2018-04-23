package ferrari;

public class Ferrari implements Car {
    private String model = "488-Spider";
    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public void useBrakes() {
        System.out.print("Brakes!");
    }

    @Override
    public void pushGasPedal() {
        System.out.print("Zadu6avam sA!");
    }
}
