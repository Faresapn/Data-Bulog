package com.faresa.myapplication.pojo.invoice;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("invoices")
	private Invoices invoices;

	@SerializedName("order_detail")
	private List<OrderDetailItem> orderDetail;

	public void setInvoices(Invoices invoices){
		this.invoices = invoices;
	}

	public Invoices getInvoices(){
		return invoices;
	}

	public void setOrderDetail(List<OrderDetailItem> orderDetail){
		this.orderDetail = orderDetail;
	}

	public List<OrderDetailItem> getOrderDetail(){
		return orderDetail;
	}
}