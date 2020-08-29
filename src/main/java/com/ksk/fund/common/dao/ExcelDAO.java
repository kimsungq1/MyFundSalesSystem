package com.ksk.fund.common.dao;

import java.util.List;

import com.ksk.fund.common.dto.ExcelVO;

public interface ExcelDAO {
	void uploadExcel(List<ExcelVO> list) throws Exception;
}
