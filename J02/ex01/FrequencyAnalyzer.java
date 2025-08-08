import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class FrequencyAnalyzer {

	private Vector<Integer> vectorA;
	private Vector<Integer> vectorB;
	private ArrayList<String> dictorionary = new ArrayList<String>();

	public FrequencyAnalyzer(String toRead1, String toRead2) {
	
		FileStream fs = new FileStream(toRead1, toRead2);
		BufferedReader reader1 = fs.getReader1();
		BufferedReader reader2 = fs.getReader2();
		BufferedWriter writer = fs.getWriter();

		populateDictionary(reader1, reader2);
		fs.restartReaders();
		reader1 = fs.getReader1();
		reader2 = fs.getReader2();
		initializeVectors();
		populateVectors(reader1, reader2);
		float cos = calculateCosineSimilarity();
		try { writer.write(cos + ""); writer.flush(); } catch (IOException err) { System.out.println(err.getMessage()); }
		System.out.print("Similarity = " + cos + "");
		
	}

	public float calculateCosineSimilarity() {
	
		float cos = 0f;
		int nominator = 0;
		float denominator = 0f;
		float tempD = 0f;
		for (int i = 0; i < this.vectorA.size(); i++) {
			tempD += Math.pow((double)this.vectorA.get(i), (double)2);
		}
		denominator = (float)Math.sqrt((double)tempD);
		tempD = 0f;
		for (int i = 0; i < this.vectorB.size(); i++) {
			tempD += Math.pow((double)this.vectorB.get(i), (double)2);
		}
		denominator *= (float)Math.sqrt((double)tempD);

		for (int i = 0; i < this.vectorA.size(); i++) {
			nominator += this.vectorA.get(i) * this.vectorB.get(i); 
		}
		cos = nominator/denominator;

		return cos;
	}

	public void initializeVectors() {
		this.vectorA = new Vector<Integer>(this.dictorionary.size());
		this.vectorB = new Vector<Integer>(this.dictorionary.size());
		for (int i = 0; i < this.dictorionary.size(); i++ ) {
			this.vectorA.add(i, 0);
		}
		for (int i = 0; i < this.dictorionary.size(); i++ ) {
			this.vectorB.add(i, 0);
		}
	}

	public void populateVectors(BufferedReader reader1, BufferedReader reader2) {
		String line = getLine(reader1);
		while (line != null) {
			String[] splitLine = line.split(" ");
			handleLineVec(splitLine, this.vectorA);
			line = getLine(reader1);
		}
		line = getLine(reader2);
		while (line != null) {
			String[] splitLine  = line.split(" ");
			handleLineVec(splitLine, this.vectorB);
			line = getLine(reader2);
		}
	}

	public void handleLineVec(String[] splitLine, Vector<Integer> vector) {
		for (int i = 0; i < splitLine.length; i++) {
			for (int j = 0; j < this.dictorionary.size(); j++) {
				if (splitLine[i].equals(this.dictorionary.get(j))) {
					vector.set(j, vector.get(j) + 1);
				}
			}
		}
	}

	public void populateDictionary(BufferedReader reader1, BufferedReader reader2) {
		String line = getLine(reader1);
		while (line != null) {
			String[] splitLine = line.split(" ");
			handleLineDict(splitLine);
			line = getLine(reader1);
		}
		line = getLine(reader2);
		while (line != null) {
			String[] splitLine  = line.split(" ");
			handleLineDict(splitLine);
			line = getLine(reader2);
		}
	}

	public void handleLineDict(String[] splitLine) {
		for (int i = 0; i < splitLine.length; i++) {
			for (int j = 0; j < this.dictorionary.size(); j++) {
				if (splitLine[i].equals(this.dictorionary.get(j))) {
					break;
				}
				if (j + 1 == this.dictorionary.size())
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
