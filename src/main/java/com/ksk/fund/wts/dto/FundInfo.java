package com.ksk.fund.wts.dto;

public class FundInfo {
	String today;
	String fund_cd;
	int stdprc;
	int stdprc_estm_unit;
	double fee_rt;
	String acct_no;
	
	public String getAcct_no() {
		return acct_no;
	}

	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}

	public FundInfo() {
		
	}
	
	public FundInfo(String today, String fund_cd) {
		super();
		this.today = today;
		this.fund_cd = fund_cd;
	}
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getFund_cd() {
		return fund_cd;
	}
	public void setFund_cd(String fund_cd) {
		this.fund_cd = fund_cd;
	}
	public int getStdprc() {
		return stdprc;
	}
	public void setStdprc(int stdprc) {
		this.stdprc = stdprc;
	}
	public int getStdprc_estm_unit() {
		return stdprc_estm_unit;
	}
	public void setStdprc_estm_unit(int stdprc_estm_unit) {
		this.stdprc_estm_unit = stdprc_estm_unit;
	}
	public double getFee_rt() {
		return fee_rt;
	}
	public void setFee_rt(double fee_rt) {
		this.fee_rt = fee_rt;
	}
}
