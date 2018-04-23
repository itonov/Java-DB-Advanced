package app.repositories;

import app.model.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<BasicIngredient, Long> {

    List<BasicIngredient> findByNameIsStartingWith(String start);

    List<BasicIngredient> findByNameIsInOrderByPriceAsc(List<String> names);

    List<BasicIngredient> findByNameIsIn(List<String> name);
}
