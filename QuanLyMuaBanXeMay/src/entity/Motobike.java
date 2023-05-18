package entity;

public class Motobike {
	private String id;
	private String name;
	private String manufacturer;
	private float capacity;
	private String color;
	private MotoType type;
	private double price;
	private int quantity;
	private int year;

	public Motobike() {
		super();
	}

	public Motobike(String id, String name, String manufacturer, float capacity, String color, MotoType type,
			double price, int quantity, int year) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.capacity = capacity;
		this.color = color;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public MotoType getType() {
		return type;
	}

	public void setType(MotoType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Motobike [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", capacity=" + capacity
				+ ", color=" + color + ", type=" + type + ", price=" + price + ", quantity=" + quantity + ", year="
				+ year + "]";
	}

}

