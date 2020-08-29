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
       var reg_amt = document.getElementById("reg_amt");
       var passwd = document.getElementById("passwd");
       
       if(acct_no.value.length < 11) {
           alert("계좌번호는 반드시 11자리로 입력해야 합니다.");
           acct_no.focus();
           return false;
       }  
       
       var numPattern = /([^0-9])/;
       var numPattern1 = acct_no.value.match(numPattern);
       var numPattern2 = reg_amt.value.match(numPattern);
       
       if(numPattern1 != null){
           alert("계좌번호는 숫자로만 입력해 주세요!");
           acct_no.value = "";
           acct_no.focus();
           return false;
       }
       
       if(numPattern2 != null){
           alert("금액은 숫자로만 입력해 주세요!");
           reg_amt.value = "";
           reg_amt.focus();
           return false;
       }
       
       if(isNull(reg_amt.value)){
    	   reg_amt.value = "0"; 
       }
       
       if(isNull(passwd.value)){
    	   alert("비밀번호를 입력해 주세요!");
    	   reg_amt.value = "0";
    	   reg_amt.focus();
    	   return false;
       }
   }
</script>
<script type="text/javascript"> 
function acctCheck(){
	$.ajax({
		url : "/acctNoCheck2",
		type : "post",
		dataType : "json",
		data : {"acct_no" : $("#acct_no").val()},
		success : function(data){
			if(data == 1) {
				alert("계좌번호가 확인되었습니다");
				$("#submit").removeAttr("disabled");
			} else if(data == 2) {
				alert("입력하신 계좌번호는 없는 계좌번호 입니다");
				$("#submit").attr("disabled", "disabled");
			} 
		}
	})
}

function keyUpEvent() {
	$("#submit").attr("disabled", "disabled");
}

</script>
<script>
	<c:if test="${msg ne null}">
		alert("${msg}");
	</c:if>
</script>
</head>
<body>
	<h3 style="margin: 5px 0px;">환매신청</h3>
	<form action='<c:url value="/repurchaseFund"/>' onsubmit="return validate();" method="post">
		<table border="1">
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>계좌번호</strong></td>
				<td><input type="text" name="acct_no" id="acct_no"
					maxlength="11" onkeyup="keyUpEvent();" />
					<button type="button" id="acctCheckBtn" onclick="acctCheck();">계좌확인</button>
				</td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>비밀번호</strong></td>
				<td><input type="password" name="passwd" id="passwd" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>환매구분</strong></td>
				<td>
					<select name="redem_gb">
						<option value= "11" >전액환매</option>
						<option value= "12" >좌수환매</option>
						<option value= "13" >정액환매</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>환매신청금액(좌수)</strong></td>
				<td>
					<input type="text" name="req_amt" id="req_amt" value=0
						onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="신청" id="submit"disabled="disabled"/><input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>