import java.util.UUID;

public class TransactionsService {

	private UserList userList;

	public void addUser( String name, int balance ) {
		User user = new User(name, balance);
		userList.addUser(user);
	}

	public int getBalance(int id) {
		User user = userList.getUserByIndex(id);
		return (user.getBalance());
	}

	public void makeTransaction(int recipientId, int senderId, int amount) {
		User recipient = userList.getUserById(recipientId);
		User sender = userList.getUserById(senderId);
		Transaction transaction = new Transaction(recipient, senderId, 0, amount);
		Transaction transactionCopy = transaction.transactionCopy(newTransaction);
		recipient.getArrayList().addTransaction(transaction);
		sender.getArrayList().addTransaction(transactionCopy);
	}

	public removeTransaction(long transactionId, int userId) {
		userList.getUserById(userId).getTransactionLinkedList().removeTransactionById("" + transactionId);
	}

	public Transaction[] getTransactionArray(int id) {
		return (userList.getUserById(id).getTransactionLinkedList().toArray());
	}
}

