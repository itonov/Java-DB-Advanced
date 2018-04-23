package soft_uni.wedding_planner.models.dtos.binding.invitation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvitationImportDto {

    @Expose
    @SerializedName(value = "Name")
    private String name;
    @Expose
    @SerializedName(value = "RSVP")
    private Boolean rsvp;
    @Expose
    @SerializedName(value = "Family")
    private String family;

    public InvitationImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRsvp() {
        return this.rsvp;
    }

    public void setRsvp(Boolean rsvp) {
        this.rsvp = rsvp;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
