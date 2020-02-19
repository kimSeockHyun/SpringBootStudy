package com.example.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Users;
import com.example.repository.UserRepository;
import com.example.util.UserPasswordHashUtil;

@Service
public class JoinService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String joinUser(String userId, String userPw, String userNm) throws Exception{
		
		
		if("".equals(userId) || "".equals(userPw) || "".equals(userNm) ) {
			return "join";
		}
		
		UserPasswordHashUtil hashUtil = new UserPasswordHashUtil();
		String hashPassWd = hashUtil.getSHA512(userPw);
		
		Users users = new Users();
		
		users.setUserId(userId);
		users.setUserPw(hashPassWd);
		users.setUserNm(userNm);
		
		userRepository.save(users);
		
		return "index";
		
	}
}
