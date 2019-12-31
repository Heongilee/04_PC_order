package Model;

public class Customer_DTO {
	private String cname;
	private String cpw;
	private String cnickname;
	private String cemail;
	private int cmode;
	private int cbalance;
	

	public Customer_DTO(String cname, String cpw, String cnickname, String cemail, int cmode, int cbalance) {
		super();
		this.cname = cname;
		this.cpw = cpw;
		this.cnickname = cnickname;
		this.cemail = cemail;
		this.cmode = cmode;
		this.cbalance = cbalance;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public String getCnickname() {
		return cnickname;
	}
	public void setCnickname(String cnickname) {
		this.cnickname = cnickname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public int getCmode() {
		return cmode;
	}
	public void setCmode(int cmode) {
		this.cmode = cmode;
	}
	public int getCbalance() {
		return cbalance;
	}
	public void setCbalance(int cbalance) {
		this.cbalance = cbalance;
	}	
	
	@Override
	public String toString() {
		return "Customer_DTO [cname=" + cname + ", cpw=" + cpw + ", cnickname=" + cnickname + ", cemail=" + cemail
				+ ", cmode=" + cmode + ", cbalance=" + cbalance + "]";
	}
}
