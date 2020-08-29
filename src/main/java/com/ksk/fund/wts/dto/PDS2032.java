package com.ksk.fund.wts.dto;

public class PDS2032 {
	private String ACCT_NO;
	private String TRD_DT; 
	private String TRD_NO;
	private String Fund_CD;
	private String BUY_GB; 
	private double BUY_AMT; 
	private double BUY_QTY; 
	private double REMN_CAPI; 
	private double REMN_QTY; 
	private double SALE_FEE;
	private double BUY_STDPRC;
	private double BUY_STDASS_STDPRC;
	private char CANC_YN; //0
	private String WORK_DATETIME; //매입 시간
	
	public PDS2032(String aCCT_NO, String tRD_DT, String tRD_NO, String fund_CD, String bUY_GB, double bUY_AMT,
			double bUY_QTY, double rEMN_CAPI, double rEMN_QTY, double sALE_FEE, double bUY_STDPRC,
			double bUY_STDASS_STDPRC, char cANC_YN, String wORK_DATETIME) {
		super();
		ACCT_NO = aCCT_NO;
		TRD_DT = tRD_DT;
		TRD_NO = tRD_NO;
		Fund_CD = fund_CD;
		BUY_GB = bUY_GB;
		BUY_AMT = bUY_AMT;
		BUY_QTY = bUY_QTY;
		REMN_CAPI = rEMN_CAPI;
		REMN_QTY = rEMN_QTY;
		SALE_FEE = sALE_FEE;
		BUY_STDPRC = bUY_STDPRC;
		BUY_STDASS_STDPRC = bUY_STDASS_STDPRC;
		CANC_YN = cANC_YN;
		WORK_DATETIME = wORK_DATETIME;
	}
	
	public String getACCT_NO() {
		return ACCT_NO;
	}
	public void setACCT_NO(String aCCT_NO) {
		ACCT_NO = aCCT_NO;
	}
	public String getTRD_DT() {
		return TRD_DT;
	}
	public void setTRD_DT(String tRD_DT) {
		TRD_DT = tRD_DT;
	}
	public String getTRD_NO() {
		return TRD_NO;
	}
	public void setTRD_NO(String tRD_NO) {
		TRD_NO = tRD_NO;
	}
	public String getFund_CD() {
		return Fund_CD;
	}
	public void setFund_CD(String fund_CD) {
		Fund_CD = fund_CD;
	}
	public String getBUY_GB() {
		return BUY_GB;
	}
	public void setBUY_GB(String bUY_GB) {
		BUY_GB = bUY_GB;
	}
	public double getBUY_AMT() {
		return BUY_AMT;
	}
	public void setBUY_AMT(double bUY_AMT) {
		BUY_AMT = bUY_AMT;
	}
	public double getBUY_QTY() {
		return BUY_QTY;
	}
	public void setBUY_QTY(double bUY_QTY) {
		BUY_QTY = bUY_QTY;
	}
	public double getREMN_CAPI() {
		return REMN_CAPI;
	}
	public void setREMN_CAPI(double rEMN_CAPI) {
		REMN_CAPI = rEMN_CAPI;
	}
	public double getREMN_QTY() {
		return REMN_QTY;
	}
	public void setREMN_QTY(double rEMN_QTY) {
		REMN_QTY = rEMN_QTY;
	}
	public double getSALE_FEE() {
		return SALE_FEE;
	}
	public void setSALE_FEE(double sALE_FEE) {
		SALE_FEE = sALE_FEE;
	}
	public double getBUY_STDPRC() {
		return BUY_STDPRC;
	}
	public void setBUY_STDPRC(double bUY_STDPRC) {
		BUY_STDPRC = bUY_STDPRC;
	}
	public double getBUY_STDASS_STDPRC() {
		return BUY_STDASS_STDPRC;
	}
	public void setBUY_STDASS_STDPRC(double bUY_STDASS_STDPRC) {
		BUY_STDASS_STDPRC = bUY_STDASS_STDPRC;
	}
	public char getCANC_YN() {
		return CANC_YN;
	}
	public void setCANC_YN(char cANC_YN) {
		CANC_YN = cANC_YN;
	}
	public String getWORK_DATETIME() {
		return WORK_DATETIME;
	}
	public void setWORK_DATETIME(String wORK_DATETIME) {
		WORK_DATETIME = wORK_DATETIME;
	}
	
	
}
