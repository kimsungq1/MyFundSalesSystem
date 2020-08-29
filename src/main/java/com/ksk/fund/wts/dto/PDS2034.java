package com.ksk.fund.wts.dto;

public class PDS2034 {
	private String ACCT_NO;
	private String TRD_DT;
	private String FUND_CD;
	private String REDEM_GB;
	private String SETL_PLAN_DT;
	private String TRD_NO;
	private double REQ_AMT; 
	private double REQ_QTY;
	private double SETL_AMT;
	private double SETL_QTY; 
	private String SETL_DT;
	private char SETL_CPLT_YN;
	private String SETL_ERR_CD;
	private char CANC_YN;
	private String WORK_DATETIME;
	
	public PDS2034() {
		
	}
	
	public PDS2034(String aCCT_NO, String tRD_DT, String fUND_CD, String rEDEM_GB, String sETL_PLAN_DT, double rEQ_AMT,
			double rEQ_QTY, double sETL_AMT, double sETL_QTY, String sETL_DT, char sETL_CPLT_YN, String sETL_ERR_CD,
			char cANC_YN, String wORK_DATETIME) {
		super();
		this.ACCT_NO = aCCT_NO;
		this.TRD_DT = tRD_DT;
		this.FUND_CD = fUND_CD;
		this.REDEM_GB = rEDEM_GB;
		this.SETL_PLAN_DT = sETL_PLAN_DT;
		this.REQ_AMT = rEQ_AMT;
		this.REQ_QTY = rEQ_QTY;
		this.SETL_AMT = sETL_AMT;
		this.SETL_QTY = sETL_QTY;
		this.SETL_DT = sETL_DT;
		this.SETL_CPLT_YN = sETL_CPLT_YN;
		this.SETL_ERR_CD = sETL_ERR_CD;
		this.CANC_YN = cANC_YN;
		this.WORK_DATETIME = wORK_DATETIME;
	}

	
	
	public String getTRD_NO() {
		return TRD_NO;
	}

	public void setTRD_NO(String tRD_NO) {
		TRD_NO = tRD_NO;
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

	public String getFUND_CD() {
		return FUND_CD;
	}

	public void setFUND_CD(String fUND_CD) {
		FUND_CD = fUND_CD;
	}

	public String getREDEM_GB() {
		return REDEM_GB;
	}

	public void setREDEM_GB(String rEDEM_GB) {
		REDEM_GB = rEDEM_GB;
	}

	public String getSETL_PLAN_DT() {
		return SETL_PLAN_DT;
	}

	public void setSETL_PLAN_DT(String sETL_PLAN_DT) {
		SETL_PLAN_DT = sETL_PLAN_DT;
	}

	public double getREQ_AMT() {
		return REQ_AMT;
	}

	public void setREQ_AMT(double rEQ_AMT) {
		REQ_AMT = rEQ_AMT;
	}

	public double getREQ_QTY() {
		return REQ_QTY;
	}

	public void setREQ_QTY(double rEQ_QTY) {
		REQ_QTY = rEQ_QTY;
	}

	public double getSETL_AMT() {
		return SETL_AMT;
	}

	public void setSETL_AMT(double tot_supply_amt) {
		SETL_AMT = tot_supply_amt;
	}

	public double getSETL_QTY() {
		return SETL_QTY;
	}

	public void setSETL_QTY(double sETL_QTY) {
		SETL_QTY = sETL_QTY;
	}

	public String getSETL_DT() {
		return SETL_DT;
	}

	public void setSETL_DT(String sETL_DT) {
		SETL_DT = sETL_DT;
	}

	public char getSETL_CPLT_YN() {
		return SETL_CPLT_YN;
	}

	public void setSETL_CPLT_YN(char sETL_CPLT_YN) {
		SETL_CPLT_YN = sETL_CPLT_YN;
	}

	public String getSETL_ERR_CD() {
		return SETL_ERR_CD;
	}

	public void setSETL_ERR_CD(String sETL_ERR_CD) {
		SETL_ERR_CD = sETL_ERR_CD;
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
