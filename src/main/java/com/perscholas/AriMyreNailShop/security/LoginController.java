package com.perscholas.AriMyreNailShop.security;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String showLogin(){
        return "html/login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam("userName") String username,
                        @RequestParam("passWord") String password,
                        Model model){
        //Perform validation and authentication logic
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute("username", username);
            return "redirect:/premiumAccount";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "Invalid username or password");
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
