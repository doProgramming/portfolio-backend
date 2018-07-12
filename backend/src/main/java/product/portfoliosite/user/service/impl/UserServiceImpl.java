package product.portfoliosite.user.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import product.portfoliosite.user.dto.UserDTO;
import product.portfoliosite.user.entity.User;
import product.portfoliosite.user.service.Entity;
import product.portfoliosite.user.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

/** Reusable classic Service for CRUD made by @Strahinja
 *
 *
 * **/

@Component
@Qualifier(value = "User")
public class UserServiceImpl implements UserService,Entity {

    private SessionFactory sessionFactory = null;

    @Override
    public void saveEntity(Object user){
        Session session = createSessino();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        Session session = createSessino();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public User getUser(int id) {
        Session session = createSessino();
        User user = (User) session.load(User.class, id);
        return user;

    }

    @Override
    public void deleteUser(int id) {
        Session session = createSessino();
        User user = (User) session.load(User.class, id);
        if(user != null){
        session.delete(user);}
    }

    private Session createSessino(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    //Mapping entity bean to DTO

    public UserDTO mapUserToDto(User bean){
        UserDTO user = null;
        if(bean != null){
        user = new UserDTO(bean);}
        return user;
    }

}
