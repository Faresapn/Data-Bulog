package com.faresa.myapplication.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataItem implements Parcelable {

	@SerializedName("provinsi")
	private String provinsi;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("kota")
	private String kota;

	@SerializedName("ktp")
	private String ktp;

	@SerializedName("npwp")
	private String npwp;

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
	private long telfon;

	@SerializedName("username")
	private String username;

	@SerializedName("dc")
	private String dc;

	@SerializedName("status")
	private String status;


	protected DataItem(Parcel in) {
		provinsi = in.readString();
		keterangan = in.readString();
		kota = in.readString();
		ktp = in.readString();
		npwp = in.readString();
		toko = in.readString();
		createdAt = in.readString();
		kategori = in.readString();
		bulogId = in.readInt();
		kelurahan = in.readString();
		alamat = in.readString();
		updatedAt = in.readString();
		entitas = in.readString();
		kecamatan = in.readString();
		pemilik = in.readString();
		telfon = in.readLong();
		username = in.readString();
		dc = in.readString();
		status = in.readString();
	}

	public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
		@Override
		public DataItem createFromParcel(Parcel in) {
			return new DataItem(in);
		}

		@Override
		public DataItem[] newArray(int size) {
			return new DataItem[size];
		}
	};

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

	public void setNpwp(String npwp){
		this.npwp = npwp;
	}

	public String getNpwp(){
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

	public void setTelfon(long telfon){
		this.telfon = telfon;
	}

	public long getTelfon(){
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
			"DataItem{" + 
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


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(provinsi);
		dest.writeString(keterangan);
		dest.writeString(kota);
		dest.writeString(ktp);
		dest.writeString(npwp);
		dest.writeString(toko);
		dest.writeString(createdAt);
		dest.writeString(kategori);
		dest.writeInt(bulogId);
		dest.writeString(kelurahan);
		dest.writeString(alamat);
		dest.writeString(updatedAt);
		dest.writeString(entitas);
		dest.writeString(kecamatan);
		dest.writeString(pemilik);
		dest.writeLong(telfon);
		dest.writeString(username);
		dest.writeString(dc);
		dest.writeString(status);
	}
}