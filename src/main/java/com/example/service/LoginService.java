package com.example.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Users;
import com.example.repository.UserRepository;
import com.example.util.UserPasswordHashUtil;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	public String login(String userId, String userPwd) {
		
//		String rtnPage = "";
		
		if( "".equals(userId) || "".equals(userPwd) ) {
			return "login";
		}
		
		UserPasswordHashUtil hashUtil = new UserPasswordHashUtil();
		String hash512 = hashUtil.getSHA512(userPwd);
		
		Users userInfo  = userRepository.findByUserIdAndUserPw(userId, hash512);
		
		Optional<Users> optUser = Optional.ofNullable(userInfo);
		if(!optUser.isPresent()) {
			
			
			
			return "login";
		}
		
		/*
		 * Optional
		 * Optional 객체 생성
		 *  1. Optional.empty() : 빈 Optional 객체 생성한다
		 *     예) Optional<String> optStr = Optional.empty();
		 *     
		 *  2. Optional.of(value) : value값이 null이 아닌 경우에 사용한다
		 *     예1) String str = "test";
		 *          Optional<String> optStr1 = Optional.of(str);
		 *     예2) String nullStr = null;
		 *          Optional<String> optStr2 = Optional.of(nullStr); //NPE 발생
		 *          
		 *  3. Optional.ofNullable(value) : value값이 null인지 아닌지 확실하지 않은 경우에 사용한다
		 *     예) String str = "test";
		 *        Optional<String> optStr1 = Optional.ofNullable(str);
		
		
		Optional<Users> optUser = Optional.ofNullable(userInfo);
		
		optUser.map(Users :: getUser_id)
			   .filter(s -> s.equals("frank")).isPresent();
//		hashUtil.isMatch(userPwd, s2);
		 */
		
		session.setAttribute("loginUser", userInfo);
		
		return "index";
	}
}
