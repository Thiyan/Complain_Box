package YANmakes.complain.dao;

import YANmakes.complain.models.Complain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ComplainDAO extends CrudRepository<Complain,Integer> {

    List<Complain> findAllByPolicePoliceIdAndStatus(int id,String status);

    Complain findByComplainId(int id);

    List<Complain> findByStatus(String status);

    List<Complain> findAllByUserUserIdAndStatus(int id, String status);
}
