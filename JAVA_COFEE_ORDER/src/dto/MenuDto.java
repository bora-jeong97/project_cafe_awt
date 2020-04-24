package dto;

//CREATE TABLE MENU_TABLE(
//SEQ NUMBER(8) PRIMARY KEY,
//Menu VARCHAR(40) NOT NULL,
//SHORT_PRICE NUMBER(8) NOT NULL,
//TALL_PRICE NUMBER(8) NOT NULL,
//GRANDE_PIRCE NUMBER(8) NOT NULL
//);

public class MenuDto {

	private int seq;
	private String menu;
	private int shortSize;
	private int tallSize;
	private int GrandeSize;

	public MenuDto() {
		// TODO Auto-generated constructor stub
	}

	public MenuDto(int seq, String menu, int shortSize, int tallSize, int grandeSize) {
		super();
		this.seq = seq;
		this.menu = menu;
		this.shortSize = shortSize;
		this.tallSize = tallSize;
		GrandeSize = grandeSize;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getShortSize() {
		return shortSize;
	}

	public void setShortSize(int shortSize) {
		this.shortSize = shortSize;
	}

	public int getTallSize() {
		return tallSize;
	}

	public void setTallSize(int tallSize) {
		this.tallSize = tallSize;
	}

	public int getGrandeSize() {
		return GrandeSize;
	}

	public void setGrandeSize(int grandeSize) {
		GrandeSize = grandeSize;
	}

	@Override
	public String toString() {
		return "MenuDto [seq=" + seq + ", menu=" + menu + ", shortSize=" + shortSize + ", tallSize=" + tallSize
				+ ", GrandeSize=" + GrandeSize + "]";
	}

	
	
	
}
