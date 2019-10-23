package YANmakes.complain.services;

import YANmakes.complain.dao.ComplainDAO;
import YANmakes.complain.dao.PoliceDAO;
import YANmakes.complain.dao.UserDAO;
import YANmakes.complain.dto.Assign;
import YANmakes.complain.dto.ComplainDTO;
import YANmakes.complain.dto.Evidence;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.Complain;
import YANmakes.complain.models.Police;
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
    private PoliceDAO policeDAO;

    @Autowired
    private UserService userService;

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


    }    public List<ComplainDTO> getComplainsByUser(int id, String status) {

        complainDTOS=new ArrayList<>();

        List<Complain> complains= (List<Complain>) complainDAO.findAllByUserUserIdAndStatus(id,status);

        if(complains.isEmpty())
            return complainDTOS;

        for(Complain complain : complains){
            System.out.println("Reached");
            ComplainDTO complainDTO=getMapper.map(complain,ComplainDTO.class);
            complainDTO.setStatus(ComplainStatus.valueOf(complain.getStatus().toUpperCase()));
            complainDTOS.add(complainDTO);
        }

        return complainDTOS;


    }

    public ComplainDTO getComplain(int id) {

        Complain complain=complainDAO.findByComplainId(id);

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
            return complainDTOS;

        for(Complain complain : complains){
            System.out.println("Reached");
            ComplainDTO complainDTO=getMapper.map(complain,ComplainDTO.class);
            complainDTO.setStatus(ComplainStatus.valueOf(complain.getStatus().toUpperCase()));
            System.out.println(complainDTO.toString());
            complainDTOS.add(complainDTO);
        }

        return complainDTOS;
    }

    public boolean assignPolice(Assign assign) {

        Complain complain=complainDAO.findByComplainId(assign.getComplainId());

        Police police=policeDAO.findByPoliceId(assign.getOfficerId());

        if(complain == null)
            ;

        complain.setPolice(police);
        complain.setRemark(assign.getRemarks());

        complain.setStatus(ComplainStatus.PENDING.getValue());

        complainDAO.save(complain);


        return true;

    }

    public boolean rejectComplain(int complainId) {

        Complain complain=complainDAO.findByComplainId(complainId);

        if(complain==null)
            return false;

        complain.setStatus(ComplainStatus.REJECTED.getValue());

        complainDAO.save(complain);
        return true;

    }

    public boolean addEvidence(Evidence evidence) {
        System.out.println("Trigger");
        Complain complain=complainDAO.findByComplainId(evidence.getComplainId());

        System.out.println("Pass");

        if(complain==null)
            return false;

        complain.setStatus(ComplainStatus.CLOSED.getValue());

        complain.setOfficerRemark(evidence.getOfficerRemarks());

        complain.setDocument(userService.storeImage(evidence.getDocument()));

        complainDAO.save(complain);

        return true;

    }
}
