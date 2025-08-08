import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class FrequencyAnalyzer {

	private Vector<Integer> vectorA;
	private Vector<Integer> vectorB;
	private ArrayList<String> dictorionary = new ArrayList<String>();

	public FrequencyAnalyzer(String toRead, String toWrite) {
	
		FileStream fs = new FileStream(toRead, toWrite);
		BufferedReader reader1 = fs.getReader1();
		BufferedReader reader2 = fs.getReader2();
		BufferedWriter writer = fs.getWriter();

		populateDictionary(reader1, reader2);
		fs.restartReaders();
		reader1 = fs.getReader1();
		reader2 = fs.getReader2();
		this.vectorA = new Vector<Integer>(this.dictorionary.size());
		this.vectorB = new Vector<Integer>(this.dictorionary.size());


		
	}

	public void populateVectors(BufferedReader reader1, BufferedReader reader2) {
		String line = getLine(reader1);
		while (line != null) {
			String[] splitLine = line.split(" ");
			handleLineVec(splitLine, this.vectorA);
		}
		line = getLine(reader2);
		while (line != null) {
			String[] splitLine  = line.split(" ");
			handleLineVec(splitLine, this.vectorB);
		}
	}

	public void handleLineVec(String[] splitLine, Vector<Integer> vector) {
		for (int i = 0; i < splitLine.length; i++) {
			for (int j = 0; j < this.dictorionary.size(); j++) {
				if (splitLine[i].equals(this.dictorionary.get(i))) {
					vector.set(i, vector.get(i) + 1);
				}
			}
		}
	}

	public void populateDictionary(BufferedReader reader1, BufferedReader reader2) {
		String line = getLine(reader1);
		while (line != null) {
			String[] splitLine = line.split(" ");
			handleLineDict(splitLine);
		}
		line = getLine(reader2);
		while (line != null) {
			String[] splitLine  = line.split(" ");
			handleLineDict(splitLine);
		}
	}

	public void handleLineDict(String[] splitLine) {
		for (int i = 0; i < splitLine.length; i++) {
			for (int j = 0; j < this.dictorionary.size(); j++) {
				if (splitLine[i].equals(this.dictorionary.get(i))) {
					break;
				}
				if (i + 1 == this.dictorionary.size())
					dictorionary.add(splitLine[i]);
			}
			if (this.dictorionary.size() == 0)
			dictorionary.add(splitLine[i]);
		}
	}


	public String getLine(BufferedReader reader) {
		try {
			return reader.readLine();
		} catch (IOException err) {
			System.out.println(err.getMessage());
			return null;
		}
	}
}
