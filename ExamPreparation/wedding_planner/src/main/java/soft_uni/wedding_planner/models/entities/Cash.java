package soft_uni.wedding_planner.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cash_presents")
public class Cash extends Present {

    private BigDecimal amount;

    public Cash() {
    }

    @Column(nullable = false)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
