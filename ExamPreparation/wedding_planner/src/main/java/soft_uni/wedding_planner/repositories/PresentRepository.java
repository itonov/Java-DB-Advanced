package soft_uni.wedding_planner.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import soft_uni.wedding_planner.models.entities.Present;

@Repository
public interface PresentRepository extends JpaRepository<Present,Long> {


}