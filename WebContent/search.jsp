<%@page import="com.ryon.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	
    	String name = (String) session.getAttribute("name");
    	
    	if(name == null){
    		//로그인 안된 유저
    		response.sendRedirect("login.jsp");
    	}else{
    		//로그인 된 유저
    		System.out.println("로그인 된 사람 : " + name);
    		MemberDTO list = (MemberDTO)request.getAttribute("dblist");
    	}
    	
    	
    	
    	
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="look" method="post">
	조회 하고자 하는 이름:<br>
    <input name="chkname" type="text"/><br>
    <br>
    <input type="submit" value="조회">
</form>
${dblist[0]}<br>
</body>
</html>