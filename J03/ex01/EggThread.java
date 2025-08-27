
public class EggThread implements Runnable {

	private int count;
	private Object IS_BUSY;
	Turn turn;

	public EggThread(int count, Object IS_BUSY, Turn isEggTurn) { this.count = count; this.IS_BUSY = IS_BUSY; this.turn = isEggTurn; }
	public void run() {
		for (int i = 0; i < count; i++) {
			synchronized (IS_BUSY) {
				try { 
					while (this.turn.isEggTurn == false)
						IS_BUSY.wait();
				} catch (InterruptedException err) { System.out.println(err.getMessage()); }
				System.out.println("Egg");
				this.turn.isEggTurn = false;
				IS_BUSY.notify();
			}
		}
	}
}
