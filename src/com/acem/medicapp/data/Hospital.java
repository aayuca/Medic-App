package com.acem.medicapp.data;

public class Hospital {
	int id;
	String name;
	String description;
	int beds;
	String emergency;
	String district;
	String street;
	String longitude;
	String latitude;
	String phoneno;
	String estd;

	public Hospital(int id, String name, String description, int beds, String emergency, String district, String street,
			String longitude, String latitude, String phoneno, String estd) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.beds = beds;
		this.emergency = emergency;
		this.district = district;
		this.street = street;
		this.longitude = longitude;
		this.latitude = latitude;
		this.phoneno = phoneno;
		this.estd = estd;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEstd() {
		return estd;
	}

	public void setEstd(String estd) {
		this.estd = estd;
	}
}
