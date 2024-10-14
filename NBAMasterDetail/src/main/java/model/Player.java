package model;

public class Player {
    public String id;
    public String firstName;
    public String lastName;
    public String position;
    public String dateOfBirth;
    public String headShotUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getHeadShotUrl() {
		return headShotUrl;
	}
	public void setHeadShotUrl(String headShotUrl) {
		this.headShotUrl = headShotUrl;
	}

}
