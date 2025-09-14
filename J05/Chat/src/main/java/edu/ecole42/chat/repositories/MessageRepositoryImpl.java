package edu.ecole42.chat.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import edu.ecole42.chat.models.DBConnection;
import edu.ecole42.chat.models.Message;


public class MessageRepositoryImpl {
	public Optional<Message>findByID(int ID) {
		String sql = "SELECT * FROM Chat.messages WHERE messages.ID = ?";
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
				return Optional.of(message);
			} catch (SQLException err) {
				System.out.println(err.getMessage());
				return (null);
			}
		} catch (SQLException err) {
			System.out.println(err.getMessage());
			return (null);
		}
	};
}
