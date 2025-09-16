package logic;
import java.awt.image.*;

public class Interpoler {
	private final BufferedImage image;
	private final char black;
	private final char white;

	public Interpoler(BufferedImage img, char black, char white) { this.image = img; this.black = black; this.white = white; }

	public void print() {
		try {
			for (int y = 0; y < this.image.getHeight(); y++) {
				System.out.println();
				for (int x = 0; x < this.image.getWidth(); x++) {
					if (this.image.getRGB(x, y) == java.awt.Color.WHITE.getRGB()) {
						System.out.print(this.white);
					} else if (this.image.getRGB(x, y) == java.awt.Color.BLACK.getRGB()) {
						System.out.print(this.black);
					} else { System.out.print("x"); }
					//else {
					//	throw new Exception("Unexpected color in file"); 
					//};
				}
			} System.out.println();
		} catch (Exception err) { System.out.println("Error: " + err.getMessage()); }
	}
		
}
