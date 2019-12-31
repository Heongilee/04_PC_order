package Model;

public class Customer_DTO {
	private String cname;
	private String cpw;
	private String cnickname;
	private String cemail;
	
	public Customer_DTO(String cname, String cpw, String cnickname, String cemail) {
		super();
		this.cname = cname;						// 아이디
		this.cpw = cpw;							// 패스워드
		this.cnickname = cnickname;				// 닉네임
		this.cemail = cemail;					// 이메일
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
	
	@Override
	public String toString() {
		return "Customer_DTO [cname=" + cname + ", cpw=" + cpw + ", cnickname=" + cnickname + ", cemail=" + cemail
				+ "]";
	}
	
}
