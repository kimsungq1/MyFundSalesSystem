package com.ksk.fund.wts.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.fund.common.util.ShaEncoder;
import com.ksk.fund.wts.dao.AccountDAO;
import com.ksk.fund.wts.dao.ClientDAO;
import com.ksk.fund.wts.dao.FundDAO;
import com.ksk.fund.wts.dto.AccountVO;
import com.ksk.fund.wts.dto.ClientVO;
import com.ksk.fund.wts.dto.FundInfo;
import com.ksk.fund.wts.dto.PDS2032;
import com.ksk.fund.wts.dto.PDS2033;
import com.ksk.fund.wts.dto.PDS2034;
import com.ksk.fund.wts.dto.PDS3190;

@Service("SampleService")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private ClientDAO clientDao;
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private FundDAO fundDao;
	@Resource(name = "shaEncoder")
	private ShaEncoder encoder;

	@Override
	public void insertClient(ClientVO client) throws Exception {
		String acct_no = client.getCust_no() + "000";

		// System.out.println(client.getCust_no());
		// System.out.println(acct_no);

		AccountVO account = new AccountVO(acct_no, client.getCust_no(), "000", 0, 0);

		accountDao.insertAccount(account);
		clientDao.insertClient(client);
	}

	@Override
	public void deposit(String cust_no, double remn_capi) throws Exception {
		String acct_no = cust_no + "000";
		// 1. ��ȸ
		AccountVO account = accountDao.getAccountByAcctNo(acct_no);
		// 2. �ݾ� �߰� ��
		double new_qty = account.getRemn_qty() + remn_capi;
		account.setRemn_qty(new_qty);
		account.setRemn_capi(new_qty);
		account.setFirst_buy_dt("");
		// 3. �ش� �ݾ����� ������Ʈ
		accountDao.UpdateAccountRemn(account);
	}

	@Override
	public int withdraw(String cust_no, String passwd, int withdraw_qty) throws Exception {
		String acct_no = cust_no + "000";

		AccountVO account = accountDao.getAccountByAcctNo(acct_no);
		ClientVO client = clientDao.getClientByCustNo(cust_no);
		String passwd_sha = encoder.encoding(passwd);

		if (!passwd_sha.equals(client.getUSER_PASSWORD())) {
			return 1;
		}
		if (account.getRemn_qty() - withdraw_qty < 0) {
			return 2;
		}

		double new_qty = account.getRemn_qty() - withdraw_qty;
		account.setRemn_qty(new_qty);
		account.setRemn_capi(new_qty);
		account.setFirst_buy_dt("");
		accountDao.UpdateAccountRemn(account);
		return 3;
	}

	@Override
	public int acctCheck(String acct_no) throws Exception {
		String cust_no = acct_no.substring(0, 8);

		int account = accountDao.getAccountCountByAcctNo(acct_no);
		int client = clientDao.getClientCountByCustNo(cust_no);

		if (client == 0) {
			return 1;
		}
		if (account != 0) {
			return 2;
		}

		return 3;
	}

	@Override
	public int acctCheck2(String acct_no) throws Exception {

		int account = accountDao.getAccountCountByAcctNo(acct_no);

		if (account != 0) {
			return 1;
		}

		return 2;
	}

	@Override
	public int insertAccount(AccountVO account, int check, int req_amt) throws Exception {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String trd_dt = date.format(today);
		String work_datetime = time.format(today);
		int nDay = fundDao.getMatchNdaysByFundCd(account.getFund_cd());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, nDay);
		if(c.get(Calendar.DAY_OF_WEEK) == 7) //plan_dt�� ����� �� ��� 2�� �߰�(=������)
			c.add(Calendar.DATE, 2);
		if(c.get(Calendar.DAY_OF_WEEK) == 7) //plan_dt�� �Ͽ��� �� ��� 1�� �߰�(=������)
			c.add(Calendar.DATE, 1);
		String plan_dt = date.format(c.getTime());

		String cust_no = account.getCust_no();

		double remn_capi = account.getRemn_capi();
		account.setRemn_capi(0);
		account.setRemn_qty(0);

		if (check == 1) {
			// ������ ���� �ܰ�� ��.
			// all or nothing -> �̸� Ȯ���ؼ� �Ա� �Ŀ��� �ܰ������ ��쿡 ���ʿ� �Ա��� ���ϰ�.
			AccountVO account000 = accountDao.getAccountByAcctNo((cust_no + "000"));
			if (account000.getRemn_capi() + remn_capi < req_amt) {
				return 2; // �����ݰ��� �ܰ�������� ����.
			}
			
			// ������ ���¿� �߰�(������ �����ݰ��¿� �߰�)
			deposit(cust_no, remn_capi);
			
			account000.setBuy_lock_qty(req_amt);
			accountDao.UpdateLockQty(account000);
			
			// �ݵ���� ����
			accountDao.insertAccount(account);
			
			// ��û ���� 2033�� insert
			PDS2033 pds2033 = new PDS2033(account.getAcct_no(), trd_dt, account.getFund_cd(), req_amt, 0, 0, plan_dt,
					"0", 'N', "0", 'N', work_datetime);

			fundDao.insertPDS2033(pds2033);

		} else if (check == 2) { // ������
			// ������ ���� �ܰ�� ��.
			AccountVO account000 = accountDao.getAccountByAcctNo((cust_no + "000"));
			if (account000.getRemn_capi() < req_amt) {
				return 2; // �����ݰ��� �ܰ�������� ����.
			}
			// �ݵ���� ����
			accountDao.insertAccount(account);
			
			account000.setBuy_lock_qty(req_amt);
			accountDao.UpdateLockQty(account000);

			// ��û ���� 2033�� insert
			PDS2033 pds2033 = new PDS2033(account.getAcct_no(), trd_dt, account.getFund_cd(), req_amt, 0, 0, plan_dt,
					"0", 'N', "0", 'N', work_datetime);

			fundDao.insertPDS2033(pds2033);
		}

		return 1; // ���������� �ݵ���� �����Ϸ�.
	}

	@Override
	public int purchaseFund(String acct_no, int check, int req_amt, int deposit_capi) throws Exception {
		String cust_no = acct_no.substring(0, 8);// ����ȣ
		AccountVO account = accountDao.getAccountByAcctNo(acct_no);// �ݵ����
		String fund_cd = account.getFund_cd();// �ݵ��ڵ�

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String trd_dt = date.format(today);
		String work_datetime = time.format(today);
		int nDay = fundDao.getMatchNdaysByFundCd(fund_cd);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, nDay);	
		if(c.get(Calendar.DAY_OF_WEEK) == 7) //plan_dt�� ����� �� ��� 2�� �߰�(=������)
			c.add(Calendar.DATE, 2);	
		if(c.get(Calendar.DAY_OF_WEEK) == 7) //plan_dt�� �Ͽ��� �� ��� 1�� �߰�(=������)
			c.add(Calendar.DATE, 1);	
		String plan_dt = date.format(c.getTime());
		
		if (check == 1) { // ���� �Ա�
			// ������ ���� �ܰ�� ��.
			// all or nothing -> �̸� Ȯ���ؼ� �Ա� �Ŀ��� �ܰ������ ��쿡 ���ʿ� �Ա��� ���ϰ�.
			AccountVO account000 = accountDao.getAccountByAcctNo((cust_no + "000"));
			if (account000.getRemn_capi() + deposit_capi < req_amt) {
				return 2; // �����ݰ��� �ܰ�������� ���� ����.
			}
			
			account000.setBuy_lock_qty(req_amt);
			accountDao.UpdateLockQty(account000);
			
			// ������ ���¿� �߰�.(������ �����ݰ��¿� �߰�)
			deposit(cust_no, deposit_capi);
			
			// ��û ���� 2033�� insert
			PDS2033 pds2033 = new PDS2033(acct_no, trd_dt, fund_cd, req_amt, 0, 0, plan_dt, "0", 'N', "0", 'N',
					work_datetime);

			fundDao.insertPDS2033(pds2033);
		} else if (check == 2) { // �����ݰ��� �ܰ�� ����
			// ������ ���� �ܰ�� ��.
			AccountVO account000 = accountDao.getAccountByAcctNo((cust_no + "000"));
			if (account000.getRemn_capi() < req_amt) {
				return 2; // �����ݰ��� �ܰ�������� ���� ����.
			}
			double new_lock_qty = account000.getBuy_lock_qty() + req_amt;
			account000.setBuy_lock_qty(new_lock_qty);
			accountDao.UpdateLockQty(account000);
			
			// ��û ���� 2033�� insert
			PDS2033 pds2033 = new PDS2033(acct_no, trd_dt, fund_cd, req_amt, 0, 0, plan_dt, "0", 'N', "0", 'N',
					work_datetime);

			fundDao.insertPDS2033(pds2033);
		}

		return 1; // ���������� ���ԿϷ�.
	}

	@Override
	public int repurchaseFund(String acct_no, String passwd, String redem_gb, int req_amt) throws Exception {
		AccountVO account = accountDao.getAccountByAcctNo(acct_no);// �ݵ����
		String fund_cd = account.getFund_cd();// �ݵ��ڵ�

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String trd_dt = date.format(today);
		String work_datetime = time.format(today);
		int nDay = fundDao.getRedemNdaysByFundCd(fund_cd);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, nDay);	
		if(c.get(Calendar.DAY_OF_WEEK) == 7) //plan_dt�� ����� �� ��� 2�� �߰�(=������)
			c.add(Calendar.DATE, 2);	
		if(c.get(Calendar.DAY_OF_WEEK) == 7) //plan_dt�� �Ͽ��� �� ��� 1�� �߰�(=������)
			c.add(Calendar.DATE, 1);	
		String plan_dt = date.format(c.getTime());
		
		AccountVO account000 = accountDao.getAccountByAcctNo((acct_no.substring(0,8) + "000"));
		account000.setRedem_lock_qty(req_amt);
		accountDao.UpdateLockQty(account000);
		
		if (redem_gb.equals("11")) { // ����ȯ��			
			PDS2034 pds2034 = new PDS2034(acct_no, trd_dt, fund_cd, redem_gb, plan_dt, 0, 0, 0, 0, "0", 'N', "0", 'N',
					work_datetime);

			fundDao.insertPDS2034(pds2034);
		} else if (redem_gb.equals("12")) { // �¼�ȯ��
			PDS2034 pds2034 = new PDS2034(acct_no, trd_dt, fund_cd, redem_gb, plan_dt, 0, req_amt, 0, 0, "0", 'N', "0",
					'N', work_datetime);

			fundDao.insertPDS2034(pds2034);
		} else if (redem_gb.equals("13")) { // ����ȯ��
			PDS2034 pds2034 = new PDS2034(acct_no, trd_dt, fund_cd, redem_gb, plan_dt, req_amt, 0, 0, 0, "0", 'N', "0",
					'N', work_datetime);

			fundDao.insertPDS2034(pds2034);
		}

		return 1; // ���������� ȯ�ſϷ�.
	}

	@Override
	public int selectTarget() throws Exception {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		String today_date = date.format(today);
		
		int result = fundDao.getTargetCount(today_date);
		
		return result;
	}
	
	@Override
	public int selectTarget2() throws Exception {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		String today_date = date.format(today);
		
		int result = fundDao.getTargetCount2(today_date);
		
		return result;
	}

	@Override
	public int batchPurchase() throws Exception {
		Date day = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String today = date.format(day);
		String work_datetime = time.format(day);
		
		List<PDS2033> list = fundDao.getTarget(today);
		
		int result = 0;
		
		//����Ʈ ��� ����
		for(PDS2033 pds2033 : list) {
			//2033 ������Ʈ
			//�ݵ� �ڵ� ������, ������, �ݵ�������ذ�, ���ذ� DB���� ��������(1300)
			String fund_cd = pds2033.getFUND_CD();
			//���� ��¥�� �ݵ��ڵ�� ���ذ� �ҷ�����
			FundInfo fundInfo = new FundInfo(today, fund_cd);
			String acct_no = pds2033.getACCT_NO();
			int stdprc = fundDao.getStdPrc(fundInfo);
			int stdass_stdprc = fundDao.getStdAssStdPrc(fundInfo);
			//�ݵ� �ڵ�� ���ذ��������� �� ������ �ҷ�����
			int stdprc_estm = fundDao.getStdPrcEstm(fund_cd);
			double fee_rt = fundDao.getFeeRt(fund_cd);
			//���
			double sale_fee = pds2033.getREQ_AMT() * (fee_rt/100);
			double setl_amt = pds2033.getREQ_AMT() - sale_fee;
			double setl_qty = setl_amt / stdprc * stdprc_estm;
			pds2033.setSETL_AMT(setl_amt);
			pds2033.setSETL_QTY(setl_qty);
			pds2033.setSETL_DT(today);
			pds2033.setSETL_CPLT_YN('Y');
			
			//������Ʈ
			fundDao.updatePDS2033(pds2033);
			
			System.out.println(pds2033.getTRD_NO());
			
			//2032 �Է�
			PDS2032 pds2032 = new PDS2032(acct_no, today, pds2033.getTRD_NO(), fund_cd, "19",
					setl_amt, setl_qty, setl_amt, setl_qty, sale_fee, stdprc, stdass_stdprc, '0', work_datetime);
			
			fundDao.insertPDS2032(pds2032);
			//2030 ������Ʈ -> ���� ������Ʈ SQL �ϳ� ���� �Ѵ� ���� �Լ��� ó��
			//���Աݾ׸�ŭ �ݵ���� remn_capi + setlamt remnqty + setlqty, firstbuydt�� ���� ��¥ �Է�(ù ���� �Ͻ�)
			//���Աݾ� ��ŭ �����ݰ��¼�(remn_qty,capi)���� ���̳ʽ�, buy_lock_qty -> 0���� ������Ʈ
			AccountVO account = accountDao.getAccountByAcctNo(acct_no);
			double newCapi = account.getRemn_capi() + setl_amt;
			account.setRemn_capi(newCapi);
			double newQty = account.getRemn_qty() + setl_qty;
			account.setRemn_qty(newQty);
			account.setFirst_buy_dt(today);
			accountDao.UpdateAccountRemn(account);
			
			String acct_no_000 = acct_no.substring(0,8) + "000";
			AccountVO account000 = accountDao.getAccountByAcctNo(acct_no_000);
			double newCapi_000 = account000.getRemn_capi() - setl_amt;
			double new_buy_lock_qty = account000.getBuy_lock_qty() - setl_amt;
			account000.setRemn_capi(newCapi_000);
			account000.setRemn_qty(newCapi_000);
			account000.setBuy_lock_qty(new_buy_lock_qty);
			accountDao.UpdateAccountRemn(account000);
			accountDao.updateAccountBuyLock(account000);
			
			result++;
		}
	
		return result;
	}
	
	@Override
	public int batchRepurchase() throws Exception {
		Date day = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String today = date.format(day);
		String work_datetime = time.format(day);
		
		List<PDS2034> list = fundDao.getTarget2(today);

		int result = 0;
		
		//����Ʈ ��� ����
		for(PDS2034 pds2034 : list) {
			String redem_gb = pds2034.getREDEM_GB();
			if(!redem_gb.equals("12"))
				continue;
			//2034 ������Ʈ
			//�ݵ� �ڵ� ������, ������, �ݵ�������ذ�, ���ذ� DB���� ��������(1300)
			String fund_cd = pds2034.getFUND_CD();
			//���� ��¥�� �ݵ��ڵ�� ���ذ� �ҷ�����
			FundInfo fundInfo = new FundInfo(today, fund_cd);
			String acct_no = pds2034.getACCT_NO();
			fundInfo.setAcct_no(acct_no);
			int stdprc = fundDao.getStdPrc(fundInfo);
			int stdass_stdprc = fundDao.getStdAssStdPrc(fundInfo);
			int stdass_stdprc_bf = fundDao.getStdAssStdPrc2032(fundInfo);
			//�ݵ� �ڵ�� ���ذ��������� �� ������ �ҷ�����
			int stdprc_estm = fundDao.getStdPrcEstm(fund_cd);
			double redem_qty = pds2034.getREQ_QTY(); //K1
			double redem_amt = stdprc * redem_qty / stdprc_estm; //T1
			double inc_tax_rt = 14;
			double resi_tax_rt = 1.4; 
			double std_tax = (stdass_stdprc - stdass_stdprc_bf) * redem_qty / stdprc_estm; //J1
			double inc_tax = std_tax * inc_tax_rt; //Y1
			double resi_tax = std_tax * resi_tax_rt; //Y2
			double tot_supply_amt = redem_amt - (inc_tax + resi_tax); //T3
			
			pds2034.setSETL_CPLT_YN('Y');
			pds2034.setSETL_AMT(tot_supply_amt);
			pds2034.setSETL_QTY(redem_qty);
			pds2034.setSETL_DT(today);
			
			//������Ʈ
			fundDao.updatePDS2034(pds2034);
			
			//3190 �Է� -> 3190 dto �����, db insert ���� dao, sql �ۼ�
			PDS3190 pds3190 = new PDS3190(acct_no, today, pds2034.getTRD_NO(), fund_cd, tot_supply_amt, redem_qty, redem_amt, std_tax, inc_tax, resi_tax, 'N', work_datetime);
			
			fundDao.insertPDS3190(pds3190);
			
			//2030 ������Ʈ -> ���� ������Ʈ SQL �ϳ� ���� �Ѵ� ���� �Լ��� ó��
			//���Աݾ׸�ŭ �ݵ���� remn_capi + setlamt remnqty + setlqty, firstbuydt�� ���� ��¥ �Է�(ù ���� �Ͻ�)
			//���Աݾ� ��ŭ �����ݰ��¼�(remn_qty,capi)���� ���̳ʽ�, buy_lock_qty -> 0���� ������Ʈ
			AccountVO account = accountDao.getAccountByAcctNo(acct_no);
			double newCapi = account.getRemn_capi() - redem_amt;
			account.setRemn_capi(newCapi);
			double newQty = account.getRemn_qty() - redem_qty;
			account.setRemn_qty(newQty);
			accountDao.UpdateAccountRemn(account);
			
			String acct_no_000 = acct_no.substring(0,8) + "000";
			AccountVO account000 = accountDao.getAccountByAcctNo(acct_no_000);
			double newCapi_000 = account000.getRemn_capi() + tot_supply_amt;
			double new_redem_lock_qty = account000.getRedem_lock_qty() - redem_qty;
			account000.setRemn_capi(newCapi_000);
			account000.setRemn_qty(newCapi_000);
			account000.setRedem_lock_qty(new_redem_lock_qty);
			accountDao.UpdateAccountRemn(account000);
			accountDao.UpdateLockQty(account000);
			
			result++;
		}

		return result;
	}
	
}
