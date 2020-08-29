package com.ksk.fund.common.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ksk.fund.common.dto.ExcelVO;

@Repository("ExcelDAO")
public class ExcelDAOImpl extends AbstractDAO implements ExcelDAO {
	
	@Override
	public void uploadExcel(List<ExcelVO> list) throws Exception {
		insert("excel.insertExcel", list);
	}

}
