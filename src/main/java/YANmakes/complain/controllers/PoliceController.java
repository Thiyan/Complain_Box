package YANmakes.complain.controllers;

import YANmakes.complain.services.ComplainService;
import YANmakes.complain.services.PoliceService;
import YANmakes.complain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/police")
public class PoliceController {

    @Autowired
    private UserService userService;

    @Autowired
    private ComplainService complainService;

    @Autowired
    private PoliceService policeService;

    @GetMapping("/police-login")
    public String loginPolice(){
        return "police/police-index";
    }

    @GetMapping("/police-complain-details")
    public String ComplainDetail(@RequestParam("id") int id,Model model){

        System.out.println(id);
        model.addAttribute("complain",complainService.getComplain(id));
        return "police/complaint-details";
    }

    @RequestMapping("/police-ongoing-complains")
    public String ongoingComplain(@RequestParam("id") String id,Model model){
        model.addAttribute("complains",complainService.getComplainsByPolice(id,"Pending"));
        return "police/inprocess-complaint";
    }

    @RequestMapping("/police-closed-complains")
    public String closedComplain(@RequestParam("id") String id,Model model){
        model.addAttribute("complains",complainService.getComplainsByPolice(id,"Closed"));

        return "police/closed-complaint";
    }

    @RequestMapping("/police-view-users")
    public String viewUsers(Model model){

        model.addAttribute("users",userService.getAllUsers());
        return "police/manage-users";
    }

    @GetMapping("/validate-police-email")
    @ResponseBody
    public String validateEmail(HttpServletRequest request){
        System.out.println("Triggered");
        String email=request.getParameter("email");

        if(email.equals("") || email==null)
            return "Email must not be empty";

        return policeService.validateEmail(email);
    }


}

