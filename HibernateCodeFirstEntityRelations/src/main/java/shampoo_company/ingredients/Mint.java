package shampoo_company.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Mint")
public class Mint extends BasicIngredient {

    private static final String NAME = "Mint";

    private static final BigDecimal PRICE = new BigDecimal("3.54");

    public Mint() {
        super(NAME, PRICE);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }
}
