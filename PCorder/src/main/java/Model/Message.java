package Model;

public class Message {
	private String id;
	private String receive_id;
	private String password;
	private String type;
	private String msg;
	
	public Message() {
		
	}
	
	public Message(String id, String password, String receive_id, String type, String msg) {
		super();
		this.id = id;
		this.receive_id = receive_id;
		this.password = password;
		this.type = type;
		this.msg = msg;
	}

	public Message(String id, String password, String msg, String type) {
		super();
		this.id = id;
		this.password = password;
		this.msg = msg;
		this.type = type;
	}
	
	
	public String getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", password=" + password + ", type=" + type + ", msg=" + msg + "]";
	}
	
	
	
}
