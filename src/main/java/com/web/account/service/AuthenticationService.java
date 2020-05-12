package com.web.account.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.web.account.dao.AuthenticationDao;
import com.web.account.entity.Login;
import com.web.account.utils.AES;

@Component
public class AuthenticationService {

	private static final String EXCLUDE_URI="/demo/swagger";
	@Autowired
	private AuthenticationDao authenticationDao;
	@Value("${SECRET}")
	private String secret;
	@Autowired
	private AES aes;
	
	public boolean authenticate(String authCredentials,HttpServletRequest httpServletRequest) {

		if(httpServletRequest.getRequestURI().startsWith(EXCLUDE_URI))
		{
			return true;
		}
		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
        Login login1=new Login();
		Optional<Login> login=authenticationDao.findById(username);
		if(login.isPresent())
		{
			login1=login.get();
		}
		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		boolean authenticationStatus = "A".equals(login1.getRole())
				&& password.equals(getPassword(login1.getPassword()));
		return authenticationStatus;
	}

      
	private String getPassword(String password) {
		return aes.decrypt(password, secret);
		}
}