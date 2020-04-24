package dto;


//CREATE TABLE ORDER_TABLE(
//	SEQ NUMBER(8) PRIMARY KEY,
//	ID VARCHAR2(30) NOT NULL,
//	MENU VARCHAR2(200) NOT NULL,
//	SYRUP VARCHAR2(200),
//	CUP_SIZE VARCHAR2(200) NOT NULL,
//	SHOT VARCHAR2(200),
//	WHEEPING VARCHAR2(200),
//	CUP NUMBER(8) NOT NULL,
//	PRICE NUMBER(8) NOT NULL,
//	WDATE DATE NOT NULL
//);
//
//CREATE SEQUENCE SEQ_ORDER
//START WITH 1
//INCREMENT BY 1;
//
//ALTER TABLE ORDER_TABLE
//ADD CONSTRAINT FK_ORDER_TABLE_ID FOREIGN KEY(ID)
//REFERENCES ORDER_MEMBER(ID);
//
//

public class OrderDto {
	private int seq;
	private String id;
	private String menu;
	private String syrup;
	private String size;
	private String shot;
	private String wheeping;
	private int cup;
	private int price;
	private String wdate;
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDto(int seq, String id, String menu, 
			String syrup, String size, String shot, String wheeping,
			int cup, int price, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.menu = menu;
		this.syrup = syrup;
		this.size = size;
		this.shot = shot;
		this.wheeping = wheeping;
		this.cup = cup;
		this.price = price;
		this.wdate = wdate;
	}
	
	
	
	public OrderDto(String id, String menu, String syrup, String size, String shot, String wheeping, int cup,
			int price) {
		super();
		this.id = id;
		this.menu = menu;
		this.syrup = syrup;
		this.size = size;
		this.shot = shot;
		this.wheeping = wheeping;
		this.cup = cup;
		this.price = price;
	}

	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getSyrup() {
		return syrup;
	}
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getShot() {
		return shot;
	}
	public void setShot(String shot) {
		this.shot = shot;
	}
	public String getWheeping() {
		return wheeping;
	}
	public void setWheeping(String wheeping) {
		this.wheeping = wheeping;
	}
	public int getCup() {
		return cup;
	}
	public void setCup(int cup) {
		this.cup = cup;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "OrderDto [seq=" + seq + ", id=" + id + ", menu=" + menu + ", syrup=" + syrup + ", size=" + size
				+ ", shot=" + shot + ", wheeping=" + wheeping + ", cup=" + cup + ", price=" + price + ", wdate=" + wdate
				+ "]";
	}
	
	
	

}
