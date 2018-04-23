package shampoo_company.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Nettle")
public class Nettle extends BasicIngredient {

    private static final String NAME = "Nettle";

    private static final BigDecimal PRICE = new BigDecimal("6.12");

    public Nettle() {
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
