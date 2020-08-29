package com.ksk.fund.wts.dto;

public class ClientVO {
	private String cust_no;
	private String cust_nm;
	private String rname_no_kind;
	private String rname_no;
	private String USER_PASSWORD;
	private String home_addr;
	private String cp_telno;
	private String email_addr;
	private int level_cd;
	
	public ClientVO() {

	}
	
	public ClientVO(String cust_no, String cust_nm, String rname_no_kind, String rname_no, String passwd,
			String home_addr, String cp_telno, String email_addr, int level_cd) {
		super();
		this.cust_no = cust_no;
		this.cust_nm = cust_nm;
		this.rname_no_kind = rname_no_kind;
		this.rname_no = rname_no;
		this.USER_PASSWORD = passwd;
		this.home_addr = home_addr;
		this.cp_telno = cp_telno;
		this.email_addr = email_addr;
		this.level_cd = level_cd;
	}
	
	public String getCust_no() {
		return cust_no;
	}
	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getCust_nm() {
		return cust_nm;
	}
	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}
	
	public String getRname_no_kind() {
		return rname_no_kind;
	}
	public void setRname_no_kind(String rname_no_kind) {
		this.rname_no_kind = rname_no_kind;
	}
	
	public String getRname_no() {
		return rname_no;
	}
	public void setRname_no(String rname_no) {
		this.rname_no = rname_no;
	}
	
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String passwd) {
		this.USER_PASSWORD = passwd;
	}

	public String getHome_addr() {
		return home_addr;
	}
	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}
		
	public String getCp_telno() {
		return cp_telno;
	}

	public void setCp_telno(String cp_telno) {
		this.cp_telno = cp_telno;
	}

	public String getEmail_addr() {
		return email_addr;
	}
	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}
	
	public int getLevel_cd() {
		return level_cd;
	}
	public void setLevel_cd(int level_cd) {
		this.level_cd = level_cd;
	}
}
