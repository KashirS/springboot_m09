package cat.itb.mo9_practicauf1.controller;

import cat.itb.mo9_practicauf1.model.entity.User;
import cat.itb.mo9_practicauf1.model.service.UserService;
import cat.itb.mo9_practicauf1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MainController {

    private UserService service;

    @GetMapping("/register")
    public String addUser(Model m){
        m.addAttribute("userForm",new User());
        return "register";
    }

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register/submit")
    public String registerSubmit(@ModelAttribute("userFrom")User u){
        service.addUser(new User(u.getName(),passwordEncoder.encode(u.getPassword()),"USER"));
        return "redirect:/login";
    }

    @GetMapping("/error")
    public String loginPage(){
        return "error";
    }

}
