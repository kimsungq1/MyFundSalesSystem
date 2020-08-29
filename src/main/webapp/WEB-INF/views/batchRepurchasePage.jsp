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
       var tagetNum = document.getElementById("tagetNum");
       
       if(isNull(tagetNum.value)) {
           alert("대상 건수가 없습니다.");
           return false;
       }  
       
       var request =   $.ajax({
    		url : "/batchRepurchase",
      		type : "POST",
      	  });
     
       request.done(function(result){
    	   	$("#doneNum").removeAttr("disabled");
     	  	$('input[name=doneNum]').attr('value',result);
     	  	$("#doneNum").attr("disabled", "disabled");
   		    alert("처리건수 : " + result); 
   		 
   	   }); 
   }
</script>
<script type="text/javascript"> 
function select(){
	$.ajax({
		url : "/selectTarget2",
		type : "post",
		success : function(data){
			if(data == 0) {
				alert("조회된 대상건수가 없습니다");
			} else {
				alert("조회 완료, 일괄처리 버튼을 통해 일괄 매입처리 하세요");
				$("#tagetNum").val(data);
				$("#submit").removeAttr("disabled");
			}
			
		}
	})
}

</script>
<script>
	<c:if test="${msg ne null}">
		alert("${msg}");
	</c:if>
</script>
</head>
<body>
	<h3 style="margin: 5px 0px;">일괄환매</h3>
	<form onsubmit="validate();" method="post">
		<table border="1">
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>대상건수</strong></td>
				<td><input type="text" name="tagetNum" id="tagetNum" disabled="disabled"></td>
			</tr>
			<tr>
				<td style="background-color: #d3d3d3; font-size: 13.5px"><strong>처리건수</strong></td>
				<td><input type="text" name="doneNum" id="doneNum" disabled="disabled"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="selectBtn" onclick="select();">조회</button> 
					<input type="submit" value="일괄환매처리" id="submit" disabled="disabled"> 
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>