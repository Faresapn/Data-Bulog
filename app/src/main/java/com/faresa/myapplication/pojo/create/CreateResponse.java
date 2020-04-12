package com.faresa.myapplication.pojo.create;

import com.google.gson.annotations.SerializedName;

public class CreateResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("data")
	private CreateData createData;

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

	public void setCreateData(CreateData createData){
		this.createData = createData;
	}

	public CreateData getCreateData(){
		return createData;
	}

	@Override
 	public String toString(){
		return 
			"CreateResponse{" + 
			"msg = '" + msg + '\'' + 
			",status_code = '" + statusCode + '\'' + 
			",data = '" + createData + '\'' +
			"}";
		}
}