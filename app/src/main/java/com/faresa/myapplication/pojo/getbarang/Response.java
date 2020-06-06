package com.faresa.myapplication.pojo.getbarang;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("data")
	private List<GetBarang> data;

	public String getMsg(){
		return msg;
	}

	public String getStatusCode(){
		return statusCode;
	}

	public List<GetBarang> getData(){
		return data;
	}
}