package com.faresa.myapplication.pojo.invoice;

import com.google.gson.annotations.SerializedName;

public class InvoiceResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("data")
	private Data data;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setStatusCode(String statusCode){
		this.statusCode = statusCode;
	}

	public String getStatusCode(){
		return statusCode;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}
}