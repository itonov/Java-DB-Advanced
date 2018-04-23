package softuni_game_store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni_game_store.entities.User;
import softuni_game_store.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void registerUser(User user) {
        if (this.userRepository.findAll().size() > 0) {
            user.setAdmin(true);
        }
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User findUser(User user) {
        return this.userRepository.findByEmail(user.getEmail());
    }

    @Override
    public User findLoggedUser(User user) {
        return this.userRepository.findByLogged(user.getLogged());
    }
}
