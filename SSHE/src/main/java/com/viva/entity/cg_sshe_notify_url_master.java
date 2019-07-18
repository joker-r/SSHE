package com.viva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cg_sshe_notify_url_master")
public class cg_sshe_notify_url_master {
	@Id
	@Column(name=" NOTIFY_ID",columnDefinition="int(4)")
	private int NOTIFY_ID;
	@Column(name="cpid", columnDefinition="int(4)")
	private int cpid;
	@Column(name="product_id",columnDefinition="int(4)")
	private int product_id;
	@Column(name="notify_url",length=500)
	private String notify_url;
	@Column(name="APPEND_QUEST_FLAG",columnDefinition="int(2)")
	private int APPEND_QUEST_FLAG;
	@Column(name="LAST_MODIFY_DATE",columnDefinition="TIMESTAMP")
	private String LAST_MODIFY_DATE;
	@Column(name="opcoid",columnDefinition="int(3)")
	private int opcoid;
	public int getNOTIFY_ID() {
		return NOTIFY_ID;
	}
	public void setNOTIFY_ID(int nOTIFY_ID) {
		NOTIFY_ID = nOTIFY_ID;
	}
	public int getCpid() {
		return cpid;
	}
	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public int getAPPEND_QUEST_FLAG() {
		return APPEND_QUEST_FLAG;
	}
	public void setAPPEND_QUEST_FLAG(int aPPEND_QUEST_FLAG) {
		APPEND_QUEST_FLAG = aPPEND_QUEST_FLAG;
	}
	public String getLAST_MODIFY_DATE() {
		return LAST_MODIFY_DATE;
	}
	public void setLAST_MODIFY_DATE(String lAST_MODIFY_DATE) {
		LAST_MODIFY_DATE = lAST_MODIFY_DATE;
	}
	public int getOpcoid() {
		return opcoid;
	}
	public void setOpcoid(int opcoid) {
		this.opcoid = opcoid;
	}
	

}
