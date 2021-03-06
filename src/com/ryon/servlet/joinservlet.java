package com.ryon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ryon.db.MemberDAO;

/**
 * Servlet implementation class joinservlet
 */
@WebServlet("/mb_ok")
public class joinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//요청한글 인코딩
    	request.setCharacterEncoding("utf-8");
    	
    	//데이터 수집
    	String id = request.getParameter("uid");
    	String pw = request.getParameter("pwd");
   	 	String name = request.getParameter("name");
   	 	String email = request.getParameter("email");
   	 	String phone = request.getParameter("phone");
   	 	//위 정보를 DB에 넣기
   	 	int result = MemberDAO.insert(id, pw, name, email, phone);
   	 	
   	 	if(result == 0) {
   	 		//에러페이지
   	 		response.sendRedirect("joinerr.jsp");
   	 	}else {
   	 		//메인,로그인페이지
   	 		response.sendRedirect("mb_ok.jsp");
   	 	}

    	
		
   	 	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
