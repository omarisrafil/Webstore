package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveFromBasket
 */
@WebServlet("/RemoveFromBasket")
public class RemoveFromBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromBasket() {
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
		String url = request.getHeader("referer");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
    	synchronized(session){
    		@SuppressWarnings("unchecked")
    		List<Integer> basket = (List<Integer>) session.getAttribute("basket");
    		
    		Integer urunSayisi = (Integer) session.getAttribute("urunSayisi");
    		
    		Integer urunID = Integer.valueOf(request.getParameter("urunID"));
    		basket.remove(urunID);
    		urunSayisi = new Integer(urunSayisi.intValue()-1);
    		session.setAttribute("basket", basket);
    		session.setAttribute("urunSayisi", urunSayisi);
    	}
    	//System.out.println(url);
    	out.print("<meta charset='UTF-8' http-equiv='refresh' content='0; url="+ url +"'/>");
	}

}
