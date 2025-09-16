public class HenThread implements Runnable{

	private int count;

	public HenThread(int count) { this.count = count; }

	public void run() {
		for (int i = 0; i < count; i++)
			System.out.println("Hen");
	}
}
