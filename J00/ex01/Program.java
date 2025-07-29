import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);

		//System.out.println("Time to enter your number, is it going to be prime?");
		final int number = myScan.nextInt();

		if (number <= 1){
			System.err.println("IllegalArgument");
			System.exit(-1);
		}

		int iterations = 0;
		int paragon = 2;
		while (paragon * paragon < number) {
			iterations++;
			if ((number % paragon) == 0) {
				System.out.println("true " + iterations);
				System.exit(0);
			}
			paragon++;
		}
		System.out.println("false " + iterations);
	}
}