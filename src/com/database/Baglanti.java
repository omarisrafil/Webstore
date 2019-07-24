package com.database;

import java.sql.*;

public class Baglanti {
	
	protected static Connection Connect() {
		String connectionURL;
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=WebStore;integratedSecurity=true";
			con = DriverManager.getConnection(connectionURL);
		} catch (Exception err) {
			System.out.println("mysql Driver Bulunamadı" + err);
		}
		return con;
	}
	public static ResultSet vericekme(String sqlkod){
		Connection con = Baglanti.Connect();
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlkod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static int Operations(String sqlkod){
		Connection con = Baglanti.Connect();
		PreparedStatement stmt = null;
		int value = 0;
		try {
			stmt = con.prepareStatement(sqlkod);
			value = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return value;		
	} 
	/*public static void main (String[] args){
		String sqlkod = "select urunID from Urun";
		ResultSet a = vericekme(sqlkod);
		try {
			while(a.next()){
				System.out.println(a.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}*/		
}
