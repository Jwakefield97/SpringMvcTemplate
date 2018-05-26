package springtemplate.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springtemplate.dao.repository.UserRepository;
import springtemplate.dao.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
}
