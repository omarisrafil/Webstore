package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.UserDAO;
import com.model.User;

/**
 * Servlet implementation class SingIn
 */
@WebServlet("/SingIn")
public class SingIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String ad = request.getParameter("ad").trim();
		String soyad = request.getParameter("soyad").trim();
		String email = request.getParameter("email").trim();
		String parola = request.getParameter("parola").trim();
		String parolatekrar = request.getParameter("parolatekrar").trim();
		String address = request.getParameter("address").trim();
		
		if(ad!="" && soyad!="" && email!="" && parola!="" && address!="" && parola.equals(parolatekrar)){
			User user = new User();
			user.setAd(ad);
			user.setSoyad(soyad);
			user.setEmail(email);
			user.setParola(parola);
			user.setAddress(address);
			try{
				int kontrol = UserDAO.AddUser(user);
				if(kontrol !=0){
					out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=html/LogInPage.html' />Registration Successfull \n Redirecting to Log In page ...");
				}else{
					out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=html/LogInPage.html' />Failed To Register, Try Again ...");
				}			
			}catch(Exception err){
				System.out.println(err);
			}
		}else{
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=html/LogInPage.html' />Check Again Values You Entered ...");
		}
	}

}
