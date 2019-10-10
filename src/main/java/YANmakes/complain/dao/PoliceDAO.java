package YANmakes.complain.dao;

import YANmakes.complain.models.Police;
import org.springframework.data.repository.CrudRepository;

public interface PoliceDAO extends CrudRepository<Police,Integer> {
}
