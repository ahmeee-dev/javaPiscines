package edu.ecole42.models;

public class User {
	
	private int id;
	private String login;
	private String password;
	private boolean authStatus = false;

	public User(int id, String login, String password) { this.id = id; this.login = login; this.password = password; }

    public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getLogin() { return this.login; }
	public void setLogin(String login) { this.login = login;}

	public String getPassword() { return this.password; }
	public void setPassowrd(String password) { this.password = password; }

	public boolean getAuthStatus() { return this.authStatus; }
	public void setAuthStatus(boolean status) { this.authStatus = status; }
}
