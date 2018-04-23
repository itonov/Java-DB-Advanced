package app.repositories;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<BasicShampoo, Long> {
    List<BasicShampoo> findBySizeOrderById(Size size);

    List<BasicShampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, long id);

    List<BasicShampoo> findByPriceAfterOrderByPriceDesc(BigDecimal price);

    Integer countByPriceBefore(BigDecimal price);

    List<BasicShampoo> findByIngredientsIsIn(List<BasicIngredient> ingredients);

    @Query(value = "SELECT s FROM BasicShampoo s JOIN s.ingredients i GROUP BY s HAVING COUNT(i) < :num")
    List<BasicShampoo> findByIngredientsLessThan(@Param(value = "num") Long num);

    @Query(value = "SELECT SUM(i.price) FROM BasicShampoo s JOIN s.ingredients i WHERE s.brand = :name")
    BigDecimal getTotalIngredientsPriceForShampoo(@Param(value = "name") String name);
}
