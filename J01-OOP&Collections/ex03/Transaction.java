import java.util.UUID;

public class Transaction {

	private final UUID id = UUID.randomUUID();
	private User recipient;
	private User sender;
	private boolean category; //0 debits, 1 credits
	private int amount;
	Transaction next;

	public Transaction (User recipient, User sender, boolean category, int amount) {
		this.recipient = recipient;
		this.sender = sender;
		this.category = category;
		this.amount = amount;
		if (category == true && sender.getBalance() < amount)
			throw new IllegalArgumentException("Not enough funds");

		if (category == false && amount >= 0)
			throw new IllegalArgumentException("Wrong Format: Debits have negative amounts");

		sender.touchBalance(amount * -1);
		recipient.touchBalance(amount);

	}

	public User getRecipient() {
		return this.recipient;
	}
	
	public User getSender() {
		return this.sender;
	}

	public boolean getCategory() {
		return this.category;
	}

	public int getAmount() {
		return this.amount;
	}

	public UUID getId() {
		return this.id;
	}
}