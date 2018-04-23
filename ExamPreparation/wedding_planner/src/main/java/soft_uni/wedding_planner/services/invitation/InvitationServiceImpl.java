package soft_uni.wedding_planner.services.invitation;

import soft_uni.wedding_planner.models.entities.Invitation;
import soft_uni.wedding_planner.repositories.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvitationServiceImpl implements InvitationService {

	private final InvitationRepository invitationRepository;

	@Autowired
	public InvitationServiceImpl(InvitationRepository invitationRepository) { 
		this.invitationRepository = invitationRepository;
	}

	@Override
	public void saveAllToDb(List<Invitation> invitations) {
		this.invitationRepository.saveAll(invitations);
	}
}