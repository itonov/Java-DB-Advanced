package soft_uni.lab_exercises.advanced_mapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private String birthDay;
    private BigDecimal salary;
    private Boolean isOnHoliday;
    private String address;
    private Employee manager;
    private List<Employee> employees;

    public Employee(String firstName,
                    String lastName,
                    String birthDay,
                    BigDecimal salary,
                    Boolean isOnHoliday,
                    String address,
                    Employee manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.salary = salary;
        this.isOnHoliday = isOnHoliday;
        this.address = address;
        this.manager = manager;
        this.employees = new ArrayList<>();
    }

    public Employee() {
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

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getOnHoliday() {
        return this.isOnHoliday;
    }

    public void setOnHoliday(Boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
