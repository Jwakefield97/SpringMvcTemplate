package springtemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springtemplate.dao.service.UserService;


@Controller
public class HomeController {
	
	@Autowired 
	UserService userService;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mav) {
		mav.setViewName("home");
		mav.addObject("page","home");
		return mav;
	}

}
