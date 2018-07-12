package product.portfoliosite.date.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import product.portfoliosite.date.service.ContactService;
import product.portfoliosite.date.entity.Date;
import product.portfoliosite.user.entity.User;
import product.portfoliosite.user.service.Entity;

@Component
@Qualifier(value = "Date")
public class ContactServiceImpl implements ContactService,Entity {


    private SessionFactory sessionFactory = null;

    private Session createSessino(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    @Override
    public Date sendContact(int hour, int minutes) {
        Date date = new Date();
        date.setMinutes(minutes);
        date.setHour(hour);
        return date;
    }


    @Override
    public void saveEntity(Object date) {
        Session session = createSessino();
        session.beginTransaction();
        session.save(date);
        session.getTransaction().commit();
    }

    @Override
    public void saveUserAndDate(User user, Date date){
        Session session = createSessino();
        session.beginTransaction();
        session.save(user);
        date.setUserForeignkey(user.getId());
        session.save(date);
        session.getTransaction().commit();
        session.close();
    }
}
