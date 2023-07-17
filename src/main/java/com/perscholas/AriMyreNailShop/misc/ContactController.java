package com.perscholas.AriMyreNailShop.misc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contactMe")
    public String showContactMePage(){
        return "html/contact";
    }


}
