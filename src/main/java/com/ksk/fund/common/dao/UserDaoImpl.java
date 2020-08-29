package com.ksk.fund.common.dao;

import org.springframework.stereotype.Repository;

import com.ksk.fund.common.dto.UserVO;

@Repository("UserDAO")
public class UserDaoImpl extends AbstractDAO  implements UserDao{
	
	@Override
	public void insertUser(UserVO user) throws Exception {
		insert("user.insertUser", user);
	}
}
