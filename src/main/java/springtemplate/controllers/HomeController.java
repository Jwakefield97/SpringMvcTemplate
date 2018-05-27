package springtemplate.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springtemplate.dao.dao.UserDao;


@Controller
public class HomeController {
	
	@Autowired 
	UserDao userDao;
	
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mav) throws SQLException, ClassNotFoundException {
		mav.setViewName("home");
		mav.addObject("users",userDao.getAll());
		return mav;
	}

}
