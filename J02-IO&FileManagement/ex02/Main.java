import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.*;

public class Main {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		Path path = Paths.get(args[0].substring(17));
		while (true) {
			String input = myScan.nextLine();
			if (input.length() < 2)
				continue;
			else if (input.equals("ls"))
				lsFunction.lsExec(path);
			else if (input.substring(0,2).equals("cd")) {
				path = path.resolve(input.substring(3)).normalize();
			}
			else if (input.substring(0, 2).equals("mv")) {
				int index = input.indexOf(" ", 3);
				Path source = Paths.get(input.substring(3, index));
				source = path.resolve(source).normalize();
				Path dest = Paths.get(input.substring(index + 1));
				dest = path.resolve(dest).normalize();
				try {
					if (Files.isDirectory(dest)) {
						dest = dest.resolve(source.getFileName());
					}
					Files.move(source, dest);
				} catch (IOException err) { System.out.println("Error: " + err.getMessage()); }
			}
			else if (input.equals("exit")){
				myScan.close();
				System.exit(0);
			}
		}
		
	}
}
