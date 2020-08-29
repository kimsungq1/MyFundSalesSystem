<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Deposit Page</title>
<script language="javascript">
	function validate() {
		var cust_no = document.getElementById("cust_no");
		var deposit_qty = document.getElementById("deposit_qty");

		if (cust_no.value.length < 8) {
			alert("����ȣ�� �ݵ�� 8�ڸ��� �����ؾ� �մϴ�.");
			cust_no.focus();
			return false;
		}

		var numPattern = /([^0-9])/;
		var numPattern1 = cust_no.value.match(numPattern);
		var numPattern2 = deposit_qty.value.match(numPattern);

		if (numPattern1 != null) {
			alert("����ȣ�� ���ڷθ� �Է��� �ּ���!");
			cust_no.value = "";
			cust_no.focus();
			return false;
		}

		if (numPattern2 != null) {
			alert("�ݾ��� ���ڷθ� �Է��� �ּ���!");
			deposit_qty.value = "";
			deposit_qty.focus();
			return false;
		}

		return true;
	}
</script>
<script>
	<c:if test="${msg ne null}">
		alert("${msg}");
	</c:if>
</script>
</head>
<body>
	<h3 style="margin: 5px 0px;">�����Ա�(������)</h3>
	<form action='<c:url value="/deposit"/>' onsubmit="return validate();"
		method="post">
		<table border="1">
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>����ȣ</strong></td>
				<td><input type="text" name="cust_no" id="cust_no"
					maxlength="8" /></td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>�Աݾ�</strong></td>
				<td><input type="text" name="deposit_qty" id="deposit_qty"
					onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�Ա�"> <input
					type="reset" value="���"></td>
			</tr>
		</table>
	</form>
</body>
</html>