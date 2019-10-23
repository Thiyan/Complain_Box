package YANmakes.complain.controllers;

import YANmakes.complain.dto.ComplainDTO;
import YANmakes.complain.dto.UserDTO;
import YANmakes.complain.services.ComplainService;
import YANmakes.complain.services.UserService;
import YANmakes.complain.utils.Gender;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ComplainService complainService;

    @GetMapping("/user-new-complain")
    public String newComplain(Model model , HttpSession session){

        return "user/register-complaint";
    }

    @PostMapping("/user-new-complain")
    public String newComplainProcess(@Valid ComplainDTO complainDTO, BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes, Model model){


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
    public String ongoingComplainsUser(@RequestParam("id") String id,Model model){


        int i=Integer.parseInt(id);
        model.addAttribute("complains", merge(complainService.getComplainsByUser(i,"New"),
                complainService.getComplainsByUser(i,"Pending")));

        return "user/inprocess-complaint";
    }

    @GetMapping("/user-closed-complains")
    public String closedComplainsUser(@RequestParam("id") int id, Model model){

        model.addAttribute("complains", merge(complainService.getComplainsByUser(id,"Closed"),
                complainService.getComplainsByUser(id,"Rejected")));
        return "user/closed-complaint";
    }

    @GetMapping("/user-complain-details")
    public String complainsDetailsUser(@RequestParam("id") int id, Model model){

        model.addAttribute("complain",complainService.getComplain(id));
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

//    @GetMapping("/validate-email")
//    @ResponseBody
//    public String validateEmail(HttpServletRequest request,Model model){
//        System.out.println("Triggered");
//        String email=request.getParameter("email");
//
//        if(email.equals("") || email==null)
//            return "Email must not be empty";
//
//        return userService.validateEmail(email);
//    }

    // Generic function to join two lists in Java
    public <T> List<T> merge(List<T> list1, List<T> list2)
    {
        List<T> list = new ArrayList<>();

        list.addAll(list1);
        list.addAll(list2);

        return list;
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

