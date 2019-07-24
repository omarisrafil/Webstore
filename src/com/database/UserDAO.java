package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserDAO {
	
	public static int Login(String mail, String parola){
		String sqlkod = "Select userID from Musteri where email='" +mail+ "' and parola='" +parola+ "'";
		ResultSet rs = Baglanti.vericekme(sqlkod);
		int userID = 0;
		if(rs!=null){
			try {
				while(rs.next()){
					userID = Integer.parseInt(rs.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return userID;
	}
	public static int AddUser(User user){
		
		String ad = user.getAd();
		String soyad = user.getSoyad();
		String email = user.getEmail();
		String parola = user.getParola();
		String address = user.getAddress();
		String sqlkod = "insert into Musteri(ad, soyad, email, parola, address) values ('"+ ad +"', '"+ soyad +"', '"+ email +"', '"+ parola +"', '"+ address +"')";
		int value = Baglanti.Operations(sqlkod);
		
		return value;		
	}
	public static int UpdateUser(User user){
		return 0;
	}

}
