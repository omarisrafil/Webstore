package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToBasket
 */
@WebServlet({ "/AddToBasket", "/WebStore/AddToBasket" })
public class AddToBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
    		if(basket == null){
    			basket = new ArrayList<Integer>();
    		}
    		Integer urunSayisi = (Integer) session.getAttribute("urunSayisi");
    		if(urunSayisi == null){
    			urunSayisi = new Integer(0);}
    		int urunID = Integer.parseInt(request.getParameter("urunID"));
    		basket.add(urunID);
    		urunSayisi = new Integer(urunSayisi.intValue()+1);
    		session.setAttribute("basket", basket);
    		session.setAttribute("urunSayisi", urunSayisi);
    	}
    	//System.out.println(url);
    	out.print("<meta charset='UTF-8' http-equiv='refresh' content='0; url="+ url +"'/>");
	
	}

}
