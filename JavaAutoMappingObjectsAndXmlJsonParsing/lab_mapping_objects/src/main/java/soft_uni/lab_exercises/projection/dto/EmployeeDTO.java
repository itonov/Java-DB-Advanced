package soft_uni.lab_exercises.projection.dto;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private String lasatName;
    private BigDecimal salary;
    private String managerLastName;

    public EmployeeDTO() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasatName() {
        return this.lasatName;
    }

    public void setLasatName(String lasatName) {
        this.lasatName = lasatName;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getManagerLastName() {
        return this.managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }
}
