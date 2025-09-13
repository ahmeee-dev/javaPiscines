package edu.ecole42.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

	public static int userCount = 0;
	private int ID;
	private String login;
	private String password;
	private List<Chatroom> created_rooms;
	private List<Chatroom> partecipant_rooms; 


	public boolean equals(User user) {
		if (this == user || (this.login.equals(user.getLogin()) &&
				this.password.equals(user.getPassword()) &&
				this.ID == getID())) {
				return true;
		}
		return false;
	}

	public String toString() {
		String str = "ID: " + this.ID + ", login: " + this.login + " passowrd: " + this.password;
		return str;
	}

	@Override
	public int hashCode() { return (Objects.hash(this.login, this.password)); }

	public int getID() { return this.ID; }
	public String getLogin() { return this.login; }
	public String getPassword() { return this.password; }

	


} 