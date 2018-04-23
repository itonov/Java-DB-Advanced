package soft_uni.wedding_planner.services.present;

import soft_uni.wedding_planner.repositories.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PresentServiceImpl implements PresentService {

	private final PresentRepository presentRepository;

	@Autowired
	public PresentServiceImpl(PresentRepository presentRepository) { 
		this.presentRepository = presentRepository;
	}

}