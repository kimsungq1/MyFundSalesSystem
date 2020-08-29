package com.ksk.fund.wts.dto;

public class PDS2033 {
	private String ACCT_NO;
	private String TRD_DT; //매입 날짜
	private String Fund_CD;
	private int REQ_AMT; //신청금액
	private double SETL_AMT; //0
	private double SETL_QTY; //0
	private String SETL_PLAN_DT; //PFM1300(펀드 정보) 읽어와야함.
	private String SETL_DT; //0
	private char SETL_CPLT_YN; //0
	private String SETL_ERR_CD; //0
	private char CANC_YN; //0
	private String WORK_DATETIME; //매입 시간
	private String TRD_NO;
	
	public PDS2033() {
		
	}

	public PDS2033(String aCCT_NO, String tRD_DT, String Fund_CD, int rEQ_AMT, double sETL_AMT, double sETL_QTY,
			String sETL_PLAN_DT, String sETL_DT, char sETL_CPLT_YN, String sETL_ERR_CD, char cANC_YN,
			String wORK_DATETIME) {
		super();
		this.ACCT_NO = aCCT_NO;
		this.TRD_DT = tRD_DT;
		this.Fund_CD = Fund_CD;
		this.REQ_AMT = rEQ_AMT;
		this.SETL_AMT = sETL_AMT;
		this.SETL_QTY = sETL_QTY;
		this.SETL_PLAN_DT = sETL_PLAN_DT;
		this.SETL_DT = sETL_DT;
		this.SETL_CPLT_YN = sETL_CPLT_YN;
		this.SETL_ERR_CD = sETL_ERR_CD;
		this.CANC_YN = cANC_YN;
		this.WORK_DATETIME = wORK_DATETIME;
	}



	public String getACCT_NO() {
		return ACCT_NO;
	}
	public void setACCT_NO(String aCCT_NO) {
		this.ACCT_NO = aCCT_NO;
	}
	public String getTRD_DT() {
		return TRD_DT;
	}
	
	public void setTRD_DT(String tRD_DT) {
		this.TRD_DT = tRD_DT;
	}
	public String getFUND_CD() {
		return Fund_CD;
	}
	
	public void setFUND_CD(String Fund_CD) {
		this.Fund_CD = Fund_CD;
	}
	public int getREQ_AMT() {
		return REQ_AMT;
	}
	
	public void setREQ_AMT(int rEQ_AMT) {
		this.REQ_AMT = rEQ_AMT;
	}
	public double getSETL_AMT() {
		return SETL_AMT;
	}
	
	public void setSETL_AMT(double sETL_AMT) {
		this.SETL_AMT = sETL_AMT;
	}
	
	public double getSETL_QTY() {
		return SETL_QTY;
	}
	public void setSETL_QTY(double sETL_QTY) {
		this.SETL_QTY = sETL_QTY;
	}
	
	public String getSETL_PLAN_DT() {
		return SETL_PLAN_DT;
	}
	public void setSETL_PLAN_DT(String sETL_PLAN_DT) {
		this.SETL_PLAN_DT = sETL_PLAN_DT;
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

	public String getTRD_NO() {
		return TRD_NO;
	}

	public void setTRD_NO(String tRD_NO) {
		TRD_NO = tRD_NO;
	}
}
