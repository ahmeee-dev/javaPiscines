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

import javax.imageio.ImageIO;

// reads input BMP file, returns an ArrayList<int> with the content of the file
class Main {

	public static void main(String[] args) {
		
		if (args.length != 1 || !args[0].endsWith(".bmp")) {
			throw new IllegalArgumentException(); };

		final char white = ' ';
		final char black = '0';
		File file;
		
		try {
			file = new File(args[0]);
			BufferedImage img = ImageIO.read(file);
			Interpoler interpoler = new Interpoler(img, black, white);
			interpoler.print();
		} catch (Exception err) { err.printStackTrace();System.exit(2); }
	}
}