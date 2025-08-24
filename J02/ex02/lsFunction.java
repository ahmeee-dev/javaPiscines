import java.nio.file.*;
import java.io.IOException;
import java.util.stream.*;

public final class lsFunction {
	
		public lsFunction() {
			throw new UnsupportedOperationException("This class cannot be instanciated");
		}

		public static void lsExec() {
			try {
				Stream<Path> stream = Files.list(Paths.get(""));
				stream.forEach(f -> {
					try {
						long size = Files.size(f) / 1024;
						System.out.println( f + " " + size + " KB");
					} catch (IOException err) { System.out.print(err.getMessage());	} 
				});
				stream.close();
			} catch (IOException err) {
				System.out.println(err.getMessage());
			}
		}
}
