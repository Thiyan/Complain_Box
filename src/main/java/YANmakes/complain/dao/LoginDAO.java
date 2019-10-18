package YANmakes.complain.dao;

import YANmakes.complain.models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LoginDAO extends CrudRepository<Login,Integer> {
}
