import java.util.UUID;

public class User {
	private final int ID = UserIdGenerator.getIntance().generateId();
	private String name;
	private int balance;
	private TransactionList transactionList = new TransactionLinkedList();

	public User (String name, int balance) {
		this.name = name;
		if (balance < 0)
			throw new IllegalArgumentException("Balance must not be Negative");
		this.balance = balance;
	}

	public void getTransactionList() { return this.transactionList; }
	public void touchBalance(int amount) {
		this.balance += amount;
	}

	public int getBalance() {
		return this.balance;
	}

	public int getId() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}
}