import java.util.Scanner;

public class QueryManager {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		
		int counter = 0;

		while (true) {
		int query = myScan.nextInt();
			if (query == 42) {
				System.out.println(counter + "coffee related queries");
				System.exit(0);
			}
			else if (primeCheck(query) == true)
				counter++;
		}

	}

	public static boolean primeCheck(int number) {
		if (number <= 1){
			System.err.println("IllegalArgument");
			System.exit(-1);
		}

		int paragon = 2;
		while (paragon * paragon < number) {
			if ((number % paragon) == 0) {
				return (false);
			}
			paragon++;
		}
		return (true);
	}
}