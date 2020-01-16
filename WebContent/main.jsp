<%@page import="java.util.ArrayList"%>
<%@page import="com.ryon.db.MemberDAO"%>
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
    	}
    	
    	
    	ArrayList<MemberDTO> list = MemberDAO.select();
    	
		for(MemberDTO mdto :list) {
			
			System.out.print(mdto.getId());
			System.out.print(" " + mdto.getPw());
			System.out.print(" " + mdto.getName());
			System.out.print(" " + mdto.getEmail());
			System.out.println(" " + mdto.getPhone());
			
		}
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 유저만 보이는 화면<br>
<%=name %>님 반갑습니다.<br>
로그인 되었습니다.<br>
<a href = "logout.jsp">로그아웃</a>
<a href="search.jsp">회원정보 보기</a>

</body>
</html>