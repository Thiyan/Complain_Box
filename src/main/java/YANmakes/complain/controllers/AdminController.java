package YANmakes.complain.controllers;

import YANmakes.complain.dto.PoliceDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.services.ComplainService;
import YANmakes.complain.services.PoliceService;
import YANmakes.complain.services.UserService;
import YANmakes.complain.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    private UserService userService;

    @Autowired
    private PoliceService policeService;

    @GetMapping("/admin-login")
    public String loginAdmin(){
        return "admin/admin-index";
    }

    @RequestMapping("/admin-new-complains")
    public String newComplains(Model model){

        model.addAttribute("complains",complainService.getComplainsByAdmin("New"));
        return "admin/notprocess-complaint";
    }

    @RequestMapping("/admin-ongoing-complains")
    public String ongoingComplainAdmin(Model model){

        model.addAttribute("complains",complainService.getComplainsByAdmin("Pending"));

        return "admin/inprocess-complaint";
    }

    @RequestMapping("/admin-closed-complains")
    public String closedComplain(Model model){
        model.addAttribute("complains",complainService.getComplainsByAdmin("Closed"));

        return "admin/closed-complaint";
    }

    @RequestMapping("/admin-manage-users")
    public String manageUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());

        return "admin/manage-users";
    }

    @RequestMapping("/admin-add-police")
    public String addPolice(Model model){
        model.addAttribute("genderType", Gender.values());

        return "admin/add-police";
    }

    @RequestMapping(value = "/admin-add-police", method = RequestMethod.POST)
    public String processAddPolice(@ModelAttribute @Valid PoliceDTO policeDTO, BindingResult bindingResult, Model model){
        model.addAttribute("genderType", Gender.values());

        System.out.println("gahxgj" +policeDTO.toString());
        if(bindingResult.hasErrors()){
            return "redirect:/new-user";
        }

        policeService.createNewPolice(policeDTO);
        return "admin/add-police";
    }

    @RequestMapping("/admin-manage-police")
    public String managePolice(Model model){

        model.addAttribute("polices",policeService.getAllPolice());

        return "admin/manage-police";
    }

    @RequestMapping("/admin-complain-details")
    public String complainDetails(@RequestParam("id") String id, Model model){

        model.addAttribute("complain",complainService.getComplain(id));
        return "admin/complaint-details";
    }
}

