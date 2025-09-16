import java.util.Scanner;

public class SchoolChart {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String str = "";
		int weekCounter = 1;
		long votes = 0;

		while (weekCounter < 18) {
			str = myScan.nextLine();
			if (str.equals("42"))
				break;
			checkWeek(str, weekCounter);
			votes += getLowestVote(myScan, weekCounter);
			weekCounter++;
		}
		System.out.println(votes);
		printStats(votes);
	}

	public static void checkWeek(String str, int weekCounter) {
		if (str.equals("Week " + weekCounter) == false) {
			System.out.println("IllegalArgument");
			System.exit(-1);
		}
	}

	public static long getLowestVote(Scanner myScan, int weekCounter) {
		int i = 1;
		int j = 0;
		long multiplier = 1;
		long lowest = 9;
		int actual = 0;

		while (i < weekCounter) {
			multiplier *= 10;
			i++;
		}
		while (j < 5) {
			actual = myScan.nextInt();
			lowest = actual < lowest ? actual : lowest;
			j++;
		}
		myScan.nextLine();
		return lowest * multiplier;
	}

	public static void printStats(long votes) {
		int weeks = 1;
		long times = 0;

		while (votes > 0) {
			System.out.print("Week " + weeks);
			times = votes % 10;
			while (times > 0) {
				System.out.print("=");
				times--;
			}
			System.out.println(">");
			votes /= 10;
			weeks++;
		}
	}
}