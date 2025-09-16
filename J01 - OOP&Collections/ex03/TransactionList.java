public interface TransactionList {
	public void addTransaction(Transaction transaction);
	public void removeTransactionById(String id);
	public Transaction[] toArray();
}