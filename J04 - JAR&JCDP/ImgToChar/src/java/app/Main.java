package app;
import logic.*;
import java.awt.image.*;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;
import com.diogonunes.jcolor.*;
import com.beust.jcommander.Parameters;
import javax.imageio.ImageIO;

class Main {

	@Parameters(names = {"--white"}, description = "Color white substitute");
	private char white;

	@Parameters(names = {"--black"}, description = "Color Black substitute");
	private char black;

	public static void main(String[] args) {
		
		if (args.length != 1 || !args[0].endsWith(".bmp")) {
			throw new IllegalArgumentException("Illegal Argument"); }

		Main main = new Main();
		JCommander.newBuilder().addObject(main).build().parse(args);
		File file;
		
		try {
			file = new File(args[0]);
			BufferedImage img = ImageIO.read(file);
			Interpoler interpoler = new Interpoler(img, main.black, main.white);
			interpoler.print();
		} catch (Exception err) { err.printStackTrace();System.exit(2); }
	}
}