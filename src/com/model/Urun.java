package com.model;

public class Urun {
	private int urunID;
	private int kategoriID;
	private int turID;
	private String beden;
	private int fiyat;
	
	public int getUrunID() {
		return urunID;
	}
	public void setUrunID(int urunID) {
		this.urunID = urunID;
	}
	public int getKategoriID() {
		return kategoriID;
	}
	public void setKategoriID(int kategoriID) {
		this.kategoriID = kategoriID;
	}
	public int getTurID() {
		return turID;
	}
	public void setTurID(int turID) {
		this.turID = turID;
	}
	public String getBeden() {
		return beden;
	}
	public void setBeden(String beden) {
		this.beden = beden;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

}
