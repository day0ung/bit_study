package dto;

/*
  CREATE TABLE COFFEELIST(
	BEVERAGES VARCHAR2(30),
	SHORT NUMBER(10),
	TALL NUMBER(10),
	GRANDE NUMBER(10)
)
 */
public class MenuDTO {
	private String Beverages;
	private int Short;
	private int Tall;
	private int Grande;
	
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(String beverages, int s, int tall, int grande) {
		super();
		Beverages = beverages;
		Short = s;
		Tall = tall;
		Grande = grande;
	}

	public String getBeverages() {
		return Beverages;
	}

	public void setBeverages(String beverages) {
		Beverages = beverages;
	}

	public int getShort() {
		return Short;
	}

	public void setShort(int s) {
		Short = s;
	}

	public int getTall() {
		return Tall;
	}

	public void setTall(int tall) {
		Tall = tall;
	}

	public int getGrande() {
		return Grande;
	}

	public void setGrande(int grande) {
		Grande = grande;
	}

	@Override
	public String toString() {
		return "MenuDTO [Beverages=" + Beverages + ", Short=" + Short + ", Tall=" + Tall + ", Grande=" + Grande + "]";
	}
	
	
}
