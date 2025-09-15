package edu.ecole42.chat.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import edu.ecole42.chat.models.DBConnection;
import edu.ecole42.chat.models.Message;


public class MessageRepositoryImpl implements MessageRepository {
	
	@Override
	public Optional<Message>findByID(int ID) {
		String sql = "SELECT * FROM chat.messages WHERE messages.ID = ?";
		try (Connection conn = DBConnection.getConnection();) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, ID);

			try { 
				ResultSet rs = st.executeQuery();
				rs.next();
				Message message = new Message(
					rs.getInt("ID"),
					rs.getInt("authorID"),
					rs.getInt("roomID"),
					rs.getString("text"),
					rs.getTimestamp("date").toLocalDateTime()
				);
				return Optional.ofNullable(message);
			} catch (SQLException err) {
				System.out.println(err.getMessage());
				return (Optional.empty());
			}
		} catch (SQLException err) {
			System.out.println(err.getMessage());
			return (Optional.empty());
		}
	};

	@Override
	public void save(Message message) {

		//first: check if roomID or authorID is null

		String roomIDcheck = "SELECT * FROM chat.chatrooms WHERE chatrooms.ID = ?";

		String sql = "INSERT INTO chat.messages (id, authorID, roomID, text, date) VALUES ?, ?, ?, ?, ?";
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Object[] params = {message.getID(), message.getAuthor(), message.getRoom(), message.getText(), message.getDateTime()};
			for (int i = 0; i < params.length; i++) { st.setObject(i + 1, params[i]); }
			try { ResultSet rs = st.executeQuery();
				if (rs.next())
					message.setID(rs.getInt(1));

			} catch (SQLException err) { System.err.println("Error: " + err.getMessage()); }
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage());}
	};

	public boolean userIDCheck(int ID) {
		String sql = "SELECT * FROM chat.users WHERE users.ID = ?";
		try (Connection conn = DBConnection.getConnection();) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;
			else
				throw new SQLException("Undefined userID '" + ID + "' in chat table"); //update the Exception with yours;
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage()); return false; }
	};

	public boolean roomIDCheck(int ID) {
		String sql = "SELECT * FROM chat.chatrooms WHERE chatrooms.ID = ?";
		try (Connection conn = DBConnection.getConnection();) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;
			else
				throw new SQLException("Undefined chatroomID '" + ID + "' in chat table"); //update the Exception with yours;
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage()); return false; }
	};

}
