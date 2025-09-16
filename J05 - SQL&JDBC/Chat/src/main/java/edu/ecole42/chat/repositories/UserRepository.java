package edu.ecole42.chat.repositories;

import java.util.List;

import edu.ecole42.chat.models.User;

public interface UserRepository {
	public List<User> findAll(int page, int size);
}
