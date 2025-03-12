<%@page import="com.web.dto.FoodDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/views/food/food-insert">메뉴등록</a>
${empty tests}
<table border="1">
	<tr>
		<th>번호</th>
		<th>메뉴</th>
		<th>가격</th>
	</tr>

<c:forEach items="${foods}" var="food">
	<tr>
	<td>${food.fiNum}</td>
	<td><a href="/food/food-view?fiNum=${food.fiNum}">${food.fiName}</a></td>
	<td>${food.fiPrice}</td>

</c:forEach>

</table>
</body>
</html>