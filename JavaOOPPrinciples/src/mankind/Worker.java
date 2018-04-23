package mankind;

public class Worker extends Human {
    private double salary;
    private double workingHours;

    public Worker(String firstName, String lastName, double salary, double workingHours) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkingHours(workingHours);
    }

    public double getSalary() {
        return this.salary;
    }

    public double getWorkingHours() {
        return this.workingHours;
    }

    public double calculateSalaryPerHour() {
        return (this.salary / 7) / this.workingHours;
    }

    private void setSalary(double salary) {
        if (salary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    private void setWorkingHours(double hours) {
        if (hours < 1 || hours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = hours;
    }
}
