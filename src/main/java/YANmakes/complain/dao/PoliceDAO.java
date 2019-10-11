package YANmakes.complain.dao;

import YANmakes.complain.models.Police;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PoliceDAO extends CrudRepository<Police,Integer> {
    boolean existsByEmail(String email);
}
