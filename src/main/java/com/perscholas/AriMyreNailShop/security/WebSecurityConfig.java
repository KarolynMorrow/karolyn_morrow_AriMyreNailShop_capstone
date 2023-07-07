package com.perscholas.AriMyreNailShop.security;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountRepository;
import com.perscholas.AriMyreNailShop.premium.PremiumDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PremiumDetailsServiceImpl premiumDetailsService;

    @Autowired
    private PremiumAccountRepository premiumAccountRepository;

//    private PremiumAccount premium;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    String pass =

    public WebSecurityConfig() {

    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    //WEB ENDPOINTS - RESOURCES THAT WE WANT TO BE SECURED/Setting access
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                        .mvcMatchers("/login").permitAll()
                        .mvcMatchers("/registration").permitAll()
                        .mvcMatchers("/signup").permitAll()
                        .mvcMatchers("/home").permitAll()
                        .mvcMatchers("/chooseService").permitAll()
                        .mvcMatchers("/extraServices").permitAll()
                        .mvcMatchers("/api/**").permitAll()
                        .mvcMatchers("/premiumAccount/**").authenticated()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/userProfile")
                        .failureUrl("/home")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/home"));

    }


//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    //This code tells the AuthenticationManager to use PremiumDetailsServiceImpl instead of
    // userDetailsService grabbing the info passed from the PremiumRepo and encodes the password provided
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsService).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        System.out.println("------------" + premiumDetailsService + "--------------");
    }


//       @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        PasswordEncoder passwordEncoder
//                = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//
//                .withUser("user")
//                .password(passwordEncoder.encode("user"))
//                .roles("USER")
//
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("USER", "ADMIN")
//
//                .and()
//                .withUser("superadmin")
//                .password(passwordEncoder.encode("superadmin"))
//                .roles("USER", "ADMIN", "SUPERADMIN");
//
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//
//
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/**")
                .antMatchers("/**/*.css")
                .antMatchers("/**/*.js")
                .antMatchers("/**/*.png")
                .antMatchers("/**/*.jpg")
                .antMatchers("/h2-console/**");
    }
}
