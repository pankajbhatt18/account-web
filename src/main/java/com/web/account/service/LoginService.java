package com.web.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.account.dao.LoginDao;
import com.web.account.entity.Login;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public Login save(Login login)
	{
		return loginDao.save(login);
	}

	public Login updateLogin(Login acct) {
	return loginDao.save(acct);
	}

	public List<Login> getAllLogin() {
	return loginDao.findAll();	
	}

	public Login getLogin(String loginName) {
		return loginDao.getOne(loginName);
	}

	public List<Login> saveAll(List<Login> acctList) {
		return loginDao.saveAll(acctList);
	}

	public String deleteLogin(String loginName) {
		 loginDao.deleteById(loginName);
		return "Deleted Successfully"+loginName;
	}
	
	
	
	
	
}
