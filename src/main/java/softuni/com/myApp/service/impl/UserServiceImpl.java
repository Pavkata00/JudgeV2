package softuni.com.myApp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.com.myApp.model.Entities.RoleEnum;
import softuni.com.myApp.model.Entities.User;
import softuni.com.myApp.model.serviceModels.UserServiceModel;
import softuni.com.myApp.repository.UserRepository;
import softuni.com.myApp.security.CurrentUser;
import softuni.com.myApp.service.RoleService;
import softuni.com.myApp.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final RoleService roleService;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser, RoleService roleService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.roleService = roleService;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setRole(this.roleService.findRole(RoleEnum.USER));

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId());
        currentUser.setUsername(userServiceModel.getUsername());
        currentUser.setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        this.currentUser.setId(null);
        this.currentUser.setRole(null);
        this.currentUser.setUsername(null);
    }

    @Override
    public List<String> getAllUsernames() {
        return this.userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleEnum roleEnum) {
        User user = this.userRepository.findByUsername(username).orElse(null);

        if (user.getRole().getName() != roleEnum) {
            user.setRole(roleService.findRole(roleEnum));

            userRepository.save(user);
        }
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
