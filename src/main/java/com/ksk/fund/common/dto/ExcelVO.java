package com.ksk.fund.common.dto;

public class ExcelVO {
	String fund_cd;
    String std_dt;
	long stdprc;
	long stdass_stdprc;
	String work_datetime;
    
    public ExcelVO() {
        
    }

	public ExcelVO(String fund_cd, String std_dt, long stdprc, long stdass_stdprc, String work_datetime) {
		super();
		this.fund_cd = fund_cd;
		this.std_dt = std_dt;
		this.stdprc = stdprc;
		this.stdass_stdprc = stdass_stdprc;
		this.work_datetime = work_datetime;
	}

	public String getFund_cd() {
		return fund_cd;
	}

	public void setFund_cd(String fund_cd) {
		this.fund_cd = fund_cd;
	}

	public String getStd_dt() {
		return std_dt;
	}

	public void setStd_dt(String std_dt) {
		this.std_dt = std_dt;
	}

	public long getStdprc() {
		return stdprc;
	}

	public void setStdprc(long stdprc) {
		this.stdprc = stdprc;
	}

	public long getStdass_stdprc() {
		return stdass_stdprc;
	}

	public void setStdass_stdprc(long stdass_stdprc) {
		this.stdass_stdprc = stdass_stdprc;
	}

	public String getWork_datetime() {
		return work_datetime;
	}

	public void setWork_datetime(String work_datetime) {
		this.work_datetime = work_datetime;
	}
    
}

