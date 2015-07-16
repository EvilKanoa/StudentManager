package ca.kanoa.manager.sql;

public class StudentInfo {

	private int id;
	private String parentName; 
	private String phoneNumber; 
	private String email;
	private String timezone; 
	private String location;
	private String studentClass;
	private String username;
	private int studentAge;
	private int gender;
	private String notes;
	private String studentName;
	
	public StudentInfo(int id, String parentName, String phoneNumber, String email,
			String timezone, String location, String studentClass, 
			String username, int studentAge, int gender, String notes,
			String studentName) {
		this.id = id;
		this.parentName = parentName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.timezone = timezone;
		this.location = location;
		this.studentClass = studentClass;
		this.username = username;
		this.studentAge = studentAge;
		this.gender = gender;
		this.notes = notes;
		this.studentName = studentName;
	}
	
	public int getId() {
		return id;
	}
	public String getParentName() {
		return parentName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getTimezone() {
		return timezone;
	}
	public String getLocation() {
		return location;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public String getUsername() {
		return username;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public int getGender() {
		return gender;
	}
	public String getNotes() {
		return notes;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
