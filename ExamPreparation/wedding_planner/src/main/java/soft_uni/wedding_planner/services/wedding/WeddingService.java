package soft_uni.wedding_planner.services.wedding;

import soft_uni.wedding_planner.models.entities.Wedding;

public interface WeddingService {

    void saveToDb(Wedding wedding);
}