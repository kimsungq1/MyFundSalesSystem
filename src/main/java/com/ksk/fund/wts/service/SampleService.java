package com.ksk.fund.wts.service;

import com.ksk.fund.wts.dto.AccountVO;
import com.ksk.fund.wts.dto.ClientVO;

public interface SampleService {
	public void insertClient(ClientVO client) throws Exception;
	public void deposit(String cust_no, double remn_capi) throws Exception;
	public int withdraw(String cust_no, String passwd, int withdraw_qty) throws Exception;
	public int acctCheck(String acct_no) throws Exception;
	public int acctCheck2(String acct_no) throws Exception;
	public int insertAccount(AccountVO account, int check, int reg_amt) throws Exception;
	public int purchaseFund(String acct_no, int check, int reg_amt, int deposit_capi) throws Exception;
	public int repurchaseFund(String acct_no, String passwd, String redem_gb, int reg_amt) throws Exception;
	public int selectTarget() throws Exception;
	public int batchPurchase() throws Exception;
	public int selectTarget2() throws Exception;
	public int batchRepurchase() throws Exception;
}
