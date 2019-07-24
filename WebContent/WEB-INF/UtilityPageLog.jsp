<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.sql.*, com.database.Baglanti" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to our Web Store</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css'>
<%-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">--%>
<link rel="stylesheet" href="css/stil.css">
</head>
<body>
<div class="ustmenu">
	<ul>
		<li><a href="HomePage.jsp">ANASAYFA</a></li>
		<% request.setCharacterEncoding("UTF-8");
	
		ResultSet result1 = Baglanti.vericekme("select UPPER(ad) from Kategori");
		while(result1.next()){
		String baslik = result1.getString(1);
		String URI = "#";
		if (baslik.equals("BAY")){
			URI = "ManPage.jsp";
		}else if (baslik.equals("BAYAN")){
			URI = "LadyPage.jsp";
		}else if (baslik.equals("ÇOCUK")){
			URI = "ChildPage.jsp";
		}else if (baslik.equals("BEBEK")){
			URI = "BabyPage.jsp";
		}%>
		<li><a href="<%=URI%>"><%=baslik%></a></li>
		<%}%>
		<li><a href="ProfilePage.jsp">PROFİLİM</a></li>
  		<li><a href="SepetPage.jsp">SEPET'E GİT</a></li>
  		<li><a href="/WebStore/LogOut">OTURUMU KAPAT</a></li>
	</ul>
</div>
<div class="yanmenu">
	<h5 align="center">KATEGORİLER</h5><hr>
	<ul>
	<% ResultSet result2 = Baglanti.vericekme("select UPPER(ad) from Kategori");
	while(result2.next()){
	String baslik = result2.getString(1);
	String URI = "#";
		if (baslik.equals("BAY")){
			URI = "ManPage.jsp";
		}else if (baslik.equals("BAYAN")){
			URI = "LadyPage.jsp";
		}else if (baslik.equals("ÇOCUK")){
			URI = "ChildPage.jsp";
		}else if (baslik.equals("BEBEK")){
			URI = "BabyPage.jsp";
		}%>
	<li><a href="<%=URI%>"><%=baslik%></a></li>
	<%}%>
    </ul>
</div>
<div class="page" id="page">

</div>
</body>
</html>