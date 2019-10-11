package YANmakes.complain.services;

import YANmakes.complain.dao.UserDAO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.User;
import YANmakes.complain.utils.Gender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper getMapper;

    public UserDTO createNewUser(UserDTO userDTO){

        User user  = getMapper.map(userDTO, User.class);

        user.setGender(userDTO.getGender().getValue());
        user=userDAO.save(user);

        userDTO.setUserId(user.getUserId());

        return userDTO;

    }

    public String validateEmail(String email) {
        boolean val=userDAO.existsByEmail(email);

        if(val)
            return "Duplicate";

        return "Unique";
    }

    public List<UserDTO> getAllUsers(){

        List<UserDTO> userDTOS=new ArrayList<>();

        List<User> users= (List<User>) userDAO.findAll();

        if(users.isEmpty() || users==null)
            return new ArrayList<>();

        for (User user:users){
            UserDTO userDTO=getMapper.map(user,UserDTO.class);
            Gender gender=Gender.valueOf(user.getGender().toUpperCase());
            userDTO.setGender(gender);
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }
}
