package YANmakes.complain.services;

import YANmakes.complain.dao.ComplainDAO;
import YANmakes.complain.dao.UserDAO;
import YANmakes.complain.dto.ComplainDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.Complain;
import YANmakes.complain.models.User;
import YANmakes.complain.utils.ComplainStatus;
import YANmakes.complain.utils.Gender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplainService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ComplainDAO complainDAO;

    @Autowired
    private ModelMapper getMapper;

    List<ComplainDTO> complainDTOS;




    public List<ComplainDTO> getComplainsByPolice(String id, String status) {

        complainDTOS=new ArrayList<>();

        List<Complain> complains= (List<Complain>) complainDAO.findAllByPolicePoliceIdAndStatus(Integer.parseInt(id),status);

        if(complains.isEmpty())
            System.out.println("Empty");

        for(Complain complain : complains){
            System.out.println("Reached");
            ComplainDTO complainDTO=getMapper.map(complain,ComplainDTO.class);
            complainDTO.setStatus(ComplainStatus.valueOf(complain.getStatus().toUpperCase()));
            complainDTOS.add(complainDTO);
        }

        return complainDTOS;


    }

    public ComplainDTO getComplain(String id) {

        Complain complain=complainDAO.findByComplainId(Integer.parseInt(id));

        if(complain.equals(null) || complain==null)
            return new ComplainDTO();

        ComplainDTO complainDTO=getMapper.map(complain,ComplainDTO.class);

        complainDTO.setStatus(ComplainStatus.valueOf(complain.getStatus().toUpperCase()));

        return complainDTO;


    }

    public List<ComplainDTO> getComplainsByAdmin(String status) {


        complainDTOS=new ArrayList<>();

        List<Complain> complains= (List<Complain>) complainDAO.findByStatus(status);


        if(complains.isEmpty())
            System.out.println("Empty");

        for(Complain complain : complains){
            System.out.println("Reached");
            ComplainDTO complainDTO=getMapper.map(complain,ComplainDTO.class);
            complainDTO.setStatus(ComplainStatus.valueOf(complain.getStatus().toUpperCase()));
            System.out.println(complainDTO.toString());
            complainDTOS.add(complainDTO);
        }

        return complainDTOS;
    }
}
