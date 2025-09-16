package edu.ecole42.chat.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import edu.ecole42.chat.models.DBConnection;
import edu.ecole42.chat.models.User;

public class UserRepositoryImpl implements  UserRepository {

	private DataSource dataSource;

    public UserRepositoryImpl(DataSource ds) { this.dataSource = ds; }

	@Override
	public List<User> findAll(int page, int size) {
			
		String sql ="""
						WITH users_chunk AS (
						SELECT * FROM chat.users
						ORDER BY id
						LIMIT ? OFFSET ?
						),
						created_rooms AS  (
						SELECT user1.id AS id, user1.login AS login, user1.password AS password, cr.ID AS chatroomID
						FROM users_chunk user1
						LEFT JOIN chat.chatrooms cr ON user1.id = cr.owner
						),
						partecipated_rooms AS (
						SELECT user1.id AS id, user1.login AS login, user1.password AS password, uc.chatroomID AS chatroomID
						FROM users_chunk user1
						JOIN chat.users_chatrooms uc ON user1.id = uc.userID
						)
						
						
						SELECT cr.id, cr.login, cr.password, cr.chatroomID, 'created' AS type
						FROM created_rooms cr
						UNION ALL
						SELECT pr.id, pr.login, pr.password, pr. chatroomID, 'partecipated' AS type
						FROM partecipated_rooms pr
						
						ORDER BY id;
					""";
		List<User> userList = new ArrayList<>();
		try (Connection conn = DBConnection.getDataSource().getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(2, page * size);
			st.setInt(1, size);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				int ID = rs.getInt("ID");
				int chatroomID = rs.getInt("chatroomID");
				int i;
				if ((i = findUserByID(userList, ID)) != -1) {
					if (rs.getString("type").equals("created") && chatroomID != 0)
						userList.get(i).addCreatedRoom(chatroomID);
					if (rs.getString("type").equals("partecipated") && chatroomID != 0)
						userList.get(i).addParticipatedRoom(chatroomID);
				} else {
					User user = new User(ID, login, password);
					if (rs.getString("type").equals("created") && chatroomID != 0)
						user.addCreatedRoom(chatroomID);
					if (rs.getString("type").equals("partecipated") && chatroomID != 0)
						user.addParticipatedRoom(chatroomID);
					userList.add(user);
				}
			}
		} catch (SQLException err) { System.err.println("Error: " + err.getMessage());}
		return (userList);						
	}

	int findUserByID(List<User> list, int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == ID)
				return i;
		}
		return -1;
	}
}
