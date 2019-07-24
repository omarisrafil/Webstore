package com.database;

import com.model.Urun;

public class UrunDAO {
	public static int AddUrun(Urun urun){
		
		int kategoriID = urun.getKategoriID();
		int turID = urun.getTurID();
		String beden = urun.getBeden();
		int fiyat = urun.getFiyat();
		String sqlkod = "insert into Urun(kategoriID, turID, beden, fiyat) values("+ kategoriID +","+ turID +",'"+ beden +"',"+ fiyat +")";
		int value = Baglanti.Operations(sqlkod);
		
		return value;
	}
	public static int UpdateUrun(Urun urun, int urunID){
		
		int kategoriID = urun.getKategoriID();
		int turID = urun.getTurID();
		String beden = urun.getBeden();
		int fiyat = urun.getFiyat();
		String sqlkod = "update Urun set kategoriID = "+ kategoriID +", turID = "+ turID +", beden = '"+ beden +"', fiyat = "+ fiyat +" where urunID = "+ urunID;
		int value = Baglanti.Operations(sqlkod);
		
		return value;
	}
	public static int DeleteUrun(int urunID){
		
		String sqlkod = "delete from Urun where urunID = " + urunID;
		int value = Baglanti.Operations(sqlkod);
		
		return value;
	}

}
