package bookshop_system.services;

import bookshop_system.entities.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CategoryService {
    List<Category> getAllCategories();

    void addCategoriesToDb(List<Category> categories);
}
