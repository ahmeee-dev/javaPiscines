public class HenThread implements Runnable{

	private int count;
	private Object IS_BUSY;
	private Turn turn;

	public HenThread(int count, Object IS_BUSY, Turn isEggTurn) { this.count = count; this.IS_BUSY = IS_BUSY; this.turn = isEggTurn; }

	public void run() {
		for (int i = 0; i < count; i++){
			synchronized (IS_BUSY) {
				try {
					while (this.turn.isEggTurn == true)
						IS_BUSY.wait();
				} catch (InterruptedException err) { System.out.println(err.getMessage()); }
				System.out.println("Hen");
				this.turn.isEggTurn = true;
				IS_BUSY.notify();
			}
		}
	}
}
