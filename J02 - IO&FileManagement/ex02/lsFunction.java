import java.nio.file.*;
import java.io.IOException;
import java.util.stream.*;

public final class lsFunction {
	
		public lsFunction() {
			throw new UnsupportedOperationException("This class cannot be instanciated");
		}

		public static void lsExec(Path path) {
			try {
				Stream<Path> stream = Files.list(path);
				stream.forEach(f -> {
					try {
						long size = Files.size(f) / 1024;
						System.out.println( f.toString().substring(path.toString().length()) + " " + size + " KB");
					} catch (IOException err) { System.out.print("Error: " + err.getMessage());	} 
				});
				stream.close();
			} catch (IOException err) {
				System.out.println("Error: " + err.getMessage());
			}
		}
}
