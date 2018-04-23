package soft_uni.products_shop.services.product;

import soft_uni.products_shop.models.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void save(List<Product> products);

    List<Product> productsInRangeWithoutBuyer(BigDecimal start, BigDecimal end);

    List<Product> getAll();
}