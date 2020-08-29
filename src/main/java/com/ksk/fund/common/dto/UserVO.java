package com.ksk.fund.common.dto;

public class UserVO {
	private String emp_no;
	private String emp_nm;
	private String emp_state;
	private String password;
	private int password_err_cnt;
	private String work_datetime;
	private int enabled;
	private String authority;
	
	public UserVO() {

	}

	public UserVO(String emp_no, String emp_nm, String password, int enabled, String authority) {
		super();
		this.emp_no = emp_no;
		this.emp_nm = emp_nm;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}
	
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	
	public String getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(String emp_state) {
		this.emp_state = emp_state;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPassword_err_cnt() {
		return password_err_cnt;
	}
	public void setPassword_err_cnt(int password_err_cnt) {
		this.password_err_cnt = password_err_cnt;
	}
	
	public String getWork_datetime() {
		return work_datetime;
	}
	public void setWork_datetime(String work_datetime) {
		this.work_datetime = work_datetime;
	}
	
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
