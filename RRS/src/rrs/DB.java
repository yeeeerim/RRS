package rrs;

import java.util.ArrayList;

public class DB {
	private ArrayList<Customer> customer=null;
	private ArrayList<Restaurant> restaurant=null;
	private ArrayList<Reservation_Info> reservation=null;
	
	public DB() {
		customer=new ArrayList<>(0);
		restaurant=new ArrayList<>(0);
		reservation=new ArrayList<>(0);
		
		 // 이미 가입된 고객들
		customer.add(new Customer("01012345678","5678","yerim"));
		customer.add(new Customer("01011112222","3333","jiyoon"));
		customer.add(new Customer("0","0","0"));
		
		 // 매니저 로그인 정보
		customer.add(new Customer("manager1","manager1","manager"));
		
		 // 이미 저장된 음식점들
		Restaurant r1 = new Restaurant("pizza");
		r1.addFood(new Food("original",5000,10));
		r1.addFood(new Food("potato",8000,15));
		r1.addFood(new Food("bulgogi",10000,20));
		Restaurant r2 = new Restaurant("pasta");
		r2.addFood(new Food("cream",10000,15));
		r2.addFood(new Food("tomato",10000,15));
		restaurant.add(r1);
		restaurant.add(r2);
	}
	
	public boolean searchCustomer(String phoneNumber){
		for(int i=0; i<customer.size();i++) {
			if(customer.get(i).getPhoneNumber().equals(phoneNumber)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isExist(String id, String pw){
		for(int i=0; i<customer.size();i++) {
			if(customer.get(i).getPhoneNumber().equals(id) && customer.get(i).getPassword().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	
	public void addCustomer(Customer customer) {
		this.customer.add(customer);
	}
	
	public void addRestaurant(Restaurant restaurant) {
		this.restaurant.add(restaurant);
	}
	
	public void addReservation(Reservation_Info r) {
		this.reservation.add(r);
	}
	
	public ArrayList<Reservation_Info> searchMyReservation(String phoneNumber) {
		ArrayList<Reservation_Info> arr = new ArrayList<>();
		for(int i=0; i<reservation.size();i++) {
			if(reservation.get(i).getCustomerPhoneNumber().equals(phoneNumber)) {
				arr.add(reservation.get(i));
			}
		}
		return arr;
	}
	
	public void deleteReservation(int reservationNumber) {
		for(int i=0; i<reservation.size();i++) {
			if(reservation.get(i).getReservationNumber()==reservationNumber) {
				reservation.remove(i);
				break;
			}
		}
	}
	
	public void deleteRestaurant(String restaurantName) {
		for(int i=0; i<restaurant.size();i++) {
			if(restaurant.get(i).getName().equals(restaurantName)) {
				restaurant.remove(i);
				break;
			}
		}
	}
	
	public Restaurant getRestaurant(String restaurant) {
		for(int i=0; i<this.restaurant.size();i++) {
			if(this.restaurant.get(i).getName().equals(restaurant))
				return this.restaurant.get(i);
		}
		return null;
	}
	
	public ArrayList<Restaurant> getRestaurantList(){
		return restaurant;
	}
}
