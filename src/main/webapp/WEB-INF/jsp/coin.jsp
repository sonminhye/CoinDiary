<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="commonHeader.jsp" %>
<head>
<style>
.form {
	margin:10px;
}
</style>
<meta charset="UTF-8">
<title>코인등록</title>
<script>
$(document).ready(function(){
    $('#submitBtn').click(function(event) {
    	
        var formData= {
            'coinCode'  : $('input[name=coinCode]').val(),
            'marketCode' : $('select[name=marketCode]').val(),
            'coinName'   : $('input[name=coinName]').val()
        };
 
        $.ajax({
            type        : 'POST',
            url         : $('#coinForm').attr('action'),
            contentType : 'application/json; charset=utf-8',
            dataType    : 'text',
            data        : JSON.stringify(formData),
            success     : function(data){
            	alert("등록되었습니다.");
            	$(location).attr("href", "/coin");
            }
        })
 
        event.preventDefault();
    });
});
</script>
</head>
<%@ include file="navbar.jsp" %>
<body>
<div style="height:50%" class="table">
	<table class="table table-hover">
		<tr>
			<td>코인코드</td>
			<td>거래소</td>
			<td>코인명</td>
		</tr>
		<c:forEach items="${coinList }" var="coinList">
			<tr>
				<td>${coinList.coinCode }</td>
				<td>${coinList.marketCode }</td>
				<td>${coinList.coinName }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<div>
	<form id="coinForm" method="POST" action="/saveCoin" class="form">
	  <div class="form-group">
	    <label for="input1">마켓</label>
	    <select class="form-control" id="marketCode" name="marketCode">
	      <option value="UPBIT">업비트</option>
	      <option value="BITSUM">빗썸</option>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="input2">코인코드</label>
	    <input type="text" class="form-control" id="coinCode" name="coinCode" placeholder="">
	  </div>
	  <div class="form-group">
	    <label for="input3">코인명</label>
	    <input type="text" class="form-control" id="coinName" name="coinName" placeholder="">
	  </div>
	 <input type="button" id ="submitBtn" class="btn btn-primary my-1" value="등록"/>
	</form>
</div>
</body>
</html>