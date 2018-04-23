package soft_uni.wedding_planner.models.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "weddings")
public class Wedding {

    private Long id;
    private Person bride;
    private Person brideGroom;
    private Date date;
    private Agency agency;
    private Set<Venue> venues;
    private Set<Invitation> invitations;

    public Wedding() {
        this.venues = new HashSet<>();
        this.invitations = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(optional = false, targetEntity = Person.class)
    public Person getBride() {
        return this.bride;
    }

    public void setBride(Person bride) {
        this.bride = bride;
    }

    @OneToOne(optional = false, targetEntity = Person.class)
    public Person getBrideGroom() {
        return this.brideGroom;
    }

    public void setBrideGroom(Person brideGroom) {
        this.brideGroom = brideGroom;
    }

    @Column(nullable = false)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    public Agency getAgency() {
        return this.agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @ManyToMany(mappedBy = "weddings")
    public Set<Venue> getVenues() {
        return this.venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }

    @OneToMany
    public Set<Invitation> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(Set<Invitation> invitations) {
        this.invitations = invitations;
    }
}
