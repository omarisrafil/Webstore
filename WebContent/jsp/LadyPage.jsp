<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, com.database.Baglanti" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/stil.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/UtilityPageLog.jsp" %>
	<h4 align="center">BAYAN ÜRÜNLERİ ...</h4>
	<% request.setCharacterEncoding("UTF-8");
	String sqlkod = "SELECT U.urunID, upper(K.ad), T.ad, U.beden, U.fiyat FROM Urun U, Kategori K, Tur T WHERE U.kategoriID = K.kategoriID and U.turID = T.turID and U.kategoriID = 2 ORDER BY urunID DESC";
	ResultSet rs = Baglanti.vericekme(sqlkod);	
 	while(rs.next()){
 	int urunID = (rs.getInt(1));%>
 		<div class="urundiv">
 			<form action="/WebStore/AddToBasket" method="post">
 			<table>
			<tr><td> Kategori:</td>
			<td><%out.println(rs.getString(2));%></td>
			</tr>
			<tr><td> Tur:</td>
			<td><%out.println(rs.getString(3));%>
			</td></tr>
			<tr><td>Beden:</td>
			<td><% out.println(rs.getString(4));%></td></tr>
			<tr><td>Fiyat:</td>
			<td><%out.println(rs.getString(5));%>TL</td></tr>
			</table><br>
			<input type="hidden" name="urunID" value="<%=urunID%>">
			<input class="btn" type="submit" value="Sepete Ekle">
			</form>
		</div>
		<%}%>
</body>
</html>