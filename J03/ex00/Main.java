import javax.print.DocFlavor.INPUT_STREAM;

public class Main {
	public static void main(String[] args) {
		int count = Integer.parseInt(args[0].substring(8));
		EggThread egg = new EggThread(count);
		Thread eggThread = new Thread(egg);
		HenThread hen = new HenThread(count);
		Thread henThread = new Thread(hen);

		henThread.start();
		eggThread.start();
		for (int i = 0; i < count; i++)
			System.out.println("Human");
		
	}

}
