package product.portfoliosite.user.login.service.impl;

import org.springframework.stereotype.Component;
import product.portfoliosite.user.login.service.LoginService;

import javax.jws.WebService;

@Component
public class LoginServiceImpl implements LoginService {
    @Override
    public Boolean validateLogin(String username, String password) {
        if(username != null && password != null){
            if(username.toLowerCase().equals("lestra") && password.toLowerCase().equals("sreda")){
                return true;
            }
        }return false;
    }
}
