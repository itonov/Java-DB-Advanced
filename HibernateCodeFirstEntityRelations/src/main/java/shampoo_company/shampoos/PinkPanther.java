package shampoo_company.shampoos;

import shampoo_company.labels.BasicLabel;
import shampoo_company.size.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {

    private static final String BRAND = "Pink Panther";

    private static final BigDecimal PRICE = new BigDecimal("8.50");

    @Enumerated
    private static final Size SIZE = Size.MEDIUM;

    public PinkPanther() {
    }

    public PinkPanther(BasicLabel classicLabel) {
        super(BRAND, PRICE, SIZE, classicLabel);
    }


}
