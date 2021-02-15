package softuni.com.myApp.service;

import softuni.com.myApp.model.Entities.Role;
import softuni.com.myApp.model.Entities.RoleEnum;

public interface RoleService {
    void initRoles();

    Role findRole(RoleEnum roleEnum);
}
