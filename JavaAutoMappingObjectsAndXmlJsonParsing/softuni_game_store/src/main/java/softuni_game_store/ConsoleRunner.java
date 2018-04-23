package softuni_game_store;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni_game_store.dto.UserLoginDto;
import softuni_game_store.dto.UserLogoutDto;
import softuni_game_store.dto.UserRegisterDto;
import softuni_game_store.entities.User;
import softuni_game_store.repositories.UserRepository;
import softuni_game_store.services.UserService;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public ConsoleRunner(UserRepository userRepository, UserService userService) {
        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTokens = reader.readLine().split("\\|");

        switch (inputTokens[0]) {
            case "RegisterUser":
                try {
                    registerUser(inputTokens);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                break;
            case "LoginUser":
                try {

                    loginUser(inputTokens);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                break;
            case "Logout":
                try {
                    logoutUser();
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
        }
    }

    private void logoutUser() {
        UserLogoutDto userLogoutDto = new UserLogoutDto();
        User user = this.userService.findLoggedUser(this.modelMapper.map(userLogoutDto, User.class));
        if (user == null) {
            throw new IllegalStateException("Cannot log out. No user was logged in.");
        }
        user.setLogged(false);
        System.out.println("User " + user.getFullName() + " successfully logged out");
    }

    private void loginUser(String[] inputTokens) {
        UserLoginDto userLoginDto = new UserLoginDto(inputTokens[1], inputTokens[2]);
        User user = this.userService.findUser(this.modelMapper.map(userLoginDto, User.class));
        if (user == null) {
            throw new IllegalArgumentException("Incorrect username / password");
        }
        user.setLogged(true);
        System.out.println("Successfully logged in " + user.getFullName());
    }

    private void registerUser(String[] inputTokens) {
        if (!inputTokens[2].equals(inputTokens[3])) {
            throw new IllegalArgumentException("Password doesn't match");
        }

        UserRegisterDto userRegisterDto = new UserRegisterDto(inputTokens[1], inputTokens[2], inputTokens[4]);
        User user = this.modelMapper.map(userRegisterDto, User.class);
        this.userService.registerUser(user);
        System.out.println(user.getFullName() + " was registered");
    }
}
