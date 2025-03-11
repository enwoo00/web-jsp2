<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (request.getAttribute("test") == null) {
	%>
	존재하지 않는 테스트입니다.
	<%
	} else {
	%>
	<form action = "/test/update" method="POST">
	<input type="hidden" name="tiNum" value="${test.tiNum}">
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input type="text" name="tiName" value="${test.tiName}"></td>
		</tr>
			<tr>
				<th colspan="2">
					<button>등록 수정</button>
				</th>
			</tr>
	</table>
</form>
	<%
	}
	%>
</body>
</html>