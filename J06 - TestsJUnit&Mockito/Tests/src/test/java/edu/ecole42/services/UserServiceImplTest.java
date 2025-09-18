package edu.ecole42.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import edu.ecole42.models.User;
import edu.ecole42.repositories.UserRepository;

public class UserServiceImplTest {
	
	@Test
	public void verifyIfAuthWorks() {
		UserRepository mockRepo = mock(UserRepository.class);
		when(mockRepo.findUserByLogin("Mario")).thenReturn(new User(2, "Mario", "1234"));
		User user = mockRepo.findUserByLogin("Mario");
		UserServiceImpl serviceImpl = new UserServiceImpl(mockRepo);
	
		assertEquals(true, serviceImpl.authenticate(user.getLogin(), user.getPassword()));
		assertEquals(false, serviceImpl.authenticate(user.getLogin(), user.getPassword()));

		verify(mockRepo).update(any(User.class));
	}
}
