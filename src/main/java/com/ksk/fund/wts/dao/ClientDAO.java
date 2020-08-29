package com.ksk.fund.wts.dao;

import com.ksk.fund.wts.dto.ClientVO;

public interface ClientDAO {
	void insertClient(ClientVO client) throws Exception;
	ClientVO getClientByCustNo(String cust_no) throws Exception;
	int getClientCountByCustNo(String cust_no) throws Exception;
}
