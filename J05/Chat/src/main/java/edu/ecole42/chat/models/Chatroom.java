package edu.ecole42.chat.models;

import java.util.List;

class Chatroom {
	private static int count = 0;
	private int ID;
	private User owner;
	private List<Message> messagesList;
}