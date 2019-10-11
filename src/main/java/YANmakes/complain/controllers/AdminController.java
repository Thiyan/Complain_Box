package YANmakes.complain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/admin-login")
    public String loginAdmin(){
        return "admin/admin-index";
    }

    @RequestMapping("/new-complains")
    public String newComplains(){
        return "admin/notprocess-complaint";
    }

    @RequestMapping("/ongoing-complains")
    public String ongoingComplainAdmin(){
        return "admin/inprocess-complaint";
    }

    @RequestMapping("/closed-complains")
    public String closedComplain(){
        return "admin/closed-complaint";
    }

    @RequestMapping("/manage-users")
    public String manageUsers(){
        return "admin/manage-users";
    }

    @RequestMapping("/add-police")
    public String addPolice(){
        return "admin/add-police";
    }

    @RequestMapping("/manage-police")
    public String managePolice(){
        return "admin/manage-police";
    }

    @RequestMapping("/complain-details")
    public String complainDetails(){
        return "admin/complaint-details";
    }
}

