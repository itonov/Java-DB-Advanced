package shampoo_company.shampoos;

import shampoo_company.ingredients.BasicIngredient;
import shampoo_company.labels.BasicLabel;
import shampoo_company.size.Size;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {
    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    BasicLabel getLabel();

    void setLabel(BasicLabel label);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);
}
