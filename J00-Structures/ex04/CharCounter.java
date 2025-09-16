import java.util.Scanner;

public class CharCounter {
	public static void main(String[] args) {
		int[] charsCounter;
		String text = "";
		char[] charsInText;
		Scanner myScan = new Scanner(System.in);
		charsCounter = new int[65535];
		text = myScan.nextLine();
		charsInText = text.toCharArray();

		for (int i = 0; i < text.length(); i++) {
			charsCounter[charsInText[i] - 1]++;
		}
		printHistogram(charsCounter);
	}

	public static void printHistogram(int[] charsCounter) {

		int highestCount = getHighestCount(charsCounter);
		float divider = (float)highestCount / 10f;
		int[] topChartLetters = new int[10];
		int[] topChartLetterCount = new int[10];
		int chartPosition = 0;

		for (int j = highestCount; j >= 0; j--) {
			for (int i = 0; i < 65535; i++) {
				if (chartPosition < 10 && charsCounter[i] == j) {
					topChartLetters[chartPosition] = i + 1;
					topChartLetterCount[chartPosition] = charsCounter[i];
					chartPosition++;
				}
			}
		}

		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				if ((int)((float)topChartLetterCount[j] / divider) - i == 0) {
					if (topChartLetterCount[j] < 10)
						System.out.print(" ");
					System.out.print( topChartLetterCount[j] + " ");
				} else if ((int)((float)topChartLetterCount[j] / divider) > i)
					System.out.print(" # ");
				else
					System.out.print("   ");
			}
			System.out.println(" ");
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(" "+ (char)topChartLetters[i] + " ");
		}
	}

	public static int getHighestCount(int[] charsCounter) {
		int highestCount = 0;
		for (int i = 0; i < 65535; i++) {
			if (charsCounter[i] > highestCount)
				highestCount = charsCounter[i];
		}
		return highestCount;
	}
}