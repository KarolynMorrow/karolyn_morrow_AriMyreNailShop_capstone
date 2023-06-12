package com.perscholas.AriMyreNailShop.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showGuestHomePage(){
        return "html/home";
    }
}
