package com.viva.dao;

import java.util.List;


import com.viva.entity.cg_sshe_user;

public interface cg_sshe_user_dao {

	public int addUser(cg_sshe_user user);
	public cg_sshe_user getUser(String username);
	public int editUser(cg_sshe_user user);
	public List<cg_sshe_user> getUser();
	public int getUserType(String username);
	
}
