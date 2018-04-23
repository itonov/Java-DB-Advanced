package soft_uni.products_shop.services.category;

import soft_uni.products_shop.models.entities.Category;

import java.util.List;

public interface CategoryService {

    void save(List<Category> categories);

    List<Category> getAll();
}