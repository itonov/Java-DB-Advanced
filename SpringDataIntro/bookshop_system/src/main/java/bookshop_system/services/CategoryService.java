package bookshop_system.services;

import bookshop_system.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();

    void addCategoriesToDb(List<Category> categories);
}
