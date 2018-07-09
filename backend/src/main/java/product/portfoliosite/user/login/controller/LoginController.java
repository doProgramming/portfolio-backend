package product.portfoliosite.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import product.portfoliosite.user.login.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public  void login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
       loginService.validateLogin(username, password);
    }
}
