package com.ksk.fund.wts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ksk.fund.common.dao.AbstractDAO;
import com.ksk.fund.wts.dto.FundInfo;
import com.ksk.fund.wts.dto.PDS2032;
import com.ksk.fund.wts.dto.PDS2033;
import com.ksk.fund.wts.dto.PDS2034;
import com.ksk.fund.wts.dto.PDS3190;

@Repository("FundDAO")
public class FundDAOImpl extends AbstractDAO  implements FundDAO{
	@Override
	public int getFundPriceByFundCd(String fund_cd) throws Exception {
		return (int)selectOne("fund.selectFundPrice", fund_cd);
	}
	
	@Override
	public int getMatchNdaysByFundCd(String fund_cd) throws Exception {
		return (int)selectOne("fund.selectMatchNdays", fund_cd);
	}
	
	@Override
	public int getRedemNdaysByFundCd(String fund_cd) throws Exception {
		return (int)selectOne("fund.selectRedemNdays", fund_cd);
	}
	
	@Override
	public int getTargetCount(String today) throws Exception {
		return (int)selectOne("fund.selectTargetCount", today);
	}
	
	@Override
	public int getTargetCount2(String today) throws Exception {
		return (int)selectOne("fund.selectTargetCount2", today);
	}
	
	@Override
	public void insertPDS2033(PDS2033 pds2033) throws Exception {
		insert("fund.insertPDS2033", pds2033);
	}
	
	@Override
	public void insertPDS2034(PDS2034 pds2034) throws Exception {
		insert("fund.insertPDS2034", pds2034);
	}
	
	@Override
	public void insertPDS2032(PDS2032 pds2032) throws Exception {
		insert("fund.insertPDS2032", pds2032);
	}
	
	@Override
	public void insertPDS3190(PDS3190 pds3190) throws Exception {
		insert("fund.insertPDS3190", pds3190);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PDS2033> getTarget(String today) throws Exception {
		return selectList("fund.selectTarget", today);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PDS2034> getTarget2(String today) throws Exception {
		return selectList("fund.selectTarget2", today);
	}
	
	
	@Override
	public int getStdPrc(FundInfo fundInfo) throws Exception {
		return (int)selectOne("fund.selectStdPrc", fundInfo);
	}
	
	@Override
	public int getStdAssStdPrc(FundInfo fundInfo) throws Exception {
		return (int)selectOne("fund.selectStdAssStdPrc", fundInfo);
	}
	
	@Override
	public int getStdAssStdPrc2032(FundInfo fundInfo) throws Exception {
		return (int)selectOne("fund.selectStdAssStdPrc2032", fundInfo);
	}
	
	@Override
	public int getStdPrcEstm(String fund_cd) throws Exception {
		return (int)selectOne("fund.selectStdPrcEstm", fund_cd);
	}
	
	@Override
	public double getFeeRt(String fund_cd) throws Exception {
		return (double)selectOne("fund.selectFee", fund_cd);
	}
	
	@Override
	public void updatePDS2033(PDS2033 pds2033) throws Exception {
		update("fund.updatePDS2033", pds2033);
	}
	
	@Override
	public void updatePDS2034(PDS2034 pds2034) throws Exception {
		update("fund.updatePDS2034", pds2034);
	}
	
	@Override
	public int getCpltYnCount(String today) throws Exception {
		return (int)selectOne("fund.selectCPLTYN", today);
	}
	
	@Override
	public int getCpltYnCount2(String today) throws Exception {
		return (int)selectOne("fund.selectCPLTYN2", today);
	}
}
