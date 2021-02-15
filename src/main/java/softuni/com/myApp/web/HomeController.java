package softuni.com.myApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.com.myApp.security.CurrentUser;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    private String index() {
        return currentUser.isAnonymous() ? "index" : "home";
    }
}
