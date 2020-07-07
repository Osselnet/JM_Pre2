package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/")
public class UserController extends HttpServlet {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

	@GetMapping("/admin")
	public String usersGet(ModelMap model) {
		model.addAttribute("users", userService.getAllUser());
		return "admin";
	}

	@GetMapping("/user")
	public String userGet(User user, ModelMap model) {
		model.addAttribute("user", userService.getUserById(user.getId()));
		return "user";
	}

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userService.addUser(user);
		//model.addAttribute("users", userService.getAllUser());
		return "redirect:/admin";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, User user,
							 BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userService.updateUser(user);
		model.addAttribute("users", userService.getAllUser());
		return "admin";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		userService.deleteUser(id);
		model.addAttribute("users", userService.getAllUser());
		return "admin";
	}
}