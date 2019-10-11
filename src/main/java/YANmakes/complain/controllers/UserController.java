package YANmakes.complain.controllers;

import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.services.UserService;
import YANmakes.complain.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
//@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

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

