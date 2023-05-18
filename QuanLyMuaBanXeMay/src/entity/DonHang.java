package entity;

import java.sql.Date;
import java.util.ArrayList;

public class DonHang {
	private String order_id;
	private Date order_Date;
	private String customer_id;
	private String staff_id;
	private ArrayList<Motobike> listSanPham;
	private double orderAmount;
	private String status;
	private String note;

	public DonHang() {
	}

	public DonHang(String order_id, Date order_Date, String customer_id, String staff_id,
			ArrayList<Motobike> listSanPham, double orderAmount, String status, String note) {
		this.order_id = order_id;
		this.order_Date = order_Date;
		this.customer_id = customer_id;
		this.staff_id = staff_id;
		this.listSanPham = listSanPham;
		this.orderAmount = orderAmount;
		this.status = status;
		this.note = note;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public ArrayList<Motobike> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(ArrayList<Motobike> listSanPham) {
		this.listSanPham = listSanPham;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
