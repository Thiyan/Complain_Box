package YANmakes.complain.dao;

import YANmakes.complain.models.Complain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ComplainDAO extends CrudRepository<Complain,Integer> {


    Complain findByComplainId(int id);

    List<Complain> findByStatus(String status);

    List<Complain> findAllByPoliceAccountIdAndStatus(int parseInt, String status);

    List<Complain> findAllByUserAccountIdAndStatus(int id, String status);
}
