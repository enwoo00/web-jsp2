<%@page import="com.web.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저상세화면</title>
</head>
<body>
<h3>상세화면</h3>
<%//UserDTO user = (UserDTO)request.getAttribute("user");
//out.print(user.getUiNum());
if(request.getAttribute("user")!=null){ %>
<table border="1">
<tr>
<th>번호</th>
<td>${user.uiNum}</td>
</tr>
<tr>
<th>이름</th>
<td>${user.uiName}</td>
</tr>
<tr>
<th>전화번호</th>
<td>${user.uiPhone}</td>
</tr>
<tr>
<th>아이디</th>
<td>${user.uiId}</td>
</tr>
<tr>
<th>나이</th>
<td>${user.uiAge}</td>
</tr>

</table>
<br>
${user.uiNum}
<%}%>
</body>
</html>