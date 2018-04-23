package soft_uni.wedding_planner.services.wedding;

import soft_uni.wedding_planner.models.entities.Wedding;
import soft_uni.wedding_planner.repositories.WeddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WeddingServiceImpl implements WeddingService {

	private final WeddingRepository weddingRepository;

	@Autowired
	public WeddingServiceImpl(WeddingRepository weddingRepository) { 
		this.weddingRepository = weddingRepository;
	}

	@Override
	public void saveToDb(Wedding wedding) {
		this.weddingRepository.saveAndFlush(wedding);
	}
}