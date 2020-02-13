package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.Login;
import com.login.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public Login createLogin(Login login) {
		return loginRepository.createLogin(login);
	}

}
