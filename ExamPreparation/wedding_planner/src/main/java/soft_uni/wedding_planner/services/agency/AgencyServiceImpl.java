package soft_uni.wedding_planner.services.agency;

import soft_uni.wedding_planner.models.entities.Agency;
import soft_uni.wedding_planner.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {

	private final AgencyRepository agencyRepository;

	@Autowired
	public AgencyServiceImpl(AgencyRepository agencyRepository) { 
		this.agencyRepository = agencyRepository;
	}

	@Override
	public void saveAllToDb(List<Agency> agencies) {
		for (Agency agency : agencies) {
			this.agencyRepository.save(agency);
			System.out.println("Successfully imported " + agency.getName());
		}
	}
}