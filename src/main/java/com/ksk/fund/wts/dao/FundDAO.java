package com.ksk.fund.wts.dao;

import java.util.List;

import com.ksk.fund.wts.dto.FundInfo;
import com.ksk.fund.wts.dto.PDS2032;
import com.ksk.fund.wts.dto.PDS2033;
import com.ksk.fund.wts.dto.PDS2034;
import com.ksk.fund.wts.dto.PDS3190;

public interface FundDAO {
	public int getFundPriceByFundCd(String fund_cd) throws Exception;
	public int getMatchNdaysByFundCd(String fund_cd) throws Exception;
	public void insertPDS2033(PDS2033 pds2033) throws Exception;
	public int getRedemNdaysByFundCd(String fund_cd) throws Exception;
	public void insertPDS2034(PDS2034 pds2034) throws Exception;
	public int getTargetCount(String today) throws Exception;
	public List<PDS2033> getTarget(String today) throws Exception;
	public int getStdPrc(FundInfo fundInfo) throws Exception;
	public double getFeeRt(String fund_cd) throws Exception;
	public int getStdPrcEstm(String fund_cd) throws Exception;
	public void updatePDS2033(PDS2033 pds2033) throws Exception;
	public int getStdAssStdPrc(FundInfo fundInfo) throws Exception;
	public void insertPDS2032(PDS2032 pds2032) throws Exception;
	public int getCpltYnCount(String today) throws Exception;
	public int getTargetCount2(String today_date) throws Exception;
	public List<PDS2034> getTarget2(String today) throws Exception;
	public int getStdAssStdPrc2032(FundInfo fundInfo) throws Exception;
	public void updatePDS2034(PDS2034 pds2034) throws Exception;
	public void insertPDS3190(PDS3190 pds3190) throws Exception;
	public int getCpltYnCount2(String today) throws Exception;
}
