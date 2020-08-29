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
	 * ���ε��� ���������� ���� ����Ʈ�� �����
	 * 
	 * @param excelFile
	 * @return ������ ���� ����Ʈ
	 */
	@SuppressWarnings("resource")
	@Override
	public List<ExcelVO> uploadExcelFile(MultipartFile excelFile) throws Exception {
		List<ExcelVO> list = new ArrayList<ExcelVO>();
		try {
			OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
			XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

			// ù��° ��Ʈ �ҷ�����
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				ExcelVO ExcelVO = new ExcelVO();
				XSSFRow row = sheet.getRow(i);

				// ���� �����ϱ� ������ �н�
				if (row == null) {
					continue;
				}

				// ���� �ι�° ��(�ݵ��ڵ�)
				XSSFCell cell = row.getCell(1);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					ExcelVO.setFund_cd(cell.getStringCellValue());
				}
				// ���� ����° ��(��������)
				cell = row.getCell(2);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					ExcelVO.setStd_dt(cell.getStringCellValue());
				}
				//���� �׹�° ��(���ذ�)
				cell = row.getCell(3);
				if (cell != null)
					ExcelVO.setStdprc((long)cell.getNumericCellValue());
				//���� �ټ���° ��(��ǥ���ذ�)
				cell = row.getCell(4);
				if (cell != null)
					ExcelVO.setStdass_stdprc((long)cell.getNumericCellValue());
				//���� ������° ��(�۾��Ͻ�)
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
