package entity;

public class ChiTietHoaDon {
	private String orderID;
	private String motobike_ID;
	private int quantity;
	private double price;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(String orderID, String motobike_ID, int quantity, double price) {
		super();
		this.orderID = orderID;
		this.motobike_ID = motobike_ID;
		this.quantity = quantity;
		this.price = price;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getMotobike_ID() {
		return motobike_ID;
	}

	public void setMotobike_ID(String motobike_ID) {
		this.motobike_ID = motobike_ID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
