package com.ksk.fund.common.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ksk.fund.common.dto.ExcelVO;
import com.ksk.fund.common.service.ExcelService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ExcelController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);
	
	@Resource(name = "ExcelService")
	private ExcelService service;
	
	@RequestMapping("/excelUpload")
    public String excelUpload() {
        return "excelUpload.page";
    }
	
	@RequestMapping("/insertClient")
    public String insertClient() {
        return "insertClient.page";
    }
	
    @RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST)
    public String uploadExcelFile(MultipartHttpServletRequest request, Model model) throws Exception{
        MultipartFile file = null;
        Iterator<String> iterator = request.getFileNames();
        if(iterator.hasNext()) {
            file = request.getFile(iterator.next());
        }
        List<ExcelVO> list = service.uploadExcelFile(file);
        
        model.addAttribute("list", list);
        return "jsonView";
    }
}
