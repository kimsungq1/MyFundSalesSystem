package com.ksk.fund.common.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksk.fund.common.dao.UserDaoImpl;
import com.ksk.fund.common.dto.UserVO;
import com.ksk.fund.common.util.ShaEncoder;

@Controller
public class UserController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "shaEncoder")
	private ShaEncoder encoder;

	@Resource(name = "UserDAO")
	private UserDaoImpl dao;
	
	@RequestMapping("/user/loginPage")
	public String loginPage() {
		return "/user/loginPage";
	}
	
	@RequestMapping("/")
	public String loginPage2() {
		return "/user/loginPage";
	}
	
	@RequestMapping("/user/joinPage")
	public String joinPage() {
		return "/user/joinPage";
	}

	@RequestMapping(value = "/user/join", method = RequestMethod.POST)
	public String insertUser(@RequestParam("id") String id, @RequestParam("passwd") String passwd, 
			@RequestParam("name") String name, @RequestParam("authority") String authority) throws Exception {
		String sha256_pw = encoder.encoding(passwd);
		UserVO user = new UserVO(id, name, sha256_pw, 1, authority);
		dao.insertUser(user);
		return "/user/loginPage";
	}
}
