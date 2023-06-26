package com.perscholas.AriMyreNailShop.security;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private PremiumAccountRepository premiumAccountRepository;

    @GetMapping("/login")
    public String login(){
        return "html/login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam("userName") String username,
                        @RequestParam("passWord") String password,
                        Model model){
        //Perform validation and authentication logic
        PremiumAccount p = premiumAccountRepository.findByUsername(username);
        if(p != null && p.getPassword().equals(password)){
            session.setAttribute("username", username);
            return "redirect:html/premiumHome";
        } else {
            //Invalid login
            model.addAttribute("error", "Invalid username and/or password");
            return "html/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/home";
    }

}
