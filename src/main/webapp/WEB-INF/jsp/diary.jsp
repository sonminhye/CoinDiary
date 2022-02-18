<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="commonHeader.jsp" %>
<meta charset="UTF-8">
<title>코인 다이어리</title>
<style>
h3,
.diary-form{
	margin:10px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var date = new Date();
	$("input[name=writeDt]").val((date.getFullYear()) +'' +(date.getMonth()+1) + ''+ (date.getDate()));
	
	if($('select[name=coinCode]').val() == ""){
		$("select[name=coinCode] > option").hide();
		$('option[data-market=' + $('select[name=coinCode]').val() + ']').show();
	}
	
	$("#marketCode").change(function(){ 
		$("select[name=coinCode] > option").hide();
		$("select[name=coinCode] > option:selected").prop('selected', false);
		$('option[data-market=' + $(this).val() + ']').show();
	});
	
	$("#submitBtn").click(function(){
		
		var header = $("meta[name=_csrf_header]").attr("content");
        var token = $("meta[name=_csrf]").attr("content");
		
		var formData = {
				"diaryNo" : $("input[name=diaryNo]").val()
			  , "writeDt" : $("input[name=writeDt]").val()
			  , "avgPrice" : $("input[name=avgPrice]").val()
			  , "investAmt" : $("input[name=investAmt]").val()
			  , "inout"    : $("input[name=inout]").val()
			  , "profitRate" : $("input[name=profitRate]").val()
			  ,  "coin" : {
				 	 "coinCode" : $("select[name=coinCode]").val()
					,"marketCode" : $("select[name=marketCode]").val()
			   }
		};
		
		$.ajax({
            type        : 'POST',
            url         : '/saveDiary',
            contentType : 'application/json; charset=utf-8',
            dataType    : 'text',
            data        : JSON.stringify(formData),
            beforeSend: function (jqXHR, settings) {
                jqXHR.setRequestHeader(header, token);
     		},
            success     : function(data){
            	alert("등록되었습니다.");
            	$(location).attr("href", "/diaryList");
            }
        });
		
		event.preventDefault();
		
	});
	
	
	
});
</script>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div>
<h3>다이어리 등록</h3>
</div>
<div class="diary-form">
<form id="diaryForm" method="POST" action="/saveDiary">
  <input name="diaryNo" type="hidden" value="${diary.diaryNo }"/>
  <div class="form-group">
    <label for="input1">날짜</label>
    <input type="text" class="form-control" id="writeDt" name="writeDt" placeholder="" value="${diary.writeDt}">
  </div>
  <div class="form-group">
  <label for="input2">코인</label>
  <div class="row">
    <div class="col">
		<select class="form-control" id="marketCode" name="marketCode">
		<c:forEach items="${marketList}" var="marketList">
			<option value="${marketList.marketCode }" <c:if test="${coin.marketCode == marketList.marketCode}"> selected </c:if> >${marketList.marketName }</option>
		</c:forEach>
		</select>
	</div>
	<div class="col">
		<select class="form-control" id="coinCode" name="coinCode">
			<option>선택</option>
			<c:forEach items="${coinList }" var="coinList">
				<option value="${coinList.coinCode }" data-market="${coinList.marketCode }" <c:if test="${coin.coinCode == coinList.coinCode}"> selected </c:if>  >${coinList.coinName} </option>
			</c:forEach>
	    </select>
    </div>
  </div>
  </div>
  <div class="form-group">
    <label for="input3">평단가</label>
    <input type="text" class="form-control" id="avgPrice" name="avgPrice" placeholder="" value="${diary.avgPrice}">
  </div>
  <div class="form-group">
   <label for="input4">투자금액</label>
   <input type="text" class="form-control" id="investAmt" name="investAmt" placeholder="" value="${diary.investAmt}">
 </div>
  <div class="form-group">
   <label for="input4">매수/매도</label>
   <input type="text" class="form-control" id="inout" name="inout" placeholder="" value="${diary.inout }">
 </div>
  <div class="form-group">
   <label for="input4">수익률</label>
   <input type="text" class="form-control" id="profitRate" name="profitRate" placeholder="" value="${diary.profitRate }">
 </div> 
 <button type="button" id="submitBtn" class="btn btn-primary my-1">등록</button>
</form>
</div>
</body>
</html>