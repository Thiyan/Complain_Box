package YANmakes.complain.dao;

import YANmakes.complain.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface AccountsDAO extends CrudRepository<Account,Integer> {


    Optional<Account> findByEmail(String email);
}
