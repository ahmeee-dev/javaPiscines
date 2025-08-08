import java.io.*;

public class FileStream {
	
	private String file1;
	private String file2;
	private BufferedReader toRead1;
	private BufferedReader toRead2;
	private BufferedWriter toWrite;
	
	public FileStream(String toRead1, String toRead2) {
		file1 = toRead1;
		file2 = toRead2;

		try {
			this.toRead1 = new BufferedReader(new FileReader(toRead1));
		} catch (IOException err) { System.out.println(err.getMessage()); }

		try {
			this.toRead2 = new BufferedReader(new FileReader(toRead2));
		} catch (IOException err) { System.out.println( err.getMessage()); }

		try {
			this.toWrite = new BufferedWriter(new FileWriter("/Users/ahmed/Desktop/java_piscines/J02/ex01/dictionary.txt"));
		} catch (IOException err) { System.out.println( err.getMessage()); }
 	}

	public BufferedReader getReader1() { return this.toRead1; }
	public BufferedReader getReader2() { return this.toRead2; }
	public BufferedWriter getWriter() { return this.toWrite; }
	public void restartReaders() {

		try {
			this.toRead1.close();
		} catch (IOException err) {
			System.out.println(err.getMessage());
		}
		
		try {
			this.toRead2.close();
		} catch (IOException err) {
			System.out.println(err.getMessage());
		}

		try {
			this.toRead1 = new BufferedReader(new FileReader(this.file1));
		} catch (IOException err) { System.out.println(err.getMessage()); }

		try {
			this.toRead2 = new BufferedReader(new FileReader(this.file2));
		} catch (IOException err) { System.out.println( err.getMessage()); }
	}

}