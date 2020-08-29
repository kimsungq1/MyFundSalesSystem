<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>InsertAccount Page</title>
<script language="javascript">
	function isNull(elm) {
		//Null 체크 함수
		var elm;
		return (elm == null || elm == "" || elm == "undefined" || elm == " ") ? true : false
	}

	function validate() {
		var acct_no = document.getElementById("acct_no");
		var fund_cd = document.getElementById("fund_cd");
		var deposit_capi = document.getElementById("deposit_capi");
		var reg_amt = document.getElementById("reg_amt");
		
		if (acct_no.value.length < 11) {
			alert("계좌번호는 반드시 11자리로 설정해야 합니다.");
			acct_no.focus();
			return false;
		}

		if (fund_cd.value.length < 6) {
			alert("펀드코드는 반드시 6자리로 입력해야 합니다.");
			fund_cd.focus();
			return false;
		}

		var numPattern = /([^0-9])/;
		var numPattern1 = acct_no.value.match(numPattern);
		var numPattern2 = deposit_capi.value.match(numPattern);
		var numPattern3 = reg_amt.value.match(numPattern);

		if (numPattern1 != null) {
			alert("계좌번호는 숫자로만 입력해 주세요!");
			acct_no.value = "";
			acct_no.focus();
			return false;
		}

		if (numPattern3 != null) {
			alert("금액은 숫자로만 입력해 주세요!");
			reg_amt.value = "";
			reg_amt.focus();
			return false;
		}

		if (numPattern2 != null) {
			alert("금액은 숫자로만 입력해 주세요!");
			deposit_capi.value = "";
			deposit_capi.focus();
			return false;
		}

		if (isNull(deposit_capi.value)) {
			deposit_capi.value = "0";
		}
	}
</script>
<script type="text/javascript">
	function acctCheck() {
		$.ajax({
			url : "/acctNoCheck",
			type : "post",
			dataType : "json",
			data : {
				"acct_no" : $("#acct_no").val()
			},
			success : function(data) {
				if (data == 1) {
					alert("입력하신 고객번호는 없는 고객번호 입니다");
					$("#submit").attr("disabled", "disabled");
				} else if (data == 2) {
					alert("중복된 계좌번호 입니다");
					$("#submit").attr("disabled", "disabled");
				} else if (data == 3) {
					alert("사용할 수 있는 계좌번호 입니다.");
					$("#submit").removeAttr("disabled");
				}
			}
		})
	}

	function keyUpEvent() {
		$("#submit").attr("disabled", "disabled");
	}
	
	$(document).ready(function(){
		 
	    // 라디오버튼 클릭시 이벤트 발생
	    $("input:radio[name=check]").click(function(){
	 
	        if($("input[name=check]:checked").val() == "1"){
	        	$("#deposit_capi").removeAttr("disabled");
	            // radio 버튼의 value 값이 1이라면 활성화
	 
	        }else if($("input[name=check]:checked").val() == "2"){
	        	$("#deposit_capi").attr("disabled", "disabled");
	            // radio 버튼의 value 값이 2이라면 비활성화
	        }
	    });
	});

</script>
<script>
	<c:if test="${msg ne null}">
	alert("${msg}");
	</c:if>
</script>
</head>
<body>
	<h3 style="margin: 5px 0px;">펀드계좌 개설</h3>
	<form action='<c:url value="/insertAccount"/>'
		onsubmit="return validate();" method="post">
		<table border="1">
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>계좌번호</strong></td>
				<td><input type="text" name="acct_no" id="acct_no"
					maxlength="11" onkeyup="keyUpEvent();" />
					<button type="button" id="acctCheckBtn" onclick="acctCheck();">중복확인</button>
				</td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>펀드코드</strong></td>
				<td><input type="text" name="fund_cd" id="fund_cd"
					maxlength="6" /></td>
			</tr>
			<tr>
				<td colspan='2'>매입신청사항</td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>매수예수금</strong></td>
				<td><input type="radio" name="check" value=1 checked="checked">현금입금
					<input type="radio" name="check" value=2>예수금계좌</td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>매수신청액</strong></td>
				<td><input type="text" name="reg_amt" id="reg_amt"
					onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" />
				</td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>현금입금액</strong></td>
				<td><input type="text" name="deposit_capi" id="deposit_capi"
						onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="생성" id="submit"
					disabled="disabled"> <input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>