public interface UserList {
	void addUser(User user);
	User getUserById(int id);
	User getUserByIndex(int index);
	int getUserQuantity();
}