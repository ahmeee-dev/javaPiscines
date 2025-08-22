import java.nio.file.*;
import java.io.IOException;
import java.nio.*;
import java.util.stream.*;

public final class lsFunction {
	
		public lsFunction() {
			throw new UnsupportedOperationException("This class cannot be instanciated");
		}

		public static void lsExec() {
			try {
				Stream<Path> stream = Files.list(Paths.get(""));
				for (Path path : stream) {
					
				}
			} catch (IOException err) {
				System.out.println(err.getMessage());
			}


			
		}
		//ls ... list - size


}
