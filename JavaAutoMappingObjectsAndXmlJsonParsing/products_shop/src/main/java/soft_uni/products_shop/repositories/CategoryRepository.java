package soft_uni.products_shop.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import soft_uni.products_shop.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}