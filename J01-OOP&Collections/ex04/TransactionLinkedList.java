import java.util.UUID;

public class TransactionLinkedList implements TransactionList {
	private int transactionQuantity = 0;
	Transaction firstTransaction;
	Transaction lastTransaction;

	public class TransactionNotFoundException extends RuntimeException {
		public TransactionNotFoundException(String message) {
			super(message);
		}
	}

	public TransactionLinkedList() {};

	@Override
	public void addTransaction(Transaction transaction) { 
		if (firstTransaction == null)
			this.firstTransaction = transaction;
		if (lastTransaction != null)
			this.lastTransaction.next = transaction;
		this.lastTransaction = transaction;
		this.transactionQuantity++; }

	@Override
	public void removeTransactionById(String id) {
		Transaction current = this.firstTransaction;
		Transaction prev = null;
		if (this.firstTransaction.getId().toString() == id) {
			this.firstTransaction = this.firstTransaction.next;
			return ;
		}
		while (current != null) {
			if (current.getId().toString().equals(id)) {
				prev.next = current.next;
				this.transactionQuantity--;
				return ;
			}
			prev = current;
			current = current.next;
		}
		throw new TransactionNotFoundException("[Error]: " + id + "  isn't in our databases");
	} 
	
	@Override
	public Transaction[] toArray() {
		Transaction[] array = new Transaction[this.transactionQuantity];
		Transaction current = this.firstTransaction;

		for (int i = 0; i < this.transactionQuantity; i++)  {
			array[i] = current;
			current = current.next;
		}
		return array;
	}

	
}