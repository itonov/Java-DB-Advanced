package soft_uni.products_shop.services.user;

import soft_uni.products_shop.models.entities.User;
import soft_uni.products_shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) { 
		this.userRepository = userRepository;
	}

	@Override
	public void save(List<User> users) {
		this.userRepository.saveAll(users);
	}

	@Override
	public List<User> allUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User findUser(Long id) {
		return this.userRepository.findUserById(id);
	}

	@Override
	public List<User> getAllSellersWithBuyer() {
		return this.userRepository.getUsersWithSoldItem();
	}


}