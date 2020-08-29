package com.ksk.fund.wts.dao;

import org.springframework.stereotype.Repository;

import com.ksk.fund.common.dao.AbstractDAO;
import com.ksk.fund.wts.dto.ClientVO;

@Repository("ClientDAO")
public class ClientDAOImpl extends AbstractDAO  implements ClientDAO{
	
	@Override
	public void insertClient(ClientVO client) throws Exception {
		insert("client.insertClient", client);
	}
	
	@Override
	public ClientVO getClientByCustNo(String cust_no) throws Exception {
		return (ClientVO)selectOne("client.selectClient", cust_no);
	}
	
	@Override
	public int getClientCountByCustNo(String cust_no) throws Exception {
		return (int)selectOne("client.selectClientCount", cust_no);
	}
}
