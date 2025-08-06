
public class Program {
	public static void main(String[] args) {

			User Jam = new User("Jam", 2000);
			User Leslie = new User("Les", 5000);
			User Mauro = new User("Mauro", 1000);
			User Fernando = new User("Fernando", 1500);
			User Jorge = new User("Jorge", 2000);
			UserArrayList list = new UserArrayList();
			Transaction lesMauro = new Transaction(Leslie, Mauro, true, 600);
			Transaction mauroFernando = new Transaction(Mauro, Fernando, true, 600);
			Transaction fernandoJorge = new Transaction(Fernando, Jorge, true, 600);
			Transaction jorgeLeslie = new Transaction(Jorge, Leslie, true, 600);
			TransactionLinkedList list2 = new TransactionLinkedList(lesMauro);

			list2.addTransaction(mauroFernando);
			list2.addTransaction(fernandoJorge);
			list2.addTransaction(jorgeLeslie);
			//list2.removeTransactionById(fernandoJorge.getId().toString());
			Transaction[] array = list2.toArray();
			Transaction current = list2.firstTransaction;
			while (current != null) {
				System.out.println(current.getSender().getName() + " sent " + current.getAmount() + " to " + current.getRecipient().getName());
				current = current.next;
			}
			System.out.println("----------");
			for (int i = 0; i < array.length; i++)
				System.out.println(array[i].getSender().getName() + " sent " + array[i].getAmount() + " to " + array[i].getRecipient().getName());
		
	}
}