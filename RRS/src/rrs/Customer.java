package rrs;

public class Customer {
	private String phoneNumber=null;
	private String password=null;
	private String name=null;
	
	public Customer(String phoneNumber, String password, String name){
		this.phoneNumber=phoneNumber;
		this.password=password;
		this.name=name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
}
