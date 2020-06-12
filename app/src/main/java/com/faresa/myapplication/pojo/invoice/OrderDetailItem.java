package com.faresa.myapplication.pojo.invoice;

import com.google.gson.annotations.SerializedName;

public class OrderDetailItem{

	@SerializedName("banyak")
	private String banyak;

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga")
	private String harga;

	@SerializedName("jumlah")
	private int jumlah;

	@SerializedName("inv_code")
	private String invCode;

	@SerializedName("kode_produk")
	private String kodeProduk;

	public void setBanyak(String banyak){
		this.banyak = banyak;
	}

	public String getBanyak(){
		return banyak;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setJumlah(int jumlah){
		this.jumlah = jumlah;
	}

	public int getJumlah(){
		return jumlah;
	}

	public void setInvCode(String invCode){
		this.invCode = invCode;
	}

	public String getInvCode(){
		return invCode;
	}

	public void setKodeProduk(String kodeProduk){
		this.kodeProduk = kodeProduk;
	}

	public String getKodeProduk(){
		return kodeProduk;
	}
}