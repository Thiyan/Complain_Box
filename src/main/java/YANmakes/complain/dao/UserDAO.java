package YANmakes.complain.dao;

import YANmakes.complain.models.Police;
import YANmakes.complain.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User,Integer> {

    boolean existsByEmail(String email);

}