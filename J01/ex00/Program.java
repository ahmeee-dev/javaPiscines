
public class Program {
	public static void main(String[] args) {

			User Jam = new User("Jam", 2000);
			User Leslie = new User("Les", 500);
			Transaction makeUp = new Transaction(Leslie, Jam, true, 600);

			System.out.println(makeUp.getAmount());
			//System.out.println(makeUp.getSender().getName());
			System.out.println(Leslie.getBalance());
			System.out.println(Jam.getBalance());
			System.out.println(Jam.getName());
			System.out.println(Jam.getId());
			System.out.println(Leslie.getId());
			System.out.println(makeUp.getId());
	}
}