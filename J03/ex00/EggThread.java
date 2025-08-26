
public class EggThread implements Runnable {

	private int count;

	public EggThread(int count) { this.count = count; }
	public void run() {
		for (int i = 0; i < count; i++)
			System.out.println("Egg");
	}
}
