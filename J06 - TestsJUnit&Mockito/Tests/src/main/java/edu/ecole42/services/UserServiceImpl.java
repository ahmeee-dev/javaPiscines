package edu.ecole42.services;

import edu.ecole42.exceptions.AlreadyAuthenticatedException;
import edu.ecole42.models.User;
import edu.ecole42.repositories.UserRepository;

public class UserServiceImpl {
	
	private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) { this.repo = repo; }

	public boolean authenticate(String login, String password) {

		try {
			User user = repo.findUserByLogin(login);
			if (user.getAuthStatus() != false) {
				throw new AlreadyAuthenticatedException("User already authenticated"); }
			if (user.getPassword().equals(password)) {
				user.setAuthStatus(true);
				repo.update(user);
				return true;
			}
		} catch (AlreadyAuthenticatedException err) { System.err.println("Error: " + err.getMessage());}
		return false;
	}


	
}