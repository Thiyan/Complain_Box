package YANmakes.complain.controllers;

import YANmakes.complain.dto.Assign;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/admin-assign-police")
    public String assignPolice(@RequestParam int complainId, Model model){

        model.addAttribute("complainId",complainId);
        return "admin/assign-police";
    }

    @PostMapping("/admin-assign-police")
    public String assignPoliceProcessing(@Valid Assign assign, RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model){

        System.out.println(assign.toString());
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("success",false);
            return "redirect:/assign-police";
        }

        if(!complainService.assignPolice(assign)){
            redirectAttributes.addFlashAttribute("success",false);
            return "redirect:/assign-police";
        }

        return "redirect:/admin-new-complains";
    }

    @GetMapping("/admin-reject")
    public String rejectComplain(@RequestParam("complainId") int complainId, RedirectAttributes redirectAttributes,Model model){


        if(!complainService.rejectComplain(complainId)){
            redirectAttributes.addFlashAttribute("success",false);
            return "redirect:/admin-new-complains";
        }

        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/admin-new-complains";
    }

    @RequestMapping("/admin-ongoing-complains")
    public String ongoingComplainAdmin(Model model){

        model.addAttribute("complains",complainService.getComplainsByAdmin("Pending"));

        return "admin/inprocess-complaint";
    }

    @RequestMapping("/admin-closed-complains")
    public String closedComplain(Model model){
        model.addAttribute("complains",merge(complainService.getComplainsByAdmin("Closed"),
                complainService.getComplainsByAdmin("Rejected")));

        return "admin/closed-complaint";
    }

    @RequestMapping("/admin-manage-users")
    public String manageUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());

        return "admin/manage-users";
    }

    @RequestMapping("/admin-add-police")
    public String addPolice(Model model){

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
    public String complainDetails(@RequestParam("id") int id, Model model){

        model.addAttribute("complain",complainService.getComplain(String.valueOf(id)));
        return "admin/complaint-details";
    }

    public <T> List<T> merge(List<T> list1, List<T> list2)
    {
        List<T> list = new ArrayList<>();

        list.addAll(list1);
        list.addAll(list2);

        return list;
    }
}

