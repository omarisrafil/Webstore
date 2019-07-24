<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*" %>
    <%@page import="com.database.*"%>
	<%@page import="java.util.List"%>
	<%@page import="com.servlets.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
	<link rel="stylesheet" href="css/stil.css">
	<title>Insert title here</title>
</head>
<body>
<p><a href="HomePage.jsp">ANA SAYFA</a></p>
	<div class="urunupdate-container" class="content">
            <form action="/WebStore/UpdateUrun" method="post">            
                <h3 align="center">ÜRÜN GÜNCELLEME PANELİ</h3>
                	Ürün ID: <select name="menu-urunid">
                		<option selected>Ürün seçin</option>
						<%request.setCharacterEncoding("UTF-8");
						String sqlkod = "select urunID from Urun";
						ResultSet rs = Baglanti.vericekme(sqlkod);
						int urunID = 0;
						while(rs.next()){
							urunID = rs.getInt(1);%>
						<option value="<%=urunID%>"><%=urunID%></option><%}%>
					</select><br>
                    Ürün Kategori: <select name="menu-up-kategoriid">
                		<option selected>Kategori seçin</option>
						<%request.setCharacterEncoding("UTF-8");
						String sqlkod2 = "select kategoriID, upper(ad) from Kategori";
						ResultSet rs2 = Baglanti.vericekme(sqlkod2);
						while(rs2.next()){
							int kategoriID = rs2.getInt(1);
							String ad = rs2.getString(2);%>
						<option value="<%=kategoriID%>"><%=ad%></option><%}%>
					</select><br>
                    Ürün Tür: <select name="menu-up-turid">
                		<option selected>Tür seçin</option>
						<%request.setCharacterEncoding("UTF-8");
						String sqlkod3 = "select turID, upper(ad) from Tur";
						ResultSet rs3 = Baglanti.vericekme(sqlkod3);
						while(rs3.next()){
							int turID = rs3.getInt(1);
							String ad = rs3.getString(2);%>
						<option value="<%=turID%>"><%=ad%></option><%}%>
					</select><br>
					Ürün Fiyat: <input type="text" name="fiyat-up"><br>
					Ürün Beden: <input type="text" name="beden-up"><br>
                    <input type="submit" name="güncelle" value="GÜNCELLE"><br>
                    </form>
    </div>
    <div class="ekle-container">
                    <form action="/WebStore/AddUrun" method="post">
                    	<h3 align="center">ÜRÜN EKLEME PANELİ</h3><br>
                    	
                    Ürün Kategori: <select name="menu-add-kategoriid">
                		<option selected>Kategori seçin</option>
						<%request.setCharacterEncoding("UTF-8");
						String sqlkod4 = "select kategoriID, upper(ad) from Kategori";
						ResultSet rs4 = Baglanti.vericekme(sqlkod4);
						while(rs4.next()){
							int kategoriID = rs4.getInt(1);
							String ad = rs4.getString(2);;%>
						<option value="<%=kategoriID%>"><%=ad%></option><%}%>
					</select><br>
                    Ürün Tür: <select name="menu-add-turid">
                		<option selected>Tür seçin</option>
						<%request.setCharacterEncoding("UTF-8");
						String sqlkod5 = "select turID, upper(ad) from Tur";
						ResultSet rs5 = Baglanti.vericekme(sqlkod5);
						while(rs5.next()){
							int turID = rs5.getInt(1);
							String ad = rs5.getString(2);%>
						<option value="<%=turID%>"><%=ad%></option><%}%>
					</select><br>
                    	Ürün Fiyat: <input type="text" name="fiyat-add"><br>
                    	Ürün Beden: <input type="text" name="beden-add"><br>
                    	<input type="submit" name="sil" value="       EKLE      "><br>
                    	</form>                    	
    </div>
    <div class="urundelete-container">
                    <h3 align="center">ÜRÜNLER LİSTESİ</h3>
                    <table align="center" width="100%">
 					<tr align="center">
 						<th>---Ürünün id'si--</th>
 						<th>Ürünün Kategorisi</th>
 						<th>---Ürünün Türü---</th>
 						<th>--Ürünün Bedeni--</th>
 						<th>--Ürünün Fiyatı--</th>
 						<th>-----İşlemler----</th>
 					</tr></table> 				 			
 					<%
 					request.setCharacterEncoding("UTF-8");
					String sqlkod1 = "SELECT U.urunID, upper(K.ad), upper(T.ad), upper(U.beden), U.fiyat FROM Urun U, Kategori K, Tur T WHERE U.kategoriID = K.kategoriID and U.turID = T.turID ORDER BY urunID DESC";
					ResultSet rs1 = Baglanti.vericekme(sqlkod1);
 					while(rs1.next()){%> 					
 					<table class="veri-tablosu">
 					<tr align="center">
 						<th>______________</th>
 						<th>______________</th>
 						<th>______________</th>
 						<th>______________</th>
 						<th>______________</th>
 						<th>______________</th>
 					</tr>
 						<tr>
 						<%int id=(rs1.getInt(1));%>
 							<td align="center"><%out.println(rs1.getInt(1)); %></td>
							<td align="center"><%out.println(rs1.getString(2)); %></td>
							<td align="center"><%out.println(rs1.getString(3)); %></td>
							<td align="center"><%out.println(rs1.getString(4));%></td>
							<td align="center"><%out.println(rs1.getInt(5));%>TL</td>
							<td align="center"><a href=/WebStore/DeleteUrun?urunID=<%=id %>>Ürünü Sil</a></td>
 						</tr>
 					</table>
 				<br><%}%>	
	</div>
</body>
</html>