package edu.ecole42.chat.repositories;
import java.util.Optional;

import edu.ecole42.chat.models.Message;

public interface MessageRepository {
	Optional<Message>findByID(int ID);
}
