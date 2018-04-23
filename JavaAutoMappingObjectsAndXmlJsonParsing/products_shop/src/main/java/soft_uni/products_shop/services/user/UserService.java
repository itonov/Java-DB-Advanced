package soft_uni.products_shop.services.user;

import soft_uni.products_shop.models.entities.User;

import java.util.List;

public interface UserService {

    void save(List<User> users);

    List<User> allUsers();

    User findUser(Long id);

    List<User> getAllSellersWithBuyer();
}