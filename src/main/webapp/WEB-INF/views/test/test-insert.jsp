<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/test/insert" method="POST">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="tiName" placeholder="이름">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<button>등록하기</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>