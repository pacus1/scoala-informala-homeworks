package eShop;
//use for package something like: ro.scij.pacus.eshop...

public class Address {
	
	private String streetName;
	private int streetNo;
	private String cityName;
		
	public Address(String streetName, int streetNo, String cityName) {
		this.streetName = streetName;
		this.streetNo = streetNo;
		this.cityName = cityName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
