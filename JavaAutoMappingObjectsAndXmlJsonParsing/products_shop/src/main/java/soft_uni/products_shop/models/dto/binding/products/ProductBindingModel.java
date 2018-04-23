package soft_uni.products_shop.models.dto.binding.products;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductBindingModel {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
