package com.ksk.fund.wts.dao;

import com.ksk.fund.wts.dto.AccountVO;

public interface AccountDAO {
	public void insertAccount(AccountVO account) throws Exception;
	public AccountVO getAccountByAcctNo(String acct_no) throws Exception;
	public int getAccountCountByAcctNo(String acct_no) throws Exception;
	public void UpdateLockQty(AccountVO account) throws Exception;
	public void UpdateAccountRemn(AccountVO account) throws Exception;
	public void updateAccountBuyLock(AccountVO account) throws Exception;
}
