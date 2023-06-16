package com.perscholas.AriMyreNailShop.premium;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PremiumRestController {
    @PostMapping("/saveExisting")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody @Valid PremiumAccount premiumAccount,
                            BindingResult bindingResult){


    }

}
