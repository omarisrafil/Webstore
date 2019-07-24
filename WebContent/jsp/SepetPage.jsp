<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javax.servlet.http.*, java.util.*, javax.servlet.*,java.sql.*, com.database.Baglanti, java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/UtilityPageLog.jsp" %>
	<% request.setCharacterEncoding("UTF-8");
	HttpSession session1 = request.getSession();
	Integer urunSayisi = null;
	List<Integer> basket = null;
	if (session != null) {
		@SuppressWarnings("unchecked")
		List<Integer> basket2 = (List<Integer>) session.getAttribute("basket");
		if(basket2 == null){
			urunSayisi = 0;
			%><h2 align="center">Sepetinizde <%=urunSayisi%> ürün var</h2><%
		if(urunSayisi!=0){%>
			
		<%}
		}else{
		basket = basket2;
		urunSayisi = (Integer) session.getAttribute("urunSayisi");%>
	
		<form action="/WebStore/EndShopping" method="post"><input id ="end-shopping" class="btn" type="submit" value="Alış verişi tamamla" ></form>
		<h2 align="center">Sepetinizde <%=urunSayisi%> ürün var</h2>
	<% int urunID;
	for(Integer item: basket){
		urunID = item.intValue();
		String sqlkod = "select upper(K.ad), T.ad, U.beden, U.fiyat FROM Urun U, Kategori K, Tur T WHERE U.urunID = "+ urunID +" and U.kategoriID = K.kategoriID and U.turID = T.turID";
		ResultSet rs = Baglanti.vericekme(sqlkod);	
	 	while(rs.next()){%><div class="urundiv">
 			<table>
			<tr><td> Kategori:</td>
			<td><%out.println(rs.getString(1));%></td>
			</tr>
			<tr><td> Tur:</td>
			<td><%out.println(rs.getString(2));%>
			</td></tr>
			<tr><td>Beden:</td>
			<td><% out.println(rs.getString(3));%></td></tr>
			<tr><td>Fiyat:</td>
			<td><%out.println(rs.getInt(4));%>TL</td></tr>
			</table><br>
			<form action="/WebStore/RemoveFromBasket" method="post">
			<input type="hidden" name="urunID" value="<%=item%>">
			<input class="btn" type="submit" value="Remove">
			</form>
			</div>
			<%}
		}
	}
}
%>
</body>
</html>