package edu.ecole42.chat.app;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import edu.ecole42.chat.models.DBConnection;
import edu.ecole42.chat.models.Message;
import edu.ecole42.chat.repositories.MessageRepository;
import edu.ecole42.chat.repositories.MessageRepositoryImpl;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message ID:");
		int ID = scan.nextInt();
		MessageRepository msgRepo = new MessageRepositoryImpl();
		Message message = msgRepo.findByID(ID).orElseThrow(() -> (new RuntimeException("Message not found")));
		message.printDetails();
		DBConnection.shutdown();
	}

	public static String formatTime(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
		String formatted = dateTime.format(formatter);
		return formatted;
	}
}