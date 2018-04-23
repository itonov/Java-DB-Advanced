import models.Account;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import services.AccountServiceImpl;
import services.UserServiceImpl;

import java.math.BigDecimal;

@SpringBootConfiguration
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner() {
    }

    @Override
    public void run(String... strings) throws Exception {
        User example = new User();
        example.setUserName("example");
        example.setAge(20);

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));

        example.getAccounts().add(account);
        userService.registerUser(example);
    }
}
