package soft_uni.wedding_planner.models.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "agencies")
public class Agency {

    private Long id;
    @Expose
    private String name;
    @Expose
    private Integer employeesCount;
    @Expose
    private String town;

    public Agency() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public Integer getEmployeeCount() {
        return this.employeesCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeesCount = employeeCount;
    }

    @Basic
    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
