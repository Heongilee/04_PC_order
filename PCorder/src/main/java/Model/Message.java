package Model;

public class Message {
	private String seat;
	private String id;
	private String password;
	private String msg;
	private String type;
	private String receiveId;
	public Message() {}
	public Message(Message m_temp) {
		this.seat = m_temp.seat;
		this.id = m_temp.id;
		this.password = m_temp.password;
		this.msg = m_temp.msg;
		this.type = m_temp.type;
		this.receiveId = m_temp.receiveId;
	}
	public Message(String seat, String id, String password, String msg, String type, String receiveId) {
		this.seat = seat;
		this.id = id;
		this.password = password;
		this.msg = msg;
		this.type = type;
		this.receiveId = receiveId;
	}
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
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
		return "Message [seat=" + seat + ", id=" + id + ", password=" + password + ", msg=" + msg + ", type=" + type + ", receiveId=" + receiveId + "]";
	}
	
	
	
}
