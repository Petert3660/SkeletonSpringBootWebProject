package com.ptconsultancy.home;

import com.ptconsultancy.users.UserRepository;
import com.ptconsultancy.utilities.UserDetailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private UserRepository userRepository;

    private UserDetailUtils userDetailUtils;

    @Autowired
    public HomeController(UserRepository userRepository,
        UserDetailUtils userDetailUtils) {
        this.userRepository = userRepository;
        this. userDetailUtils = userDetailUtils;
    }

    @GetMapping(value = "/home")
    public String tags(Model model) {

        if (!userRepository.findByUserName(userDetailUtils.getUserName()).get(0).isLoggedIn()) {
            return "redirect:changepassword";
        }

        model.addAttribute("userIsAdmin", userDetailUtils.isAdminUser());
        model.addAttribute("userName", userDetailUtils.getUserName());

        return "home";
    }

    @PostMapping(value = "/home")
    public void closeDown() {
        System.exit(0);
    }
}
