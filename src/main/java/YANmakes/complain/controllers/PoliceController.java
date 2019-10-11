package YANmakes.complain.controllers;

import YANmakes.complain.services.ComplainService;
import YANmakes.complain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/")
public class PoliceController {

    @Autowired
    private UserService userService;

    @Autowired
    private ComplainService complainService;

    @GetMapping("/police-login")
    public String loginPolice(){
        return "police/police-index";
    }

    @GetMapping("/complain-details")
    public String ComplainDetail(@RequestParam("id") String id,Model model){

        System.out.println(id);
        model.addAttribute("complain",complainService.getComplain(id));
        return "police/complaint-details";
    }

    @RequestMapping("/ongoing-complains")
    public String ongoingComplain(@RequestParam("id") String id,Model model){
        model.addAttribute("complains",complainService.getComplainsByPolice(id,"Pending"));
        return "police/inprocess-complaint";
    }

    @RequestMapping("/closed-complains")
    public String closedComplain(@RequestParam("id") String id,Model model){
        model.addAttribute("complains",complainService.getComplainsByPolice(id,"Closed"));

        return "police/closed-complaint";
    }

    @RequestMapping("/view-users")
    public String viewUsers(Model model){

        model.addAttribute("users",userService.getAllUsers());
        return "police/manage-users";
    }


}

