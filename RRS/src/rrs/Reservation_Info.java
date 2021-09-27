package rrs;

public class Reservation_Info {
	private String customerPhoneNumber=null;
	private String restaurantName="";
	private int[] food_cnt=null;
	private int now_or_later=0;
	private int day=0;
	private int time=0;
	private int reservationNumber=0;
	public Reservation_Info() {};
	
	public void setDay(int d) {
		this.day=d;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setFood_cnt(int[] food_cnt) {
		this.food_cnt = food_cnt;
	}

	public void setNow_or_later(int now_or_later) {
		this.now_or_later = now_or_later;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public int getNowOrLater() {
		return now_or_later;
	}
	public int getTime() {
		return time;
	}
	public int getReservationNumber() {
		return reservationNumber;
	}
}
