import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;


public class DownloadThread implements Runnable {

	private String[] urls;
	private int threadNumber;

	DownloadThread(String[] urls, int threadNumber) { this.urls = urls; this.threadNumber = threadNumber; };

	public void run() {
		
		while (true) {
			try {
				URL stringUrl;
				int fileNumber;
				synchronized (this) {
					if (Main.fileCount == urls.length)
					 	return;
					stringUrl = new URL(this.urls[Main.fileCount]);
					Main.fileCount++;
					fileNumber = Main.fileCount;
					System.out.println("Thread-" + this.threadNumber + " started downloading File-" + Main.fileCount);
				}
					ReadableByteChannel rbc = Channels.newChannel(stringUrl.openStream());
					FileOutputStream fos = new FileOutputStream("downloads/file" + fileNumber);
					FileChannel fc = fos.getChannel();
					fc.transferFrom(rbc, 0, Long.MAX_VALUE);
					System.out.println("Thread-" + this.threadNumber + " finished downloading File-" + fileNumber);
			} catch (Exception err) { System.out.println("Error: " + err.getMessage()); System.exit(2);}
		}
	};
}
