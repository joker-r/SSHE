package com.viva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" cg_sshe_flowwise_details")
public class cp_sshe_flowwise_details {
	@Id
	@Column(name="opcoid",columnDefinition="int(3)")
	private int opcoid;
	@Column(name="cpid",length=100)
	private String cpid;
	@Column(name="REQUEST_ENCRYPTION_CP_LIST",columnDefinition="varchar(100) default 'woEhrhDdEqAZmrrNFYoOmA=='")
	private String REQUEST_ENCRYPTION_CP_LIST;
	@Column(name="LAST_MODIFY_DATE",columnDefinition="TIMESTAMP")
	private String LAST_MODIFY_DATE;
	public int getOpcoid() {
		return opcoid;
	}
	public void setOpcoid(int opcoid) {
		this.opcoid = opcoid;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getREQUEST_ENCRYPTION_CP_LIST() {
		return REQUEST_ENCRYPTION_CP_LIST;
	}
	public void setREQUEST_ENCRYPTION_CP_LIST(String rEQUEST_ENCRYPTION_CP_LIST) {
		REQUEST_ENCRYPTION_CP_LIST = rEQUEST_ENCRYPTION_CP_LIST;
	}
	public String getLAST_MODIFY_DATE() {
		return LAST_MODIFY_DATE;
	}
	public void setLAST_MODIFY_DATE(String lAST_MODIFY_DATE) {
		LAST_MODIFY_DATE = lAST_MODIFY_DATE;
	}
	

}
