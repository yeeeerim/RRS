package rrs;

import java.util.ArrayList;

public class Restaurant {
	private String name = null;
	private ArrayList<Food> food = new ArrayList<>();
	
	public Restaurant(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public Food getFood(String name) {
		for(int i=0; i<food.size();i++) {
			if(food.get(i).getName()==name) {
				return food.get(i);
			}
		}
		return null;
	}
	
	public void addFood(Food f) {
		food.add(f);
	}
	
	public void deleteFood(String name) {
		for(int i=0; i<food.size();i++) {
			if(food.get(i).getName()==name) {
				food.remove(i); break;
			}
		}
	}
	
	public ArrayList<Food> getFoodList(){
		return food;
	}
}
