package edu.ecole42.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

	public static int userCount = 0;
	private int ID;
	private String login;
	private String password;
	private List<Integer> createdRooms;
	private List<Integer> partecipatedRooms; 

	public User(int ID, String login, String password) {
		this.ID = ID;
		this.login = login;
		this.password = password;
		this.createdRooms = new ArrayList<Integer>();
		this.partecipatedRooms = new ArrayList<Integer>();
	}

	public void printUser() {
		System.out.println("ID: " + this.ID);
		System.out.println("login: " + this.login);
		System.out.println("password: " + this.password);
		System.out.print("created rooms: ");
		for (int id : this.createdRooms) {
			System.out.print(id + " ");
		}
		System.out.println();
		System.out.print("participated rooms: ");
		for (int id : this.partecipatedRooms) {
			System.out.println(id + " ");
		}
		System.out.println();
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

	public void addCreatedRoom(int roomID) { this.createdRooms.add(roomID); }
	public void addParticipatedRoom(int roomID) { this.partecipatedRooms.add(roomID);} 
	public int getID() { return this.ID; }
	public String getLogin() { return this.login; }
	public String getPassword() { return this.password; }




} 