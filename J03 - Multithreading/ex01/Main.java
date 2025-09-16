import javax.print.DocFlavor.INPUT_STREAM;

public class Main {
	public static void main(String[] args) {
		int count = 0;
		Object IS_BUSY = new Object();
		Turn isEggTurn = new Turn();

		try {
			if (args[0].length() < 8) 
				throw (new IllegalArgumentException());
			count = Integer.parseInt(args[0].substring(8));
		} catch (IllegalArgumentException err) { System.out.println("Error: wrong argument"); };
		EggThread egg = new EggThread(count, IS_BUSY, isEggTurn);
		Thread eggThread = new Thread(egg);
		HenThread hen = new HenThread(count, IS_BUSY, isEggTurn);
		Thread henThread = new Thread(hen);

		henThread.start();
		eggThread.start();
		//synchronized (IS_BUSY) { IS_BUSY.notify(); }
		//for (int i = 0; i < count; i++)
			//System.out.println("Human");
		
	}

}
