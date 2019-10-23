package YANmakes.complain.services;

import YANmakes.complain.dao.AccountsDAO;
import YANmakes.complain.dao.ComplainDAO;
import YANmakes.complain.dao.RoleDAO;
import YANmakes.complain.dto.ComplainDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.Account;
import YANmakes.complain.models.Complain;
import YANmakes.complain.models.Role;
import YANmakes.complain.utils.ComplainStatus;
import YANmakes.complain.utils.Gender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


    @Autowired
    private AccountsDAO accountsDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ComplainDAO complainDAO;

    @Autowired
    private ModelMapper getMapper;


    private static String UPLOADED_FOLDER = "/Users/apple/Documents/files/";

    public UserDTO createNewUser(UserDTO userDTO){

        Account account  = getMapper.map(userDTO, Account.class);

        account.setGender(userDTO.getGender().getValue());
        account=accountsDAO.save(account);

        userDTO.setUserId(account.getAccountId());

        return userDTO;

    }

//    public String validateEmail(String email) {
//        boolean val=userDAO.existsByEmail(email);
//
//        if(val)
//            return "Duplicate";
//
//        return "Unique";
//    }

    /*
    * Done
    * */

    public List<UserDTO> getAllUsers(){

        List<UserDTO> userDTOS=new ArrayList<>();

        Set<Role> roles=new HashSet<>();

        roles.add(roleDAO.findByRoleId(1));

        roles.forEach(role -> System.out.println("Roles "+role));


        List<Account> users= (List<Account>) accountsDAO.findByRoles(roles);

        if(users.isEmpty() || users==null)
            return new ArrayList<>();

        for (Account user:users){
            UserDTO userDTO=getMapper.map(user,UserDTO.class);
            Gender gender=Gender.valueOf(user.getGender().toUpperCase());
            userDTO.setGender(gender);
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    public ComplainDTO createNewComplain(ComplainDTO complainDTO) {

        Complain complain  = getMapper.map(complainDTO, Complain.class);
        complain.setStatus(ComplainStatus.NEW.getValue());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        complain.setDate(dtf.format(now));

        if (!storeImage(complainDTO.getAttachment()).equals("Empty file"))
          complain.setFile(storeImage(complainDTO.getAttachment()));


        complain=complainDAO.save(complain);

        complainDTO=getMapper.map(complain,ComplainDTO.class);


        return complainDTO;

    }

    public String storeImage(MultipartFile file){

        if (file.isEmpty())
            return "Empty file";

        Path path = null;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());


            Files.write(path, bytes);



        } catch (IOException e) {
            e.printStackTrace();
        }

        return path.toString();


    }
}
