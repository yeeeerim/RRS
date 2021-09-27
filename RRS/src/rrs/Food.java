package rrs;

public class Food {
	private String name=null;
	private int price=0;
	private int cookTime=0;
	
	public Food(String name, int price, int cookTime){
		this.name=name;
		this.price=price;
		this.cookTime=cookTime;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCookTime() {
		return cookTime;
	}
}
