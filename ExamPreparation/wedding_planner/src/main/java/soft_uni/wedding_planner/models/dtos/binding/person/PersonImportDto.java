package soft_uni.wedding_planner.models.dtos.binding.person;

import com.google.gson.annotations.Expose;

public class PersonImportDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String middleInitial;
    @Expose
    private String gender;
    @Expose
    private String birthDate;
    @Expose
    private String phone;
    @Expose
    private String email;

    public PersonImportDto() {
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

    public String getMiddleNameInitial() {
        return this.middleInitial;
    }

    public void setMiddleNameInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
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
        this.email = email;
    }
}
