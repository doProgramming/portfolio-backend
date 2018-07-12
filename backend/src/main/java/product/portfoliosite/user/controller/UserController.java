package product.portfoliosite.user.controller;


import product.portfoliosite.user.dto.UserDTO;
import product.portfoliosite.user.entity.User;
import product.portfoliosite.user.service.impl.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Reusable classic Controller for CRUD made by @Strahinja
 *
 *
 * **/
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl persistenceService;

    @RequestMapping(value = "/save",produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public void save(@RequestParam(value = "firstname") String firstname,@RequestParam(value = "lastname") String lastname,
                     @RequestParam(value = "email")String email){
        User user = createUser(firstname,lastname,email);
        persistenceService.saveEntity(user);
    }
    @RequestMapping(value = "/update" , produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public void update(@RequestParam(value = "id") int id,@RequestParam(value = "firstname") String firstname,@RequestParam(value = "lastname") String lastname,
                     @RequestParam(value = "email")String email){
        User user = updateUser(id,firstname,lastname,email);
        persistenceService.updateUser(user);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "id") int id){
        User user = new User();
        user.setId(id);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public UserDTO get(@RequestParam(value = "id") int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.load( User.class, new Integer(id) );
        if(user != null){
            return persistenceService.mapUserToDto(user);
        }
        return new UserDTO(new User());
    }

    private User createUser(String firstname,String lastname, String email){
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        return user;
    }

    private User updateUser(int id,String firstname,String lastname, String email){
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setId(id);
        return user;
    }
}
