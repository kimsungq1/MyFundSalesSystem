package com.ksk.fund.wts.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ksk.fund.common.controller.ExcelController;
import com.ksk.fund.common.util.AES256Util;
import com.ksk.fund.common.util.ShaEncoder;
import com.ksk.fund.wts.dto.AccountVO;
import com.ksk.fund.wts.dto.ClientVO;
import com.ksk.fund.wts.service.SampleService;

@Controller
public class SampleController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

	@Resource(name = "AES256Util")
	AES256Util aes;

	@Resource(name = "shaEncoder")
	private ShaEncoder encoder;

	@Resource(name = "SampleService")
	private SampleService sampleService;

	@RequestMapping("/indexPage")
	public String indexPage() {
		return "indexPage.page";
	}

	@RequestMapping("/insertClientPage")
	public String insertClientPage() {
		return "insertClientPage.page";
	}

	@RequestMapping("/depositPage")
	public String depositPage() {
		return "depositPage.page";
	}

	@RequestMapping("/withdrawPage")
	public String withdrawPage() {
		return "withdrawPage.page";
	}

	@RequestMapping("/insertAccountPage")
	public String insertAccountPage() {
		return "insertAccountPage.page";
	}

	@RequestMapping("/purchaseFundPage")
	public String purchaseFundPage() {
		return "purchaseFundPage.page";
	}

	@RequestMapping("/repurchaseFundPage")
	public String repurchaseFundPage() {
		return "repurchaseFundPage.page";
	}
	
	@RequestMapping("/batchPurchasePage")
	public String batchPurchasePage() {
		return "batchPurchasePage.page";
	}
	
	@RequestMapping("/batchRepurchasePage")
	public String batchRepurchasePage() {
		return "batchRepurchasePage.page";
	}

	@RequestMapping(value = "/insertClient", method = RequestMethod.POST)
	public ModelAndView insertUser(@RequestParam("cust_no") String cust_no, @RequestParam("cust_nm") String cust_nm,
			@RequestParam("rname_no_kind") String rname_no_kind, @RequestParam("rname_no") String rname_no,
			@RequestParam("passwd") String passwd, @RequestParam("home_addr") String home_addr,
			@RequestParam("cp_telno") String cp_telno, @RequestParam("email_addr") String email_addr,
			@RequestParam("level_cd") int level_cd) throws Exception {

		ModelAndView mav = new ModelAndView("indexPage.page");

		String rname_no_sha = encoder.encoding(rname_no);
		String passwd_sha = encoder.encoding(passwd);

		String home_addr_aes = aes.encrypt(home_addr);
		String cp_telno_aes = aes.encrypt(cp_telno);
		String email_addr_aes = aes.encrypt(email_addr);

		ClientVO client = new ClientVO(cust_no, cust_nm, rname_no_kind, rname_no_sha, passwd_sha, home_addr_aes,
				cp_telno_aes, email_addr_aes, level_cd);

		sampleService.insertClient(client);

		// String email_addr_decode = aes.decrypt(email_addr_aes);
		// logger.info(email_addr_aes);
		// logger.info(email_addr_decode);

		mav.addObject("msg", "고객정보 추가 완료");

		return mav;
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView deposit(@RequestParam("cust_no") String cust_no, @RequestParam("deposit_qty") int deposit_qty)
			throws Exception {

		ModelAndView mav = new ModelAndView("indexPage.page");

		sampleService.deposit(cust_no, deposit_qty);

		mav.addObject("msg", "입금 완료");

		return mav;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public ModelAndView wtihdraw(@RequestParam("cust_no") String cust_no, @RequestParam("passwd") String passwd,
			@RequestParam("withdraw_qty") int withdraw_qty) throws Exception {

		ModelAndView mav = new ModelAndView("indexPage.page");

		int result = sampleService.withdraw(cust_no, passwd, withdraw_qty);

		if (result == 1) {
			mav.setViewName("withdrawPage.page");
			mav.addObject("msg", "[비밀번호 오류] 출금 실패");
		} else if (result == 2) {
			mav.setViewName("withdrawPage.page");
			mav.addObject("msg", "[잔고 부족] 출금 실패");
		} else {
			mav.addObject("msg", "출금 완료");
		}

		return mav;
	}

	@RequestMapping(value = "/insertAccount", method = RequestMethod.POST)
	public ModelAndView insertAccount(@RequestParam("acct_no") String acct_no, @RequestParam("fund_cd") String fund_cd,
			@RequestParam("check") int check, @RequestParam(value = "deposit_capi", defaultValue="0") double deposit_capi,
			@RequestParam("reg_amt") int reg_amt) throws Exception {

		ModelAndView mav = new ModelAndView("indexPage.page");

		String cust_no = acct_no.substring(0, 8);
		AccountVO account = new AccountVO(acct_no, cust_no, fund_cd, 0, deposit_capi);
		int result = sampleService.insertAccount(account, check, reg_amt);

		if (result == 1) {
			mav.addObject("msg", "펀드계좌 개설완료");
		} else if (result == 2) {
			mav.setViewName("insertAccountPage.page");
			mav.addObject("msg", "예수금계좌 잔고부족으로 개설실패 ");
		}

		return mav;
	}

	@RequestMapping(value = "/purchaseFund", method = RequestMethod.POST)
	public ModelAndView purchaseFund(@RequestParam("acct_no") String acct_no, @RequestParam("reg_amt") int reg_amt,
			@RequestParam("check") int check, @RequestParam("deposit_capi") int deposit_capi) throws Exception {

		ModelAndView mav = new ModelAndView("indexPage.page");

		int result = sampleService.purchaseFund(acct_no, check, reg_amt, deposit_capi);

		if (result == 1) {
			mav.addObject("msg", "매입신청 완료");
		} else if (result == 2) {
			mav.setViewName("purchaseFundPage.page");
			mav.addObject("msg", "예수금계좌 잔고부족으로 매입실패 ");
		}

		return mav;
	}

	@RequestMapping(value = "/repurchaseFund", method = RequestMethod.POST)
	public ModelAndView purchaseFund(@RequestParam("acct_no") String acct_no, @RequestParam("req_amt") int req_amt,
			@RequestParam("passwd") String passwd, @RequestParam("redem_gb") String redem_gb) throws Exception {

		ModelAndView mav = new ModelAndView("indexPage.page");

		int result = sampleService.repurchaseFund(acct_no, passwd, redem_gb, req_amt);

		if (result == 1) {
			mav.addObject("msg", "환매신청 완료");
		}

		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/batchPurchase", method = RequestMethod.POST)
	public String batchPurchase() throws Exception {

		String result = Integer.toString(sampleService.batchPurchase());
		
		System.out.println(result);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/batchRepurchase", method = RequestMethod.POST)
	public int batchRepurchase() throws Exception {

		int result = sampleService.batchRepurchase();

		return result;
	}

	// 회원 확인
	@ResponseBody
	@RequestMapping(value = "/acctNoCheck", method = RequestMethod.POST)
	public int acctCheck(HttpServletRequest req) throws Exception {
		String acct_no = req.getParameter("acct_no");

		int result = sampleService.acctCheck(acct_no);

		return result;
	}

	// 회원 확인
	@ResponseBody
	@RequestMapping(value = "/acctNoCheck2", method = RequestMethod.POST)
	public int acctCheck2(HttpServletRequest req) throws Exception {
		String acct_no = req.getParameter("acct_no");

		int result = sampleService.acctCheck2(acct_no);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/selectTarget", method = RequestMethod.POST)
	public int selectTarget() throws Exception {

		int result = sampleService.selectTarget();

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectTarget2", method = RequestMethod.POST)
	public int selectTarget2() throws Exception {

		int result = sampleService.selectTarget2();

		return result;
	}
}