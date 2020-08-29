package com.ksk.fund.wts.dto;

public class AccountVO {
	private String acct_no;
	private String cust_no;
	private String fund_cd;
	private double remn_qty;
	private double remn_capi;
	private double buy_lock_qty;
	private double redem_lock_qty;
	private String first_buy_dt;
	private String work_datetime;
	
	public AccountVO() {

	}
	
	public AccountVO(String acct_no, String cust_no, String fund_cd, double remn_qty, double remn_capi) {
		super();
		this.acct_no = acct_no;
		this.cust_no = cust_no;
		this.fund_cd = fund_cd;
		this.remn_qty = remn_qty;
		this.remn_capi = remn_capi;
	}

	public String getAcct_no() {
		return acct_no;
	}

	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getFund_cd() {
		return fund_cd;
	}

	public void setFund_cd(String fund_cd) {
		this.fund_cd = fund_cd;
	}

	public double getRemn_qty() {
		return remn_qty;
	}

	public void setRemn_qty(double remn_qty) {
		this.remn_qty = remn_qty;
	}

	public double getRemn_capi() {
		return remn_capi;
	}

	public void setRemn_capi(double remn_capi) {
		this.remn_capi = remn_capi;
	}

	public String getFirst_buy_dt() {
		return first_buy_dt;
	}

	public void setFirst_buy_dt(String first_buy_dt) {
		this.first_buy_dt = first_buy_dt;
	}

	public String getWork_datetime() {
		return work_datetime;
	}

	public void setWork_datetime(String work_datetime) {
		this.work_datetime = work_datetime;
	}

	public double getBuy_lock_qty() {
		return buy_lock_qty;
	}

	public void setBuy_lock_qty(double buy_lock_qty) {
		this.buy_lock_qty = buy_lock_qty;
	}

	public double getRedem_lock_qty() {
		return redem_lock_qty;
	}

	public void setRedem_lock_qty(double redem_lock_qty) {
		this.redem_lock_qty = redem_lock_qty;
	}
	
}

