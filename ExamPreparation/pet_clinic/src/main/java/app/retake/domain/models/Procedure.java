package app.retake.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "procedures")
public class Procedure implements Serializable {

    private Integer id;
    private Set<AnimalAid> services;
    private Animal animal;
    private Vet vet;
    private Date date;

    public Procedure() {
        this.services = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany()
    public Set<AnimalAid> getServices() {
        return this.services;
    }

    public void setServices(Set<AnimalAid> services) {
        this.services = services;
    }

    @ManyToOne(targetEntity = Animal.class)
    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @ManyToOne(targetEntity = Vet.class)
    public Vet getVet() {
        return this.vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Transient
    public BigDecimal getPrice() {
        BigDecimal result = new BigDecimal(0);
        this.services.forEach(p -> result.add(p.getPrice()));
        return result;
    }
}
