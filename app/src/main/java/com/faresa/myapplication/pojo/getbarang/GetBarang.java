package com.faresa.myapplication.pojo.getbarang;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GetBarang implements Parcelable {

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public void setBarangId(int barangId) {
		this.barangId = barangId;
	}

	public void setKodeProduk(int kodeProduk) {
		this.kodeProduk = kodeProduk;
	}

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga")
	private int harga;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("stok")
	private int stok;

	@SerializedName("barang_id")
	private int barangId;

	@SerializedName("kode_produk")
	private int kodeProduk;
	public GetBarang() {
	}
	protected GetBarang(Parcel in) {
		this.keterangan = in.readString();
		this.nama = in.readString();
		this.harga = in.readInt();
		this.updatedAt = in.readString();
		this.createdAt = in.readString();
		this.stok = in.readInt();
		this.barangId = in.readInt();
		this.kodeProduk = in.readInt();
	}

	public static final Creator<GetBarang> CREATOR = new Creator<GetBarang>() {
		@Override
		public GetBarang createFromParcel(Parcel in) {
			return new GetBarang(in);
		}

		@Override
		public GetBarang[] newArray(int size) {
			return new GetBarang[size];
		}
	};

	public String getKeterangan(){
		return keterangan;
	}

	public String getNama(){
		return nama;
	}

	public int getHarga(){
		return harga;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getStok(){
		return stok;
	}

	public int getBarangId(){
		return barangId;
	}

	public int getKodeProduk(){
		return kodeProduk;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.keterangan);
		dest.writeString(this.nama);
		dest.writeInt(this.harga);
		dest.writeString(this.updatedAt);
		dest.writeString(this.createdAt);
		dest.writeInt(this.stok);
		dest.writeInt(this.barangId);
		dest.writeInt(this.kodeProduk);
	}
}