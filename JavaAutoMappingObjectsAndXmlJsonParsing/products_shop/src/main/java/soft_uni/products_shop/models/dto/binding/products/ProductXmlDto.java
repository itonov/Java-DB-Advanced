package soft_uni.products_shop.models.dto.binding.products;

import soft_uni.products_shop.models.dto.views.product.ProductViewModelSeparateNames;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductXmlDto {

    @XmlElement(name = "product")
    private List<ProductViewModelSeparateNames> products;

    public ProductXmlDto() {
    }

    public List<ProductViewModelSeparateNames> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductViewModelSeparateNames> products) {
        this.products = products;
    }
}
