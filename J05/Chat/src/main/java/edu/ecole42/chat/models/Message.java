package edu.ecole42.chat.models;

import java.time.*;

class Message {

	private static int count = 0;
	private int ID;
	private User author;
	private Chatroom room;
	private String text;
	private LocalDateTime dateTime;
}