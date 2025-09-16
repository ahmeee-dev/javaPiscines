import java.util.UUID;

public class User {
	private final long ID = UUID.randomUUID().getMostSignificantBits();
	private String name;
	private int balance;

	public User (String name, int balance) {
		this.name = name;
		if (balance < 0)
			throw new IllegalArgumentException("Balance must not be Negative");
		this.balance = balance;
	}

	public void touchBalance(int amount) {
		this.balance += amount;
	}

	public int getBalance() {
		return this.balance;
	}

	public long getId() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}
}