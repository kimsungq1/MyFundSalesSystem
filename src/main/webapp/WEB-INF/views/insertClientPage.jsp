<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert Client Page</title>
<script language="javascript">
   function validate() {
       var cust_no = document.getElementById("cust_no");

       if(cust_no.value.length < 8) {
           alert("고객번호는 반드시 8자리로 설정해야 합니다.");
           cust_no.focus();
           return false;
       }
       
       var numPattern = /([^0-9])/;
       var numPattern = cust_no.value.match(numPattern);
       
       if(numPattern != null){
           alert("숫자만 입력해 주세요!");
           cust_no.value = "";
           cust_no.focus();
           return false;
       }
       
       return true;
   }
</script>
</head>
<body>
	<h3 style="margin: 5px 0px;">Insert Client</h3>
	<form action='<c:url value="/insertClient"/>'  onsubmit="return validate();" method="post">
		<table border="1">
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>고객번호</strong></td>
				<td><input type="text" name="cust_no" id="cust_no" maxlength="8"/></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>고객명</strong></td>
				<td><input type="text" name="cust_nm" id="cust_nm" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>실명번호종류</strong></td>
				<td>
					<select name="rname_no_kind">
						<option value="RC">주민등록증</option>
						<option value="DR">운전면허증</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>실명번호</strong></td>
				<td><input type="text" name="rname_no" id="rname_no" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>비밀번호</strong></td>
				<td><input type="password" name="passwd" id="passwd" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>자택주소</strong></td>
				<td><input type="text" name="home_addr" id="home_addr" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>전화번호</strong></td>
				<td><input type="text" name="cp_telno" id="cp_telno" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>이메일주소</strong></td>
				<td><input type="text" name="email_addr" id="email_addr" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>투자등급</strong></td>
				<td>
					<select name="level_cd">
						<option value= 1 >1등급</option>
						<option value= 2 >2등급</option>
						<option value= 3 >3등급</option>
						<option value= 4 >4등급</option>
						<option value= 5 >5등급</option>
						<option value= 6 >6등급</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>

