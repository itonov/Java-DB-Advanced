package soft_uni.products_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import soft_uni.products_shop.models.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long id);

    @Query(value = "SELECT u FROM User AS u JOIN Product AS p ON u.id = p.seller WHERE p.buyer IS NOT null " +
            "ORDER BY u.lastName, u.firstName")
    List<User> getUsersWithSoldItem();
}