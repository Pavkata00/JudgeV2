package softuni.com.myApp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.com.myApp.service.RoleService;

@Component
public class DBinit implements CommandLineRunner {

    private final RoleService roleService;

    public DBinit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.roleService.initRoles();
    }
}
