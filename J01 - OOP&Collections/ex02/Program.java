
public class Program {
	public static void main(String[] args) {

			User Jam = new User("Jam", 2000);
			User Leslie = new User("Les", 500);
			UserArrayList list = new UserArrayList();

			list.addUser(Jam);
			list.addUser(Leslie);
			System.out.println(list.getUserById(1).getId());
			System.out.println(list.getUserByIndex(1).getId());
			System.out.println(list.getUserQuantity());
	}
}