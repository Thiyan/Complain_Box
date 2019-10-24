package YANmakes.complain.controllers;

import YANmakes.complain.dto.Assign;
import YANmakes.complain.dto.Evidence;
import YANmakes.complain.services.ComplainService;
import YANmakes.complain.services.PoliceService;
import YANmakes.complain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String ComplainDetail(@RequestParam("id") String id,Model model){

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


    @RequestMapping("/police-add-evidence")
    public String addEvidence(@RequestParam int complainId, Model model){

        model.addAttribute("complainId",complainId);
        return "police/add-evidence";
    }

    @PostMapping("/police-add-evidence")
    public String assignEvidenceProcessing(@Valid Evidence evidence, RedirectAttributes redirectAttributes, BindingResult bindingResult,
                                           HttpSession session,Model model){

        System.out.println(evidence.toString());
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("success",false);
            return "redirect:/police-complain-details?id="+evidence.getComplainId();
        }

        if(!complainService.addEvidence(evidence)){
            redirectAttributes.addFlashAttribute("success",false);
            return "redirect:/police-complain-details?id="+evidence.getComplainId();
        }

        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/police-ongoing-complains?id="+session.getAttribute("userNo");
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

