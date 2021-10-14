
public class module extends Information{
	private long fee = 0;
	private long total = 0;
	String s;
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public long getFee() {
		return fee;
	}
	public void setFee(long fee) {
		this.fee = fee;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	public module(String prID, String address, Integer delivery, long fee, long total, String s) {
		super(prID, address, delivery);
		this.fee = fee;
		this.total = total;
		this.s = s;
		CAL(getFee(),getTotal());
	}
	
	@Override
	public void CAL(long a, long b) {
		long c = a+b;
		setPrice(String.valueOf(c));
	}
}
