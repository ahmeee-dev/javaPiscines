
import java.util.*;
import java.io.IOException;



public class Main {
	public static void main(String[] args) {
		int arraySize = Integer.parseInt(args[0].substring(12, args[0].length()));
		int threadsCount = Integer.parseInt(args[1].substring(15, args[1].length()));
		int threadSize = arraySize / threadsCount;
		List<Thread> threasList = new ArrayList<>();
		
		try {
			if (arraySize > 2000000)
				throw new IllegalArgumentException(); 
		}catch ( IllegalArgumentException err) { System.out.println("Error: Array Size cannot exceed 2.000.000"); System.exit(2);}

		try {
			if (threadsCount > arraySize)
				throw new IllegalArgumentException();
		} catch ( IllegalArgumentException err) { System.out.println("Error: Threads' Count cannot exceed Array size for logical reason"); System.exit(2);}

		Random rand = new Random();
		int[] array = new int[arraySize];

		//assign value
		for (int i = 0; i < arraySize; i++) {
			array[i] = rand.nextInt(1001);
		};

		for (int j = 0; j < threadsCount; j++) {
			ThreadArray threadArray;
			if ( j == threadsCount - 1) {
				threadArray = new ThreadArray(Arrays.copyOfRange(array, threadSize * j, threadSize * (j + 1) + arraySize % threadsCount), threadSize + arraySize % threadsCount, j + 1);
			}	else
				threadArray = new ThreadArray(Arrays.copyOfRange(array, threadSize * j, threadSize * (j + 1)), threadSize, j + 1);
			Thread thread = new Thread(threadArray);
			
			threasList.add(thread);
			thread.start();
		}

		for (Thread t : threasList) {
			try { t.join(); } catch (Exception err) { System.out.println("Errore: " + err.getMessage());}
		}
		System.out.println("Total sum = " + ThreadArray.sum);
		
	}
}
