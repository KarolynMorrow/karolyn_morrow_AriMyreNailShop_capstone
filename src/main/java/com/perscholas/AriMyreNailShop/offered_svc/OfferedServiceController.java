package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferedServiceController {
    @GetMapping("/chooseService")
    public String getOfferedServicesPage(){
        return "html/price";
    }

    @GetMapping("/extraServices")
    public String showExtraSvcsPage(){
        return "html/extraSvcs";
    }
}
