package com.faresa.myapplication.pojo.update;

import com.google.gson.annotations.SerializedName;
public class UpdateData {

	@SerializedName("provinsi")
	private String provinsi;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("kota")
	private String kota;

	@SerializedName("ktp")
	private String ktp;

	@SerializedName("npwp")
	private Object npwp;

	@SerializedName("toko")
	private String toko;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("kategori")
	private String kategori;

	@SerializedName("bulog_id")
	private int bulogId;

	@SerializedName("kelurahan")
	private String kelurahan;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("entitas")
	private String entitas;

	@SerializedName("kecamatan")
	private String kecamatan;

	@SerializedName("pemilik")
	private String pemilik;

	@SerializedName("telfon")
	private String telfon;

	@SerializedName("username")
	private String username;

	@SerializedName("dc")
	private String dc;

	@SerializedName("status")
	private String status;

	public void setProvinsi(String provinsi){
		this.provinsi = provinsi;
	}

	public String getProvinsi(){
		return provinsi;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setKota(String kota){
		this.kota = kota;
	}

	public String getKota(){
		return kota;
	}

	public void setKtp(String ktp){
		this.ktp = ktp;
	}

	public String getKtp(){
		return ktp;
	}

	public void setNpwp(Object npwp){
		this.npwp = npwp;
	}

	public Object getNpwp(){
		return npwp;
	}

	public void setToko(String toko){
		this.toko = toko;
	}

	public String getToko(){
		return toko;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setKategori(String kategori){
		this.kategori = kategori;
	}

	public String getKategori(){
		return kategori;
	}

	public void setBulogId(int bulogId){
		this.bulogId = bulogId;
	}

	public int getBulogId(){
		return bulogId;
	}

	public void setKelurahan(String kelurahan){
		this.kelurahan = kelurahan;
	}

	public String getKelurahan(){
		return kelurahan;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setEntitas(String entitas){
		this.entitas = entitas;
	}

	public String getEntitas(){
		return entitas;
	}

	public void setKecamatan(String kecamatan){
		this.kecamatan = kecamatan;
	}

	public String getKecamatan(){
		return kecamatan;
	}

	public void setPemilik(String pemilik){
		this.pemilik = pemilik;
	}

	public String getPemilik(){
		return pemilik;
	}

	public void setTelfon(String telfon){
		this.telfon = telfon;
	}

	public String getTelfon(){
		return telfon;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setDc(String dc){
		this.dc = dc;
	}

	public String getDc(){
		return dc;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"provinsi = '" + provinsi + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
			",kota = '" + kota + '\'' + 
			",ktp = '" + ktp + '\'' + 
			",npwp = '" + npwp + '\'' + 
			",toko = '" + toko + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",kategori = '" + kategori + '\'' + 
			",bulog_id = '" + bulogId + '\'' + 
			",kelurahan = '" + kelurahan + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",entitas = '" + entitas + '\'' + 
			",kecamatan = '" + kecamatan + '\'' + 
			",pemilik = '" + pemilik + '\'' + 
			",telfon = '" + telfon + '\'' + 
			",username = '" + username + '\'' + 
			",dc = '" + dc + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}