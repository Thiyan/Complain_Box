package YANmakes.complain.services;

import YANmakes.complain.dao.AccountsDAO;

import YANmakes.complain.dao.RoleDAO;

import YANmakes.complain.dto.PoliceDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.Account;
import YANmakes.complain.models.Role;
import YANmakes.complain.utils.Gender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PoliceService {


    @Autowired
    private ModelMapper getMapper;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private AccountsDAO accountsDAO;

    Set<Role> roles=new HashSet<>();

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

    public String validateEmail(String email) {
        boolean val=accountsDAO.existsByEmail(email);

        if(val)
            return "Duplicate";

        return "Unique";
    }

    public List<PoliceDTO> getAllPolice(){

        List<PoliceDTO> policeDTOS=new ArrayList<>();



        List<Account> polices= (List<Account>) accountsDAO.findByRolesRoleId(2);

        if(polices.isEmpty() || polices==null)
            return new ArrayList<>();

        for (Account police:polices){
            PoliceDTO policeDTO=getMapper.map(police,PoliceDTO.class);
            Gender gender=Gender.valueOf(police.getGender().toUpperCase());
            policeDTO.setGender(gender);
            policeDTOS.add(policeDTO);

            System.out.println(policeDTO.toString());
        }



        return policeDTOS;
    }

    /*
    * Done
    * */
    public PoliceDTO createNewPolice(PoliceDTO policeDTO) {

        Account police  = getMapper.map(policeDTO, Account.class);

        police.setGender(policeDTO.getGender().getValue());

        Set<Role> roles=new HashSet<>();

        roles.add(roleDAO.findByRoleId(2));

        police.setRoles(roles);

        police.setPassword("12345");
        police=accountsDAO.save(police);

        policeDTO.setAccountId(police.getAccountId());

        return policeDTO;
    }
//
//    public String validateEmail(String email) {
//        boolean val=policeDAO.existsByEmail(email);
//
//        if(val)
//            return "Duplicate";
//
//        return "Unique";
//    }
}
