<%@page import="com.web.dto.TestDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ 지시자 Directive=> page, include, taglib --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/views/test/test-insert">테스트 등록</a>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<c:if test="${empty tests}">
			<tr>
				<th colspan="2">내용이 없습니다.</th>
			</tr>
		</c:if>
		<c:forEach items="${tests }" var="test">
			<tr>
				<td>${test.tiNum }</td>
				<td><a href="/test/test-view?tiNum=${test.tiNum }">${test.tiName }</a></td>
			</tr>
		</c:forEach>



	</table>
</body>
</html>