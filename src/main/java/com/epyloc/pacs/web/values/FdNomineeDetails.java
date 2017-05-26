package com.epyloc.pacs.web.values;

public class FdNomineeDetails {

	private String firstName;
	private String lastName;
	private String relationship;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String pincode;
	private String aadharId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FdNomineeDetails [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", relationship=");
		builder.append(relationship);
		builder.append(", addressOne=");
		builder.append(addressOne);
		builder.append(", addressTwo=");
		builder.append(addressTwo);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append(", aadharId=");
		builder.append(aadharId);
		builder.append("]");
		return builder.toString();
	}

}
