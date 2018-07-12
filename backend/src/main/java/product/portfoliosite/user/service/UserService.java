package product.portfoliosite.user.service;

import product.portfoliosite.user.dto.UserDTO;
import product.portfoliosite.user.entity.User;

public interface UserService {

    void updateUser(User user);
    User getUser(int id);
    void deleteUser(int id);
    UserDTO mapUserToDto(User bean);
}
