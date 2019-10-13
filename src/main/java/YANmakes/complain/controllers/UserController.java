package YANmakes.complain.controllers;

import YANmakes.complain.dto.ComplainDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.services.UserService;
import YANmakes.complain.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-new-complain")
    public String newComplain(Model model){

//        model.addAttribute("user", new UserDTO());
        return "user/register-complaint";
    }

    @PostMapping("/user-new-complain")
    public String newComplainProcess(@Valid ComplainDTO complainDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){

        System.out.println(complainDTO.toString());
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("success",false);
            return "redirect:/user-new-complain";
        }

        userService.createNewComplain(complainDTO);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/user-new-complain";
    }

    @GetMapping("/user-ongoing-complains")
    public String ongoingComplainsUser(Model model){

//        model.addAttribute("user", new UserDTO());
        return "user/inprocess-complaint";
    }

    @GetMapping("/user-closed-complains")
    public String closedComplainsUser(Model model){

//        model.addAttribute("user", new UserDTO());
        return "user/closed-complaint";
    }

    @GetMapping("/user-complain-details")
    public String complainsDetailsUser(Model model){

//        model.addAttribute("user", new UserDTO());
        return "user/complaint-details";
    }

    @GetMapping("/new-user")
    public String newUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("genderType", Gender.values());
        return "user/registration";
    }

    @PostMapping("/new-user")
    public String processNewUser(@ModelAttribute @Valid UserDTO userDTO, BindingResult bindingResult, Model model){

        System.out.println("gahxgj" +userDTO.toString());
        if(bindingResult.hasErrors()){
            return "redirect:/new-user";
        }

        userService.createNewUser(userDTO);
        return "user/registration";
    }

    @GetMapping("/validate-email")
    @ResponseBody
    public String validateEmail(HttpServletRequest request,Model model){
        System.out.println("Triggered");
        String email=request.getParameter("email");

        if(email.equals("") || email==null)
            return "Email must not be empty";

        return userService.validateEmail(email);
    }





//    @GetMapping("/complain-details")
//    public String hello(){
//        return "police/complaint-details";
//    }
//
//    @RequestMapping("/ongoing-complains")
//    public String ongoingComplain(){
//        return "police/inprocess-complaint";
//    }
//
//    @RequestMapping("/closed-complains")
//    public String closedComplain(){
//        return "police/closed-complaint";
//    }
//
//    @RequestMapping("/view-users")
//    public String viewUsers(){
//        return "police/manage-users";
//    }
}

