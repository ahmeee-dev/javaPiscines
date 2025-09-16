package edu.ecole42.chat.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

import edu.ecole42.chat.app.Program;

public class Message {

	private int ID;
	private int authorID;
	private int roomID;
	private String text;
	private LocalDateTime dateTime;

	public Message(int ID, int authorID, int room, String text, LocalDateTime dateTime) {
		this.ID = ID;
		this.authorID = authorID;
		this.roomID = room;
		this.text = text;
		this.dateTime = dateTime;
	}

	public void printDetails() {

		String userSQL = "SELECT * FROM chat.users WHERE users.ID = ?";
		String roomSQL = "SELECT * FROM chat.chatrooms WHERE chatrooms.ID = ?";
		try (Connection conn = DBConnection.getConnection(); ) {
			PreparedStatement userSt = conn.prepareStatement(userSQL);
			PreparedStatement roomSt = conn.prepareStatement(roomSQL);
			userSt.setInt(1, authorID);
			roomSt.setInt(1, roomID);
			
			try {
				ResultSet roomRs = roomSt.executeQuery();
				ResultSet userRs = userSt.executeQuery();
				userRs.next();
				roomRs.next();
				System.out.println("message: {");
				System.out.println("id=" + ID + ",");
				System.out.println("author={id=" + userRs.getInt("ID") + ",login=\"" + userRs.getString("login") + "\",password=\"" + userRs.getString("password") + ",createdRooms=null,rooms=null},");
				System.out.println("room={id=" + roomRs.getInt("ID") + ",name=\"" + roomRs.getString("name") + ",creator=null,messages=null},");
				System.out.println("text=\"" + text + "\",");
				System.out.println("dateTime=" + Program.formatTime(dateTime));
				System.out.println("}");
			} catch (SQLException err) { System.err.println(err.getMessage()); }
		
		} catch (SQLException err) { System.out.println(err.getMessage()); }
	}

	public void setAuthor(int ID) { this.authorID = ID; }
	public void setRoom(int ID) { this.roomID = ID; }
	public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
	public void setText(String text) { this.text = text; }
	public void setID(int ID) { this.ID = ID;}
	public int getID() { return this.ID; }
	public int getAuthor() { return this.authorID; }
	public int getRoom() { return this.roomID; }
	public String getText() { return this.text; }
	public LocalDateTime getDateTime() { return this.dateTime; }

	@Override
	public String toString() {
		String str = "ID: " + this.ID + ", author: " + this.authorID + ", room: " + this.roomID + ", text: " + this.text + ", dateTime: " + this.dateTime;
		return str;
	}

	public boolean equals(Message mess) {
		if (mess == this || (this.authorID == mess.getAuthor()
		&& this.ID == mess.getID()
		&& this.roomID == mess.getRoom()
		&& this.text.equals(mess.getText())
		&& this.dateTime == mess.getDateTime())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() { return (Objects.hash(this)); }
}