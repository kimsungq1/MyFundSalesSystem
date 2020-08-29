<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='<c:url value="/user/login"/>' method="post">
		<input type="text" name="id" id="id" /> 
		<input type="password" name="passwd" id="passwd"/> 
		<input type="submit" value="완료">
		<br> <a href="/user/joinPage">JOIN</a>
		
		<c:if test="${errMsg != null}"> 
			<br> <p>아이디나 비밀번호가 잘못되었습니다.</p> 
		</c:if>
	</form>
</body>
</html>


