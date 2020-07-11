package dto;
/*
 	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(30) NOT NULL,
	BEVERAGES VARCHAR2(20),
	CSIZE VARCHAR2(20),
	SYRUP VARCHAR2(20),
	SHOT VARCHAR2(20),
	WHIP VARCHAR2(20)
 */
public class OrderDTO {
	private int seq;
	private String id;
	private String beverages;
	private String csize;
	private String syrup;
	private String shot;
	private String whip;
	private int cup;
	private int price;
	private String date;
	
	
	public OrderDTO() {
	
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


	public String getBeverages() {
		return beverages;
	}


	public void setBeverages(String beverages) {
		this.beverages = beverages;
	}


	public String getCsize() {
		return csize;
	}


	public void setCsize(String csize) {
		this.csize = csize;
	}


	public String getSyrup() {
		return syrup;
	}


	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}


	public String getShot() {
		return shot;
	}


	public void setShot(String shot) {
		this.shot = shot;
	}


	public String getWhip() {
		return whip;
	}


	public void setWhip(String whip) {
		this.whip = whip;
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public OrderDTO(int seq, String id, String beverages, String csize, String syrup, String shot, String whip, int cup,
			int price, String date) {
		super();
		this.seq = seq;
		this.id = id;
		this.beverages = beverages;
		this.csize = csize;
		this.syrup = syrup;
		this.shot = shot;
		this.whip = whip;
		this.cup = cup;
		this.price = price;
		this.date = date;
	}
	
	public OrderDTO( String id, String beverages, String csize, String syrup, String shot, String whip, int cup,
			int price, String date) {
		super();
		this.id = id;
		this.beverages = beverages;
		this.csize = csize;
		this.syrup = syrup;
		this.shot = shot;
		this.whip = whip;
		this.cup = cup;
		this.price = price;
		this.date = date;
	}
	
	


	@Override
	public String toString() {
		return "OrderDTO [seq=" + seq + ", id=" + id + ", beverages=" + beverages + ", csize=" + csize + ", syrup="
				+ syrup + ", shot=" + shot + ", whip=" + whip + ", cup=" + cup + ", price=" + price + ", date=" + date
				+ "]";
	}

	
	
	
}
