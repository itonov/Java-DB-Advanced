package soft_uni.wedding_planner.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "invitations")
public class Invitation {

    private Long id;
    private Wedding wedding;
    private Person guest;
    private Present present;
    private Boolean isAttending;
    private String family;

    public Invitation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false, targetEntity = Wedding.class)
    public Wedding getWedding() {
        return this.wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
    }

    @OneToOne(optional = false, targetEntity = Person.class)
    public Person getGuest() {
        return this.guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    @OneToOne(targetEntity = Present.class)
    public Present getPresent() {
        return this.present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }

    public Boolean getAttending() {
        return this.isAttending;
    }

    public void setAttending(Boolean attending) {
        isAttending = attending;
    }

    @Column(nullable = false)
    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
