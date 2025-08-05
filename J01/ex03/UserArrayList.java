public class UserArrayList implements UserList {
	private User[] list = new User[10];
	private int userQuantity = 0;
	private int listSize = 10;

	public UserArrayList() {};

	public class UserNotFoundException extends RuntimeException {
		public UserNotFoundException(String message) {
			super(message);
		}
	}

	@Override public void addUser(User user) {
		if (this.listSize == this.userQuantity) {
			User[] temp = new User[(int)(this.userQuantity * 1.5)];
			for (int i = 0; i < this.userQuantity; i++)
				temp[i] = this.list[i];
			this.list = temp;
		}
		this.list[userQuantity] = user;
		this.userQuantity++;
	}

	@Override public User getUserById(int id) {
		for (int i = 0; i < this.listSize; i++) {
			if (this.list[i].getId() == id)
				return (this.list[i]);
		}
		throw new UserNotFoundException("[Error]: " + id + "  isn't in our databases");
	}

	@Override public User getUserByIndex(int index) { return (this.list[index]); };

	@Override public int getUserQuantity() { return (this.userQuantity); };
}