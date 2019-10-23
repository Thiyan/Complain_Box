package YANmakes.complain.dao;

import YANmakes.complain.models.Account;
import YANmakes.complain.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public interface AccountsDAO extends CrudRepository<Account,Integer> {

    Optional<Account> findByEmail(String email);

    List<Account> findByRoles(Set<Role> roles);

    Account findByAccountId(int id);
}
