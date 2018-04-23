package soft_uni.wedding_planner.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {

    private Long id;
    private String firstName;
    private String middleNameInitial;
    private String lastName;
    private String gender;
    private String birthDate;
    private String phone;
    private String email;

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || !(firstName.length() > 1 && firstName.length() < 60)) {
            throw new IllegalArgumentException("Error. Invalid data provided");
        }
        this.firstName = firstName;
    }

    @Column(length = 1, nullable = false)
    public String getMiddleNameInitial() {
        return this.middleNameInitial;
    }

    public void setMiddleNameInitial(String middleNameInitial) {

        if (middleNameInitial == null || middleNameInitial.length() > 1) {
            throw new IllegalArgumentException("Error. Invalid data provided");
        }
        this.middleNameInitial = middleNameInitial;
    }

    @Column(nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() < 2) {
            throw new IllegalArgumentException("Error. Invalid data provided");
        }
        this.lastName = lastName;
    }

    @Column(nullable = false)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender == null || !(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")
                || gender.equalsIgnoreCase("not specified"))) {
            throw new IllegalArgumentException("Error. Invalid data provided");
        }
        this.gender = gender;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email != null) {
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Error. Invalid data provided");
            }
            String[] tokens = email.split("@");
            if (!tokens[0].matches("\\w+")) {
                throw new IllegalArgumentException("Error. Invalid data provided");
            }
            if (!tokens[1].matches("^[a-z]*\\.[a-z]*$")) {
                throw new IllegalArgumentException("Error. Invalid data provided");
            }
        }
        this.email = email;
    }
}
