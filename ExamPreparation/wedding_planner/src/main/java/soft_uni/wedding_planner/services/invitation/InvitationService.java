package soft_uni.wedding_planner.services.invitation;

import soft_uni.wedding_planner.models.entities.Invitation;

import java.util.List;

public interface InvitationService {

    void saveAllToDb(List<Invitation> invitations);
}