package app.services;

import app.model.ingredients.BasicIngredient;
import app.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<BasicIngredient> getIngredientsWithNameStarting(String start) {
        return this.ingredientRepository.findByNameIsStartingWith(start);
    }

    @Override
    public List<BasicIngredient> getIngredientsByNamesStarting(List<String> names) {
        return this.ingredientRepository.findByNameIsInOrderByPriceAsc(names);
    }

    @Override
    public List<BasicIngredient> getIngredientsByExactNames(List<String> names) {
        return this.ingredientRepository.findByNameIsIn(names);
    }
}
