import java.util.UUID;

public class Transaction {

	private long id = UUID.randomUUID().getMostSignificantBits();
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
		if (category == true) {
			if (sender.getBalance() < amount)
				throw new IllegalArgumentException("Not enough funds");
			sender.touchBalance(amount * -1);				
		}
		recipient.touchBalance(amount);
	}

	public Transaction transactionCopy(Transaction toCopy) {
		if (toCopy.getCategory() == true)
			boolean category = false;
		else
			boolean category = true;
		Transaction newTransaction = newTransaction(toCopy.getRecipient(), toCopy.getSender(), category, toCopy.getAmount() * -1);
		newTransaction.setId(toCopy.getId());
		return newTransaction;
	}

	public User getRecipient() {
		return this.recipient;
	}
	
	public void setId(long id) {
		this.id = id;
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

	public long getId() {
		return this.id;
	}
}