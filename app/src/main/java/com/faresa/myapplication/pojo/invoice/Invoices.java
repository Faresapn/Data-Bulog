package com.faresa.myapplication.pojo.invoice;

import com.google.gson.annotations.SerializedName;

public class Invoices{

	@SerializedName("note")
	private String note;

	@SerializedName("jumlah")
	private int jumlah;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("inv_code")
	private String invCode;

	@SerializedName("kasir")
	private String kasir;

	@SerializedName("invoices_id")
	private int invoicesId;

	@SerializedName("bayar")
	private String bayar;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("kembali")
	private int kembali;

	@SerializedName("diskon")
	private String diskon;

	@SerializedName("customer")
	private String customer;

	public void setNote(String note){
		this.note = note;
	}

	public String getNote(){
		return note;
	}

	public void setJumlah(int jumlah){
		this.jumlah = jumlah;
	}

	public int getJumlah(){
		return jumlah;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setInvCode(String invCode){
		this.invCode = invCode;
	}

	public String getInvCode(){
		return invCode;
	}

	public void setKasir(String kasir){
		this.kasir = kasir;
	}

	public String getKasir(){
		return kasir;
	}

	public void setInvoicesId(int invoicesId){
		this.invoicesId = invoicesId;
	}

	public int getInvoicesId(){
		return invoicesId;
	}

	public void setBayar(String bayar){
		this.bayar = bayar;
	}

	public String getBayar(){
		return bayar;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setKembali(int kembali){
		this.kembali = kembali;
	}

	public int getKembali(){
		return kembali;
	}

	public void setDiskon(String diskon){
		this.diskon = diskon;
	}

	public String getDiskon(){
		return diskon;
	}

	public void setCustomer(String customer){
		this.customer = customer;
	}

	public String getCustomer(){
		return customer;
	}
}