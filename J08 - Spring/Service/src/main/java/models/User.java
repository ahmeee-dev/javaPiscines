package models;

public class User {

	private long Id;
	private String email;

	public void setId(long newId) { this.Id = newId; }
	public void setEmail(String newEmail) { this.email = newEmail; }
	public String getEmail() { return this.email; }
	public long getId() { return this.Id; }

}
