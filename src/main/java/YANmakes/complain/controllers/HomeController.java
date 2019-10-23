package YANmakes.complain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String index(){
        return "index";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("error",true);
        return "index";
    }


}

