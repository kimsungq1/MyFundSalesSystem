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
           alert("����ȣ�� �ݵ�� 8�ڸ��� �����ؾ� �մϴ�.");
           cust_no.focus();
           return false;
       }
       
       var numPattern = /([^0-9])/;
       var numPattern = cust_no.value.match(numPattern);
       
       if(numPattern != null){
           alert("���ڸ� �Է��� �ּ���!");
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
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>����ȣ</strong></td>
				<td><input type="text" name="cust_no" id="cust_no" maxlength="8"/></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>����</strong></td>
				<td><input type="text" name="cust_nm" id="cust_nm" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>�Ǹ��ȣ����</strong></td>
				<td>
					<select name="rname_no_kind">
						<option value="RC">�ֹε����</option>
						<option value="DR">����������</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>�Ǹ��ȣ</strong></td>
				<td><input type="text" name="rname_no" id="rname_no" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>��й�ȣ</strong></td>
				<td><input type="password" name="passwd" id="passwd" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>�����ּ�</strong></td>
				<td><input type="text" name="home_addr" id="home_addr" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>��ȭ��ȣ</strong></td>
				<td><input type="text" name="cp_telno" id="cp_telno" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>�̸����ּ�</strong></td>
				<td><input type="text" name="email_addr" id="email_addr" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>���ڵ��</strong></td>
				<td>
					<select name="level_cd">
						<option value= 1 >1���</option>
						<option value= 2 >2���</option>
						<option value= 3 >3���</option>
						<option value= 4 >4���</option>
						<option value= 5 >5���</option>
						<option value= 6 >6���</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="����"> <input
					type="reset" value="���"></td>
			</tr>
		</table>
	</form>
</body>
</html>

