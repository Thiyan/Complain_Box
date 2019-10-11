package YANmakes.complain.services;

import YANmakes.complain.dao.PoliceDAO;
import YANmakes.complain.dao.UserDAO;
import YANmakes.complain.dto.PoliceDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.Police;
import YANmakes.complain.models.User;
import YANmakes.complain.utils.Gender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoliceService {

    @Autowired
    private PoliceDAO policeDAO;

    @Autowired
    private ModelMapper getMapper;

//    public UserDTO createNewUser(UserDTO userDTO){
//
//        User user  = getMapper.map(userDTO, User.class);
//
//        user.setGender(userDTO.getGender().getValue());
//        user=userDAO.save(user);
//
//        userDTO.setUserId(user.getUserId());
//
//        return userDTO;
//
//    }

//    public String validateEmail(String email) {
//        boolean val=userDAO.existsByEmail(email);
//
//        if(val)
//            return "Duplicate";
//
//        return "Unique";
//    }

    public List<PoliceDTO> getAllPolice(){

        List<PoliceDTO> policeDTOS=new ArrayList<>();

        List<Police> polices= (List<Police>) policeDAO.findAll();

        if(polices.isEmpty() || polices==null)
            return new ArrayList<>();

        for (Police police:polices){
            PoliceDTO policeDTO=getMapper.map(police,PoliceDTO.class);
            Gender gender=Gender.valueOf(police.getGender().toUpperCase());
            policeDTO.setGender(gender);
            policeDTOS.add(policeDTO);
        }

        return policeDTOS;
    }

    public PoliceDTO createNewPolice(PoliceDTO policeDTO) {

        Police police  = getMapper.map(policeDTO, Police.class);

        police.setGender(policeDTO.getGender().getValue());
        police=policeDAO.save(police);

        policeDTO.setPoliceId(police.getPoliceId());

        return policeDTO;
    }

    public String validateEmail(String email) {
        boolean val=policeDAO.existsByEmail(email);

        if(val)
            return "Duplicate";

        return "Unique";
    }
}
