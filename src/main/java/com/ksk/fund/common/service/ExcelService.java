package com.ksk.fund.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ksk.fund.common.dto.ExcelVO;

public interface ExcelService {
	List<ExcelVO> uploadExcelFile(MultipartFile file) throws Exception;
}
