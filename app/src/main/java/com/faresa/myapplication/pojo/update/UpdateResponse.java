package com.faresa.myapplication.pojo.update;

import com.google.gson.annotations.SerializedName;

public class UpdateResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("data")
	private UpdateData updateData;

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

	public void setUpdateData(UpdateData updateData){
		this.updateData = updateData;
	}

	public UpdateData getUpdateData(){
		return updateData;
	}

	@Override
 	public String toString(){
		return 
			"UpdateResponse{" + 
			"msg = '" + msg + '\'' + 
			",status_code = '" + statusCode + '\'' + 
			",data = '" + updateData + '\'' +
			"}";
		}
}