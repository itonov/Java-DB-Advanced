package soft_uni.lab_exercises.simple_mapping;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public EmployeeDTO() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
