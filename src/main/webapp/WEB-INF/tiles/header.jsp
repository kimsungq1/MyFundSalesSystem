<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<style>
ul li {
	list-style: none;
	float: left;
	margin-right: 25px;
	cursor:pointer;
}
</style>
</head>
<body>
	<ul style="padding-left: 5px;">
		<li id = "excelUpload">���ذ����</li>
		<li id = "insertClient">�����</li>
		<li id = "depositPage">�����Ա�(������)</li>
		<li id = "withdrawPage">�����ݰ������</li>
		<li id = "insertAccountPage">�ݵ���°���</li>
		<li id = "purchaseFundPage">���Խ�û</li>
		<li id = "repurchaseFundPage">ȯ�Ž�û</li>
		<li id = "batchPurchasePage">�ϰ�����</li>
		<li id = "batchRepurchasePage">�ϰ�ȯ��</li>
	</ul>
	
	<script>
    	jQuery(document).ready(function() {
        	$("#excelUpload").on("click", function() {
        		location.href = "/excelUpload";
        	});
        	
        	$("#insertClient").on("click", function() {
        		location.href = "/insertClientPage";
        	});
        	
        	$("#depositPage").on("click", function() {
        		location.href = "/depositPage";
        	});
        	
        	$("#withdrawPage").on("click", function() {
        		location.href = "/withdrawPage";
        	});
        	
        	$("#insertAccountPage").on("click", function() {
        		location.href = "/insertAccountPage";
        	});
        	
        	$("#purchaseFundPage").on("click", function() {
        		location.href = "/purchaseFundPage";
        	});
        	
        	$("#repurchaseFundPage").on("click", function() {
        		location.href = "/repurchaseFundPage";
        	});
        	
        	$("#batchPurchasePage").on("click", function() {
        		location.href = "/batchPurchasePage";
        	});
        	
        	$("#batchRepurchasePage").on("click", function() {
        		location.href = "/batchRepurchasePage";
        	});
    	});
	</script>
</body>
</html>