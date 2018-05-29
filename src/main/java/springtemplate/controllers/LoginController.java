package springtemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springtemplate.dao.dao.UserDao;
import springtemplate.dao.domain.User;


@Controller
public class LoginController {
	
	@Autowired 
	UserDao userDao;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/login/attempt", method = RequestMethod.POST)
	public ModelAndView loginAttempt(@RequestParam String username, @RequestParam String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = userDao.getByUsername(username);
		if(user != null && user.getUsername().equals(username) && passwordEncoder.matches(password,user.getPassword())) { //user is successfully authenticated
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value = "/register/attempt", method = RequestMethod.POST)
	public ModelAndView registerAttempt(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String email ){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = new User(name, email, username, passwordEncoder.encode(password));
		if(userDao.getByUsername(user.getUsername()) == null) { //make sure username is not taken
			userDao.save(user);
			return new ModelAndView("redirect:/login");
		}
		
		return new ModelAndView("redirect:/register");
	}
	

}
