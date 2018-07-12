package product.portfoliosite.date.service;

import product.portfoliosite.date.entity.Date;
import product.portfoliosite.user.entity.User;

public interface ContactService {

    Date sendContact(int hour, int minutes);
    void saveUserAndDate(User user, Date date);
}
