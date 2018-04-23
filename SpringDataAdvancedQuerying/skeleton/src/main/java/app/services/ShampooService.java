package app.services;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.shampoos.BasicShampoo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ShampooService {
    List<BasicShampoo> getAllShampoosWithSizeOrderedById(Size size);

    List<BasicShampoo> getAllShampoosBySizeOrLabelId(Size size, long id);

    List<BasicShampoo> getShampoosWithPriceHigherThan(BigDecimal price);

    Integer countByPriceLowerThan(BigDecimal price);

    List<BasicShampoo> getShampoosByIngredientsName(List<BasicIngredient> ingredients);

    List<BasicShampoo> getShampoosWithIngredientCountsLessThan(Long num);

    BigDecimal getShampooIngredientsTotalPrice(String shampooName);
}
