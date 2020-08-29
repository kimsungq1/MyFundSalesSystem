package com.ksk.fund.common.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksk.fund.common.dao.ExcelDAO;
import com.ksk.fund.common.dto.ExcelVO;


@Service("ExcelService")
public class ExcelServiceImpl implements ExcelService {

	@Resource(name = "ExcelDAO")
	private ExcelDAO excelDao;

	/**
	 * 업로드한 엑셀파일을 과일 리스트로 만들기
	 * 
	 * @param excelFile
	 * @return 생성한 과일 리스트
	 */
	@SuppressWarnings("resource")
	@Override
	public List<ExcelVO> uploadExcelFile(MultipartFile excelFile) throws Exception {
		List<ExcelVO> list = new ArrayList<ExcelVO>();
		try {
			OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
			XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

			// 첫번째 시트 불러오기
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				ExcelVO ExcelVO = new ExcelVO();
				XSSFRow row = sheet.getRow(i);

				// 행이 존재하기 않으면 패스
				if (row == null) {
					continue;
				}

				// 행의 두번째 열(펀드코드)
				XSSFCell cell = row.getCell(1);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					ExcelVO.setFund_cd(cell.getStringCellValue());
				}
				// 행의 세번째 열(기준일자)
				cell = row.getCell(2);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					ExcelVO.setStd_dt(cell.getStringCellValue());
				}
				//행의 네번째 열(기준가)
				cell = row.getCell(3);
				if (cell != null)
					ExcelVO.setStdprc((long)cell.getNumericCellValue());
				//행의 다섯번째 열(과표기준가)
				cell = row.getCell(4);
				if (cell != null)
					ExcelVO.setStdass_stdprc((long)cell.getNumericCellValue());
				//행의 여섯번째 열(작업일시)
				cell = row.getCell(5);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					ExcelVO.setWork_datetime(cell.getStringCellValue());
				}
				list.add(ExcelVO);
			}
			
			excelDao.uploadExcel(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
