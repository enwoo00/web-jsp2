<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저등록</title>
</head>
<body>
<form method="POST" action="/user/insert">
<input type="text" name="uiId" placeholder="아이디"><br> 
<input type="text" name="uiPwd" placeholder="비번"><br> 
<input type="text" name="uiName" placeholder="이름"><br> 
<input type="text" name="uiAge" placeholder="나이"><br> 
<input type="text" name="uiPhone" placeholder="전화번호"><br> 
<input type="text" name="uiAddress" placeholder="주소"><br> 
<input type="radio" name="uiTrans" id="men" value="1" ><label for="men">남</label><br> 
<input type="radio" name="uiTrans" id="woman" value="2" ><label for="woman">여</label><br>  
<button>등록</button>
</form>
</body>
</html>