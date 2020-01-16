package com.ryon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ryon.db.MemberDAO;
import com.ryon.dto.MemberDTO;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/lg_ok")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String lid = request.getParameter("logid");
    	String lpw = request.getParameter("logpwd");
    	HttpSession session = request.getSession();
    	
    	//DB에 id,pw가 있는지 확인.
    	MemberDTO dto = MemberDAO.select(lid, lpw);
    	
    	if(dto == null) {
    		response.getWriter().append("아이디가 없거나 비밀번호가 틀렸습니다.");
    		
    	}else {
    		session.setAttribute("name", dto.getName());
    		response.sendRedirect("main.jsp");
    	}
    	
    	
    	
    	//만약 lid가 db에 있는 아이디가 있고 비밀번호가 맞다면 
    	//SELECT * FROM member WHERE id = lid;
    	//로그인 성공
    	//아니면 실패
    	
    	
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
