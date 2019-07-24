package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.UrunDAO;
import com.model.Urun;

/**
 * Servlet implementation class AddUrun
 */
@WebServlet("/AddUrun")
public class AddUrun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUrun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Urun urun = new Urun();
		urun.setKategoriID(Integer.parseInt(request.getParameter("menu-add-kategoriid")));
		urun.setTurID(Integer.parseInt(request.getParameter("menu-add-turid")));
		urun.setBeden(request.getParameter("beden-add"));
		urun.setFiyat(Integer.parseInt(request.getParameter("fiyat-add")));

		try{
			int kontrol = UrunDAO.AddUrun(urun);
			if(kontrol !=0){
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/AdminPage.jsp' />Product added Successfully, redirecting to Admin Page ...");
			}else{
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/AdminPage.jsp' />Failed To Add Product, Try Again ...");
			}			
		}catch(Exception err){
			System.out.println(err);
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/AdminPage.jsp' />Error when trying to add, Try Again ...");
		}
		
	}

}
