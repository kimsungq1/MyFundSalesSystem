<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Fund Main</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<div id="container" style="width: 100%; height: 100%;">
		<div id="header" style="margin-bottom: 10px; height: 50px; width: 100%; border: 1px solid #d6d6d6;">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="main" style="padding: 5px 5px; height: auto; overflow-y: scroll; width:100%; border: 1px solid #d6d6d6;">
			<tiles:insertAttribute name="body" />
		</div>
	</div>

	<script type="text/javascript">
		$(function() {

		});
	</script>
</body>
</html>