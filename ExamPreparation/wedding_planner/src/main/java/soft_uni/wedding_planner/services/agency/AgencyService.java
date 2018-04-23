package soft_uni.wedding_planner.services.agency;

import soft_uni.wedding_planner.models.entities.Agency;

import java.util.List;

public interface AgencyService {

    void saveAllToDb(List<Agency> agencies);
}