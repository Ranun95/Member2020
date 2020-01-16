<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입
<form action="mb_ok" method="post">
  	 아이디:<br>
  <input type="text" name="uid" ><br>
  	 비밀번호:<br>
  <input type="password" name="pwd" ><br>
 	 이름:<br>
  <input type="text" name="name" ><br>
 	 이메일:<br>
  <input type="email" name="email" ><br>
 	 전화번호:<br>
  <input type="tel" name="phone" ><br>
  <br>
  <input type="submit" value="회원가입">
  <input type="reset" value="취소"><br>
  <a href="index.jsp">로그인</a>
</form>
</body>
</html>