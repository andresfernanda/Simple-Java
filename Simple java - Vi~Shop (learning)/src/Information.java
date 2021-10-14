
public abstract class Information {
	
	private String prID = "";
	private String Address = "";
	private Integer Delivery;
	private String Price = "";
	private String status = "";
	private String type = "";
	//ongkir 0 berarti VeDex, ongkir 1 berarti ViCepat
	public abstract void CAL(long a, long b);
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDelivery() {
		return Delivery;
	}
	public void setDelivery(Integer delivery) {
		this.Delivery = delivery;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getPrID() {
		return prID;
	}
	public void setPrID(String prID) {
		this.prID = prID;
	}
	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		this.Price = price;
	}

	public Information(String prID, String address, Integer delivery) {
		super();
		this.prID = prID;
		this.Address = address;
		this.Delivery = delivery;

	}
}
