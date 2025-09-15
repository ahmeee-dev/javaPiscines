package edu.ecole42.chat.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import edu.ecole42.chat.exceptions.NotSavedSubEntityException;
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

		try {
			if (!userIDCheck(message.getAuthor()) || !roomIDCheck(message.getRoom()))
				throw new NotSavedSubEntityException("NOOOO!");	
		} catch (NotSavedSubEntityException err) { System.err.println("Error: " + err.getMessage()); return; }

		String sql = "INSERT INTO chat.messages (authorID, roomID, text, date) VALUES (?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Object[] params = {message.getAuthor(), message.getRoom(), message.getText(), message.getDateTime()};
			for (int i = 0; i < params.length; i++) { st.setObject(i + 1, params[i]); }
			try { if (st.executeUpdate() > 0) {
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next())
						message.setID(rs.getInt(1));
						System.out.println(message.getID());
				}
			} catch (SQLException err) { System.err.println("Error: " + err.getMessage()); }
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage());}
	};

	public boolean userIDCheck(int ID) {
		if (ID <= 0) { return false; }
		String sql = "SELECT * FROM chat.users WHERE users.ID = ?";
		try (Connection conn = DBConnection.getConnection();) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();
			return rs.next(); //true if true, false if false, as easy as it is 
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage()); return false; }
	};

	public boolean roomIDCheck(int ID) {
		if (ID <= 0) { return false; }
		String sql = "SELECT * FROM chat.chatrooms WHERE chatrooms.ID = ?";
		try (Connection conn = DBConnection.getConnection();) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();
			return (rs.next()); //true if true, false if false, as easy as it is 
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage()); return false; }
	};

}
