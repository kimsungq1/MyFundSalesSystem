<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>MEMBER JOIN</h3>
	<form action='<c:url value="/user/join"/>' method="post">
		<table border="1">
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>ID</strong></td>
				<td><input type="text" name="id" id="id" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>PW</strong></td>
				<td><input type="password" name="passwd" id="passwd" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>NAME</strong></td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td style="background-color:#d3d3d3; font-size:13.5px"><strong>AUTHORITY</strong></td>
				<td><select name="authority">
						<option value="ROLE_USER">사용자</option>
						<option value="ROLE_ADMIN">관리자</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Join"> <input
					type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>

