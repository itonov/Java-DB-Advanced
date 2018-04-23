package soft_uni.products_shop.models.dto.binding.categories;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryBindingModelXml {

    @XmlElement(name = "category")
    private List<CategoryBindingModel> categories;

    public CategoryBindingModelXml() {
    }

    public List<CategoryBindingModel> getCategories() {
        return this.categories;
    }

    public void setCategories(List<CategoryBindingModel> categories) {
        this.categories = categories;
    }
}
