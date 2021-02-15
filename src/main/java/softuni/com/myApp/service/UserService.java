package softuni.com.myApp.service;

import softuni.com.myApp.model.Entities.RoleEnum;
import softuni.com.myApp.model.Entities.User;
import softuni.com.myApp.model.serviceModels.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> getAllUsernames();

    void changeRole(String username, RoleEnum roleEnum);

    User findById(Long id);
}
