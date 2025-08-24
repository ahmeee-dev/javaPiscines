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
			if (input.equals("ls"))
				lsFunction.lsExec(path);
			else if (input.substring(0,2).equals("cd")) {
				path = path.resolve(input.substring(3)).normalize();
			}
		}
		
	}
	public void cdExec(String input, Path path) {
		
	}
}
