<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="commonHeader.jsp" %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	$('#btnSubmit').click(function(event) {
		
	    var formData= {
	        'userId'  : $('input[name=userId]').val(),
	        'password' : $('input[name=password]').val(),
	        'korNm' : "손민혜"
	    };
	    
	    $.ajax({
	        type        : 'POST',
	        url         : $('#userForm').attr('action'),
	        contentType : 'application/json; charset=utf-8', 
	        dataType    : 'text',
	        data        : JSON.stringify(formData),
	        success     : function(data){
	        	alert("등록되었습니다.");
	        	$(location).attr("href", "/login");
	        }
	    })
	
	    event.preventDefault();
	});
});
</script>
<body>
<h2>회원가입</h2>
<form action="saveUserInfo" method="POST" class="form" id="userForm">
 <div class="form-group">
	<label for="input1">아이디</label>
	<input type="text" name="userId"/>
	</div>
<div class="form-group">
	<label for="input1">비밀번호</label>
	<input type="text" name="password"/>
</div>
 <input type="button" id ="btnSubmit" class="btn btn-primary my-1" value="등록"/>
</form>
</body>
</html>