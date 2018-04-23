package soft_uni.products_shop.models.dto.views.user;

import com.google.gson.annotations.Expose;
import soft_uni.products_shop.models.dto.views.product.ProductViewModelSeparateNames;

import java.util.HashSet;
import java.util.Set;

public class UserViewModel {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductViewModelSeparateNames> soldProducts;

    public UserViewModel() {
        this.soldProducts = new HashSet<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductViewModelSeparateNames> getSoldProducts() {
        return this.soldProducts;
    }

    public void setSoldProducts(Set<ProductViewModelSeparateNames> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
