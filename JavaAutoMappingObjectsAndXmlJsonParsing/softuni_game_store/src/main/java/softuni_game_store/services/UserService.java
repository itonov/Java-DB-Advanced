package softuni_game_store.services;

import org.springframework.stereotype.Service;
import softuni_game_store.entities.User;

@Service
public interface UserService {

    void registerUser(User user);

    User findUser(User user);

    User findLoggedUser(User user);
}
