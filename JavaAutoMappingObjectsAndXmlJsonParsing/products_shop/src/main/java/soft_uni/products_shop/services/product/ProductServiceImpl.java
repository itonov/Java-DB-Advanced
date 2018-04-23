package soft_uni.products_shop.services.product;

import soft_uni.products_shop.models.entities.Product;
import soft_uni.products_shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) { 
		this.productRepository = productRepository;
	}

	@Override
	public void save(List<Product> products) {
		this.productRepository.saveAll(products);
	}

	@Override
	public List<Product> productsInRangeWithoutBuyer(BigDecimal start, BigDecimal end) {
		return this.productRepository.getAllByPriceBetweenAndBuyerIsNull(start, end);
	}

	@Override
	public List<Product> getAll() {
		return this.productRepository.findAll();
	}
}