package repositories;

import java.util.Optional;

import models.User;

public interface  UserRepository extends CrudRepository<User> {
	
	Optional<User> findByEmail(String toFind);
}
