package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.UserDAO;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append("\n" + mail + "\n" + parola);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String mail = request.getParameter("mail").trim();
		String parola = request.getParameter("parola").trim();
		String kontrol = "true";
		int userID = UserDAO.Login(mail, parola);
		if(userID !=0){
			if(userID == 10000){
				HttpSession session = request.getSession(true);
				session.setAttribute("user", userID);
				//System.out.println("Welcome Admin" );
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='0; url=jsp/AdminPage.jsp' />");				
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", userID);
				session.setAttribute("kontrol", kontrol);
				//System.out.println("Welcome Again" + mail );
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='0; url=jsp/ProfilePage.jsp' />");
			}			
		} else {
			//System.out.println("Wrong email or password, please try again" );
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=html/LogInPage.html' />Failed to Log In, Check infos you entered ...");			
		}
	}
}
