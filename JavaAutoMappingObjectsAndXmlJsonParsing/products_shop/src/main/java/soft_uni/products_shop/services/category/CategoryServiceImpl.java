package soft_uni.products_shop.services.category;

import soft_uni.products_shop.models.entities.Category;
import soft_uni.products_shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) { 
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void save(List<Category> categories) {
		this.categoryRepository.saveAll(categories);
	}

	@Override
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}
}