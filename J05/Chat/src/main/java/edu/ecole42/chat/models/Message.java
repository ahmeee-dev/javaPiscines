package edu.ecole42.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

class Message {

	private static int count = 0;
	private int ID;
	private User author;
	private Chatroom room;
	private String text;
	private LocalDateTime dateTime;

	public int getID() { return this.ID; }
	public User getAuthor() { return this.author; }
	public Chatroom getRoom() { return this.room; }
	public String getText() { return this.text; }
	public LocalDateTime getDateTime() { return this.dateTime; }

	@Override
	public String toString() {
		String str = "ID: " + this.ID + ", author: " + this.author + ", room: " + this.room + ", text: " + this.text + ", dateTime: " + this.dateTime;
		return str;
	}

	public boolean equals(Message mess) {
		if (mess == this || (this.author == mess.getAuthor()
		&& this.ID == mess.getID()
		&& this.room == mess.getRoom()
		&& this.text.equals(mess.getText())
		&& this.dateTime == mess.getDateTime())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() { return (Objects.hash(this)); }
}