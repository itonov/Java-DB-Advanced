package soft_uni.products_shop.models.dto.binding.categories;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryBindingModel {

    @Expose
    @XmlElement(name = "name")
    private String name;

    public CategoryBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
