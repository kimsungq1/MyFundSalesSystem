package com.ksk.fund.wts.dto;

public class PDS3190 {
	private String ACCT_NO;
	private String TRD_DT; 
	private String TRD_NO;
	private String Fund_CD;
	private double TOT_SUPPLY_AMT; 
	private double REDEM_QTY;
	private double REDEM_AMT; 
	private double TRD_TOT_STDASS;
	private double TRD_TOT_INC_TAX;
	private double TRD_TOT_RESI_TAX;
	private char CANC_YN; //0
	private String WORK_DATETIME; //매입 시간
	
	public PDS3190(String aCCT_NO, String tRD_DT, String tRD_NO, String fund_CD, double tOT_SUPPLY_AMT,
			double rEDEM_QTY, double rEDEM_AMT, double tRD_TOT_STDASS, double tRD_TOT_INC_TAX, double tRD_TOT_RESI_TAX,
			char cANC_YN, String wORK_DATETIME) {
		super();
		ACCT_NO = aCCT_NO;
		TRD_DT = tRD_DT;
		TRD_NO = tRD_NO;
		Fund_CD = fund_CD;
		TOT_SUPPLY_AMT = tOT_SUPPLY_AMT;
		REDEM_QTY = rEDEM_QTY;
		REDEM_AMT = rEDEM_AMT;
		TRD_TOT_STDASS = tRD_TOT_STDASS;
		TRD_TOT_INC_TAX = tRD_TOT_INC_TAX;
		TRD_TOT_RESI_TAX = tRD_TOT_RESI_TAX;
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
	public double getTOT_SUPPLY_AMT() {
		return TOT_SUPPLY_AMT;
	}
	public void setTOT_SUPPLY_AMT(double tOT_SUPPLY_AMT) {
		TOT_SUPPLY_AMT = tOT_SUPPLY_AMT;
	}
	public double getREDEM_QTY() {
		return REDEM_QTY;
	}
	public void setREDEM_QTY(double rEDEM_QTY) {
		REDEM_QTY = rEDEM_QTY;
	}
	public double getREDEM_AMT() {
		return REDEM_AMT;
	}
	public void setREDEM_AMT(double rEDEM_AMT) {
		REDEM_AMT = rEDEM_AMT;
	}
	public double getTRD_TOT_STDASS() {
		return TRD_TOT_STDASS;
	}
	public void setTRD_TOT_STDASS(double tRD_TOT_STDASS) {
		TRD_TOT_STDASS = tRD_TOT_STDASS;
	}
	public double getTRD_TOT_INC_TAX() {
		return TRD_TOT_INC_TAX;
	}
	public void setTRD_TOT_INC_TAX(double tRD_TOT_INC_TAX) {
		TRD_TOT_INC_TAX = tRD_TOT_INC_TAX;
	}
	public double getTRD_TOT_RESI_TAX() {
		return TRD_TOT_RESI_TAX;
	}
	public void setTRD_TOT_RESI_TAX(double tRD_TOT_RESI_TAX) {
		TRD_TOT_RESI_TAX = tRD_TOT_RESI_TAX;
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
