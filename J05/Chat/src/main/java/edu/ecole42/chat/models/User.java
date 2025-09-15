package edu.ecole42.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

	public static int userCount = 0;
	private int ID;
	private String login;
	private String password;
	private List<Chatroom> createdRooms;
	private List<Chatroom> partecipatedRooms; 

	public User(int ID, String login, String password, List<Chatroom> createdRooms, List <Chatroom> partecipatedRooms) {
		this.ID = ID;
		this.login = login;
		this.password = password;
		this.createdRooms = createdRooms;
		this.partecipatedRooms = partecipatedRooms;
	}

	public boolean equals(User user) {
		if (this == user || (this.login.equals(user.getLogin())
		&& this.password.equals(user.getPassword())
		&& this.ID == getID())) {
				return true;
		}
		return false;
	}

	@Override
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