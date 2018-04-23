package app.services;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.shampoos.BasicShampoo;
import app.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<BasicShampoo> getAllShampoosWithSizeOrderedById(Size size) {
        return this.shampooRepository.findBySizeOrderById(size);
    }

    @Override
    public List<BasicShampoo> getAllShampoosBySizeOrLabelId(Size size, long id) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, id);
    }

    @Override
    public List<BasicShampoo> getShampoosWithPriceHigherThan(BigDecimal price) {
        return this.shampooRepository.findByPriceAfterOrderByPriceDesc(price);
    }

    @Override
    public Integer countByPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countByPriceBefore(price);
    }

    @Override
    public List<BasicShampoo> getShampoosByIngredientsName(List<BasicIngredient> ingredients) {
        return this.shampooRepository.findByIngredientsIsIn(ingredients);
    }

    @Override
    public List<BasicShampoo> getShampoosWithIngredientCountsLessThan(Long num) {
        return this.shampooRepository.findByIngredientsLessThan(num);
    }

    @Override
    public BigDecimal getShampooIngredientsTotalPrice(String shampooName) {
        return this.shampooRepository.getTotalIngredientsPriceForShampoo(shampooName);
    }


}
