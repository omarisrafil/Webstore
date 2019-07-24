package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.*;
import com.model.Siparis;

/**
 * Servlet implementation class EndShopping
 */
@WebServlet("/EndShopping")
public class EndShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndShopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Integer> basket = (List<Integer>) session.getAttribute("basket");
		Integer userID = (Integer) session.getAttribute("user");
		Siparis siparis = new Siparis();
		int urunID;
		String tarih = new java.util.Date().toString();
		for(Integer item: basket){
			urunID = item.intValue();
			int adet = com.database.SiparisDAO.HowMany(basket, item);
			for(int i=0;i<basket.size();i++){
				if(basket.get(i).equals(item)){
					basket.remove(item);
				}
			}
			int urunFiyat = 0;
			String sqlkod = "select fiyat from Urun where urunID = "+ urunID;
			ResultSet rs = Baglanti.vericekme(sqlkod);
			if(rs!=null){
				try {
					while(rs.next()){
						urunFiyat = rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			siparis.setTarih(tarih);
			siparis.setUserID(userID);
			siparis.setUrunID(urunID);
			siparis.setUrunFiyat(urunFiyat);
			siparis.setAdet(adet);
			try{
				SiparisDAO.AddSiparis(siparis);				
			}
			catch(Exception err){
				//System.out.println(err);
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=jsp/HomePage.jsp' />Error occured ...");
			}
		}
		if (!basket.isEmpty()){basket.clear();}
		int urunSayisi = 0;
		session.setAttribute("urunSayisi", urunSayisi);
		session.setAttribute("basket", basket);
		out.print("<meta charset='UTF-8' http-equiv='refresh' content='3; url=jsp/HomePage.jsp' />Operation Successfull, redirecting to Home Page ...");
	}
}

