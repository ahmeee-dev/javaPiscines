import java.io.*;

public class FileStreamManager {
	private FileInputStream fileInput;
	private FileWriter fileOutput;

	public FileStreamManager(String input, String output) {
		if (input != null) {
			try {
				this.fileInput = new FileInputStream(input);
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
		}
		if (output != null) {
			try {
				this.fileOutput = new FileWriter(output);
			} catch (IOException e) {
				System.out.println("File not found");
			}
		}
	}

	public FileInputStream getInput() { return this.fileInput; }

	public FileWriter getOutput() { return this.fileOutput; }
}