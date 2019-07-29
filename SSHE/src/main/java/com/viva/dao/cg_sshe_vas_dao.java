package com.viva.dao;

import java.util.List;


import com.viva.entity.cg_sshe_vas_master;

public interface cg_sshe_vas_dao {
public int addCp(cg_sshe_vas_master cp);
public int editCp(cg_sshe_vas_master cp);
public List<cg_sshe_vas_master> getCpById(String cpid);
public cg_sshe_vas_master getCpBOpcoId(int opcoid);
public List<cg_sshe_vas_master> getCp();
public int cpValidation(String cpid,String password);
public int ipValidation(String cpid,String ip);



}
