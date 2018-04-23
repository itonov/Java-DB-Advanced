package soft_uni.products_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.products_shop.models.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> getAllByPriceBetweenAndBuyerIsNull(BigDecimal start, BigDecimal end);

}