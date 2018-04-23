package soft_uni.wedding_planner.models.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Present {

    private Long id;
    private Person owner;
    private Invitation invitation;

    public Present() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(targetEntity = Person.class)
    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @OneToOne(targetEntity = Invitation.class)
    public Invitation getInvitation() {
        return this.invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }
}
