package com.login.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.login.model.Login;

@Repository("loginRepository")
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Login createLogin(Login login) {
		
		jdbcTemplate.update("insert into login_page(id,name,Rollnum) values(?,?,?)",login.getId(),login.getName(),login.getRollnum());
		return null;
	}

}
