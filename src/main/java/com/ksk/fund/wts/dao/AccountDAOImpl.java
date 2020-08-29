package com.ksk.fund.wts.dao;

import org.springframework.stereotype.Repository;

import com.ksk.fund.common.dao.AbstractDAO;
import com.ksk.fund.wts.dto.AccountVO;

@Repository("AccountDAO")
public class AccountDAOImpl extends AbstractDAO  implements AccountDAO{

	@Override
	public void insertAccount(AccountVO account) throws Exception {
		insert("account.insertAccount", account);
	}
	
	@Override
	public AccountVO getAccountByAcctNo(String acct_no) throws Exception {
		return (AccountVO)selectOne("account.selectAccount", acct_no);
	}
	
	@Override
	public int getAccountCountByAcctNo(String acct_no) throws Exception {
		return (int)selectOne("account.selectAccountCount", acct_no);
	}
	
	@Override
	public void UpdateAccountRemn(AccountVO account) throws Exception {
		update("account.updateAccountRemn", account);
	}
	
	@Override
	public void updateAccountBuyLock(AccountVO account) throws Exception {
		update("account.updateAccountBuyLock", account);
	}
	
	@Override
	public void UpdateLockQty(AccountVO account) throws Exception {
		update("account.updateLockQty", account);
	}
	
}
