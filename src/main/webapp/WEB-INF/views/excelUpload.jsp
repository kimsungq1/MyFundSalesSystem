<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function doExcelUploadProcess() {
			var f = new FormData(document.getElementById('form1'));
			$.ajax({
				url : "uploadExcelFile",
				data : f,
				processData : false,
				contentType : false,
				type : "POST",
				success : function(data) {
					console.log(data);
					document.getElementById('result').innerHTML = JSON.stringify(data);
				}
			})
		}

	</script>
	<form id="form1" name="form1" method="post"
		enctype="multipart/form-data">
		<input type="file" id="fileInput" name="fileInput">
		<button type="button" onclick="doExcelUploadProcess()">Excel-Upload</button>
	</form>
	<div id="result"></div>
</body>
</html>

