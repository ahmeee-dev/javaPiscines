package edu.ecole42.chat.models;

import java.util.List;
import java.util.Objects;

class Chatroom {
	private static int count = 0;
	private int ID;
	private User owner;
	private List<Message> messagesList;

	@Override
	public String toString() {String str = "ID: " + this.ID + ", owner: " + this.owner; return str; }

	@Override
	public int hashCode() { return (Objects.hash(this)); }

	public boolean equals(Chatroom room) {
		if (this == room || (this.ID == room.ID && 
		this.messagesList.equals(room.getMessageList()) &&
		this.owner == room.owner)) {
			return true;
		}
		return false;
	}

	public int getID() { return this.ID; }

	public User getOwner() { return this.owner; }

	public List<Message> getMessageList() { return this.messagesList; }

}