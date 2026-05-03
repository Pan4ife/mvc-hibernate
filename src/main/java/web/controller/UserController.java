package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(ModelMap modelMap) {
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(ModelMap modelMap) {
        User newUser = new User();
        modelMap.addAttribute("user", newUser);
        return "new-user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-user";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editedUser(@PathVariable("id") Long id, ModelMap modelMap) {
        User editUser = userService.getById(id);
        modelMap.addAttribute("user", editUser);
        return "edit-user";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        user.setId(id);
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}