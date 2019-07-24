<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javax.servlet.http.*"%>
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
	<h4 align="center">SİPARİŞLERİNİZ ...</h4>
	<% request.setCharacterEncoding("UTF-8");
	int userID = (Integer)session.getAttribute("user");
	String sqlkod = "select S.tarih, K.ad as Katad, T.ad as Turad, S.urunFiyat, S.adet, S.toplamFiyat from Siparis S, Kategori K, Tur T, Urun U where S.userID = "+ userID +" and S.urunID = U.urunID and U.kategoriID = K.kategoriID and U.turID = T.turID";
	ResultSet rs = Baglanti.vericekme(sqlkod);
	if(rs!=null){
		while(rs.next()){%>
		<div class="siparis">
 			<table>
 			<tr>
 				<th>Tarih</th>
 				<th>Kategori Adı</th>
 				<th>Tür Adı</th>
 				<th>Ürün Fiyatı</th>
 				<th>Adet</th>
 				<th>Toplam Fiyat</th>
 			</tr>	
 			<tr>
 				<td><%=rs.getString("tarih")%></td>
				<td><%=rs.getString("Katad")%></td>
				<td><%=rs.getString("Turad")%></td>
				<td><%=rs.getInt("urunFiyat")%></td>
				<td><%=rs.getInt("adet")%></td>
				<td><%=rs.getInt("toplamFiyat")%></td>
 			</tr>
 		</table>	
		<%}
		}else{out.println("No order found");}%>
	</div>
</body>
</html>