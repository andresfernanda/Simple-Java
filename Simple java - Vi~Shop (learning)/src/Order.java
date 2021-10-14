
public class Order {

	private String ID;
	private Boolean status;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Order(String iD, Boolean status) {
		super();
		ID = iD;
		this.status = status;
	}
	
	public void view() {
		String temp = this.status ?"On-Going": "Failed";
		System.out.println("Shipping ID"+ this.ID);		
		System.out.println("Shipping Status" + temp );
		if(!this.status) {
			System.out.println("Sowwy ur packet cant be traced");
		}
	}

}
