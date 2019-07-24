package com.database;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.Siparis;

public class SiparisDAO {
	public static int AddSiparis(Siparis siparis){
		
		String tarih = siparis.getTarih();
		int userID = siparis.getUserID();
		int urunID = siparis.getUrunID();
		int urunFiyat = siparis.getUrunFiyat();
		int adet = siparis.getAdet();
		String sqlkod = "insert into Siparis(tarih, userID, urunID, urunFiyat, adet) values ('"+ tarih +"', "+ userID +","+ urunID +","+ urunFiyat +","+ adet +")";
		int value = Baglanti.Operations(sqlkod);
		
		return value;		
	}
	public static int HowMany(List<Integer> list, Integer item){
		
		return Collections.frequency(list, item);		
	}
	public static List<Integer> RemoveDuplicates(List<Integer> list){
		
		Set<Integer> hs = new HashSet<>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		
		return list;		
	}
}
