package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.UrunDAO;

/**
 * Servlet implementation class DeleteUrun
 */
@WebServlet("/DeleteUrun")
public class DeleteUrun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUrun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();		
		int urunID =(Integer.parseInt((request.getParameter("urunID"))));
		try{
			int kontrol = UrunDAO.DeleteUrun(urunID);
			if(kontrol!=0){
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/AdminPage.jsp' />Product deleted, redirecting to Admin Page ..." );
			}else{
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/AdminPage.jsp' />Failed to delete, redirecting to Admin Page");
			}
		}catch(Exception err){
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/AdminPage.jsp' />"+ err +", redirecting to Admin Page");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
