package com.perscholas.AriMyreNailShop.misc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/aboutMe")
    public String showAboutMePage(){
        return "html/about";
    }
}
