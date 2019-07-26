package com.viva.dao;

import java.util.List;

import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
import com.viva.entity.cg_sshe_vas_master;

public interface cg_sshe_product_dao {
	public int addProduct(cg_sshe_product_master product);
	public int addUrl(cg_sshe_notify_url_master notify_url);
	public int editProduct(cg_sshe_product_master product);
	public List<cg_sshe_product_master> getProduct(cg_sshe_vas_master cp);
	public List<cg_sshe_product_master> getProductById(String product_id);
}
