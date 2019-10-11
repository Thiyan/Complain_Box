package YANmakes.complain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/admin-login")
    public String loginAdmin(){
        return "admin/admin-index";
    }

    @RequestMapping("/admin-new-complains")
    public String newComplains(){
        return "admin/notprocess-complaint";
    }

    @RequestMapping("/admin-ongoing-complains")
    public String ongoingComplainAdmin(){
        return "admin/inprocess-complaint";
    }

    @RequestMapping("/admin-closed-complains")
    public String closedComplain(){
        return "admin/closed-complaint";
    }

    @RequestMapping("/admin-manage-users")
    public String manageUsers(){
        return "admin/manage-users";
    }

    @RequestMapping("/admin-add-police")
    public String addPolice(){
        return "admin/add-police";
    }

    @RequestMapping("/admin-manage-police")
    public String managePolice(){
        return "admin/manage-police";
    }

    @RequestMapping("/admin-complain-details")
    public String complainDetails(){
        return "admin/complaint-details";
    }
}

