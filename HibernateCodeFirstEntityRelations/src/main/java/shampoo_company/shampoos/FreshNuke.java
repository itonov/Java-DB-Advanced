package shampoo_company.shampoos;

import shampoo_company.ingredients.BasicIngredient;
import shampoo_company.labels.BasicLabel;
import shampoo_company.size.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {

    private static final String BRAND = "Fresh Nuke";

    private static final BigDecimal PRICE = new BigDecimal("9.33");

    @Enumerated
    private static final Size SIZE = Size.LARGE;

    public FreshNuke() {
    }

    public FreshNuke(BasicLabel classicLabel) {
        super(BRAND, PRICE, SIZE, classicLabel);
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public void setBrand(String brand) {
        super.setBrand(brand);
    }

    @Override
    public Set<BasicIngredient> getIngredients() {
        return super.getIngredients();
    }

    @Override
    public void setIngredients(Set<BasicIngredient> ingredients) {
        super.setIngredients(ingredients);
    }
}
