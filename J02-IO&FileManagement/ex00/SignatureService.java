import java.io.IOException;
import java.util.* ;

public class SignatureService {
	private FileStreamManager fsm;

	public SignatureService() {
		
		Scanner myScan = new Scanner(System.in);
		while (true){
			String inputFile = myScan.nextLine();
			if (inputFile.equals("42")) {
				myScan.close();
				System.exit(0);
			}
			this.fsm = new FileStreamManager(inputFile, "/Users/ahmed/Desktop/java_piscines/J02/ex00/signatures.txt");
			ArrayList<Byte> bytes = readFile();
			String result = checkSignature(bytes);
			if (result != null) {
				try {
					System.out.println(result);
					fsm.getOutput().write(result + System.lineSeparator());
					System.out.println("PROCESSED");
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
				}
			} else {
				System.out.println("UNDEFINED");
			}
			try {
				fsm.getInput().close();
			} catch (IOException err) {
				System.out.println("Error: " + err.getMessage());
			}
			try {
				fsm.getOutput().close();
			} catch (IOException err) {
				System.out.println("Error: " + err.getMessage());
			}
		}
	}

	public ArrayList<Byte> readFile(){
		int iterations = 0;
		ArrayList<Byte> arr = new ArrayList<Byte>();
		while (iterations++ < 12) {
			try {
				arr.add((byte) this.fsm.getInput().read());
			} catch (IOException error) {
				System.out.println("Error: " + error.getMessage());
			}
		}
		return (arr);
	}

	public String checkSignature(ArrayList<Byte> arr) {
		for (String i : SignatureRetriever.getSignatureMap().keySet()) {
			List<Byte> list = SignatureRetriever.getSignatureMap().get(i);
			int j = 0;
			while ( j < list.size() && j < arr.size() && list.get(j) == arr.get(j))
				j++;
			if (j == list.size())
				return i;
		}
		return null;
	}
}