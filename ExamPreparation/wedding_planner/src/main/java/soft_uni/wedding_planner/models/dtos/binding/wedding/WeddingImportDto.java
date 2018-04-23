package soft_uni.wedding_planner.models.dtos.binding.wedding;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import soft_uni.wedding_planner.models.dtos.binding.invitation.InvitationImportDto;

import java.util.Date;
import java.util.List;

public class WeddingImportDto {

    @Expose
    @SerializedName(value = "Bride")
    private String brideName;
    @Expose
    @SerializedName(value = "Bridegroom")
    private String bridegroomName;
    @Expose
    @SerializedName(value = "Date")
    private Date date;
    @Expose
    @SerializedName(value = "Agency")
    private String agency;
    @Expose
    @SerializedName(value = "Guests")
    private List<InvitationImportDto> invitations;

    public WeddingImportDto() {
    }

    public String getBrideName() {
        return this.brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getBridegroomName() {
        return this.bridegroomName;
    }

    public void setBridegroomName(String bridegroomName) {
        this.bridegroomName = bridegroomName;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgency() {
        return this.agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<InvitationImportDto> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(List<InvitationImportDto> invitations) {
        this.invitations = invitations;
    }
}
