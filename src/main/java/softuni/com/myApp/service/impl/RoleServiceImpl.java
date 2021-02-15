package softuni.com.myApp.service.impl;

import org.springframework.stereotype.Service;
import softuni.com.myApp.model.Entities.Role;
import softuni.com.myApp.model.Entities.RoleEnum;
import softuni.com.myApp.repository.RoleRepository;
import softuni.com.myApp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository repository) {
        this.roleRepository = repository;
    }

    @Override
    public void initRoles() {
        if (this.roleRepository.count() == 0) {
            Role roleAdmin = new Role();
            roleAdmin.setName(RoleEnum.ADMIN);

            Role roleUser = new Role();
            roleUser.setName(RoleEnum.USER);

            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
        }
    }

    @Override
    public Role findRole(RoleEnum roleEnum) {
        return this.roleRepository.findByName(roleEnum).orElse(null);
    }
}
