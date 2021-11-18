<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="commonHeader.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	$('td').on("click", function(){
		var diaryNo = $(this).parent().children('td').eq(0).text();
		$(location).attr('href', '/?diaryNo=' + diaryNo );
	});
});
</script>
</head>
<body>
<%@ include file="navbar.jsp" %>
<table class="table table-hover">
	<tr>
		<td>게시글번호</td>
		<td>날짜</td>
		<td>코인명</td>
		<td>수익률</td>
	</tr>
	<c:forEach items="${diaryList }" var="diaryList">
		<tr>
			<td>${diaryList.diaryNo }</td>
			<td>${diaryList.writeDt }</td>
			<td>${diaryList.coin.coinName }</td>
			<td>${diaryList.profitRate }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>