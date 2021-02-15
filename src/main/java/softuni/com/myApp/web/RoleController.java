package softuni.com.myApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softuni.com.myApp.model.Entities.RoleEnum;
import softuni.com.myApp.service.UserService;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("names", userService.getAllUsernames());
        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(@RequestParam String username,
                             @RequestParam String role) {

        userService.changeRole(username, RoleEnum.valueOf(role.toUpperCase()));

        return "redirect:/";
    }
}
