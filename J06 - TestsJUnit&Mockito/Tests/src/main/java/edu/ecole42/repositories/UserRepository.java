package edu.ecole42.repositories;

import edu.ecole42.models.User;

public interface UserRepository {
	
	public User findUserByLogin(String login);
	void update(User user);
}
