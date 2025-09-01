import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;

public class Main {
	static int fileCount = 0;
	

	public static void main(String[] args) {
		int threadCount = Integer.parseInt(args[0].substring(15, args[0].length()));
	
		ArrayList<String> urls = new ArrayList<>();
		File myFile;
		Scanner fileReader;
		try { myFile = new File("file_urls.txt");
			fileReader = new Scanner(myFile);
			while (fileReader.hasNextLine()) {
				urls.add(fileReader.nextLine());
			}
		} catch (FileNotFoundException err) { System.out.println("Error: " + err.getMessage()); System.exit(2);}

		String[] array =  urls.toArray(new String[0]);
		ArrayList<Thread> threadsArrayList = new ArrayList<>();
		for (int i = 0; i < threadCount; i++) {
			DownloadThread downloadThread = new DownloadThread(array, i + 1);
			Thread thread = new Thread(downloadThread);
			thread.start();
			threadsArrayList.add(thread);
		}
		for (Thread t : threadsArrayList) {
			try { t.join(); } catch (InterruptedException err) { System.out.println("Error: " + err.getMessage()); };
		}
	}
}
