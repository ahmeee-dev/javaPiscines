package edu.ecole42.chat.repositories;
import java.util.Optional;

import edu.ecole42.chat.models.Message;

public interface MessageRepository {
	public Optional<Message>findByID(int ID);
	public void save(Message message);
	public void update(Message message);
}
