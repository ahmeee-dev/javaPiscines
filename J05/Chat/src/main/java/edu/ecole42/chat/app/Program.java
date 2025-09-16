package edu.ecole42.chat.app;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ecole42.chat.models.DBConnection;
import edu.ecole42.chat.models.User;
import edu.ecole42.chat.repositories.UserRepository;
import edu.ecole42.chat.repositories.UserRepositoryImpl;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// System.out.println("Enter a message ID:");
		// int ID = scan.nextInt();
		// MessageRepository msgRepo = new MessageRepositoryImpl();
		// Message message = msgRepo.findByID(ID).orElseThrow(() -> (new RuntimeException("Message not found")));
		//message.printDetails();
		// message.setText("carloooo");
		// msgRepo.update(message);
		List<User> userList = new ArrayList<>();
		UserRepository usrRepo = new UserRepositoryImpl(DBConnection.getDataSource());
		userList = usrRepo.findAll(0, 3);
		for (User user : userList) {
			user.printUser();
			System.out.println();
		}
		DBConnection.shutdown();
		scan.close();
	}

	public static String formatTime(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
		String formatted = dateTime.format(formatter);
		return formatted;
	}
}