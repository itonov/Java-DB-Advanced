package soft_uni.wedding_planner.services.venue;

import soft_uni.wedding_planner.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VenueServiceImpl implements VenueService {

	private final VenueRepository venueRepository;

	@Autowired
	public VenueServiceImpl(VenueRepository venueRepository) { 
		this.venueRepository = venueRepository;
	}

}