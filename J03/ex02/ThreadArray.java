
public class ThreadArray implements Runnable {

	int[] array;
	int size;
	static int sum;
	public int count;
	int threadCount;
	
	public ThreadArray(int[] arr, int size, int threadCount) { this.array = arr; this.size = size; this.threadCount = threadCount; };

	@Override
	public void run() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			synchronized (this) {
				this.count += this.array[i];
				ThreadArray.sum += this.array[i];
			}
		}
		System.out.println("Thread "+ this.threadCount + " Sum = " + this.count);
	}

	public int getSum() {
		return (count);
	}
}
