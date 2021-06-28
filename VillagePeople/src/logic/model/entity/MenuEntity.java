package logic.model.entity;

public class MenuEntity{
	private String menu1;
	private String menu2;
	private String menu3;
	private String statoMenu = "Non comunicato";

		
	public String getMenu1() {
		return menu1;
	}
	
	public void setMenu1(String menu1) {
		this.menu1 = menu1;
	}
		
	public String getMenu2() {
		return menu2;
	}
	
	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}
		
	public String getMenu3() {
		return menu3;
	}
	
	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}
	
	public String getStatoMenu() {
		return statoMenu;
	}
	
	public void setStatoMenu(String statoMenu) {
		this.statoMenu = statoMenu;
	}

}
