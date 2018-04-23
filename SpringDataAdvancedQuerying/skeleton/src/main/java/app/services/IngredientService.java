package app.services;

import app.model.ingredients.BasicIngredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    List<BasicIngredient> getIngredientsWithNameStarting(String start);

    List<BasicIngredient> getIngredientsByNamesStarting(List<String> names);

    List<BasicIngredient> getIngredientsByExactNames(List<String> names);
}
