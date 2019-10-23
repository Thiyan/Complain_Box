package YANmakes.complain.services;

import YANmakes.complain.dao.AccountsDAO;
import YANmakes.complain.dao.ComplainDAO;

import YANmakes.complain.dto.Assign;
import YANmakes.complain.dto.ComplainDTO;
import YANmakes.complain.dto.Evidence;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.models.Account;
import YANmakes.complain.models.Complain;
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
    private AccountsDAO accountsDAO;

    @Autowired
    private ComplainDAO complainDAO;


    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper getMapper;

    List<ComplainDTO> complainDTOS;


    public List<ComplainDTO> getComplainsByPolice(String id, String status) {

        complainDTOS=new ArrayList<>();

        List<Complain> complains= (List<Complain>) complainDAO.findAllByPoliceAccountIdAndStatus(Integer.parseInt(id),status);



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

    public List<ComplainDTO> getComplainsByUser(int id, String status) {

        complainDTOS=new ArrayList<>();

        List<Complain> complains= (List<Complain>) complainDAO.findAllByUserAccountIdAndStatus(id,status);

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

    /*
    * Done
    * */

    public ComplainDTO getComplain(int id) {

        Complain complain=complainDAO.findByComplainId(id);

        if(complain.equals(null) || complain==null)
            return new ComplainDTO();

        ComplainDTO complainDTO=getMapper.map(complain,ComplainDTO.class);

        complainDTO.setStatus(ComplainStatus.valueOf(complain.getStatus().toUpperCase()));

        return complainDTO;


    }

    /*
    * Done
    * */

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


    /*
    * Done
    * */

    public boolean assignPolice(Assign assign) {

        Complain complain=complainDAO.findByComplainId(assign.getComplainId());

        Account police=accountsDAO.findByAccountId(assign.getOfficerId());

        if(complain == null)
            return false;

        complain.setPolice(police);
        complain.setRemark(assign.getRemarks());

        complain.setStatus(ComplainStatus.PENDING.getValue());

        complainDAO.save(complain);


        return true;

    }


    /*
    * Done
    * */
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
