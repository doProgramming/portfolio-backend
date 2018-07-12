package product.portfoliosite.date.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import product.portfoliosite.date.service.ContactService;
import product.portfoliosite.user.entity.User;
import product.portfoliosite.user.service.Entity;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    @Qualifier(value = "Date")
    Entity entity;

    @RequestMapping(name = "/sendContactInfo")
    public void sendContact(@RequestParam (value = "hours") int hours, @RequestParam (value = "minutes") int minutes,
                            @RequestParam (value = "firstname") String firstName,
                            @RequestParam(value = "lastname")String lastname, @RequestParam
                                        (value = "email") String email){
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastname);
        contactService.saveUserAndDate(user,contactService.sendContact(hours,minutes));
    }
}
