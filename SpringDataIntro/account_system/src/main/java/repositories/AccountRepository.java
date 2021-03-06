package repositories;

import models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
