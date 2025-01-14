package thread;

import java.util.ArrayList;

public class NumeriDispari implements Runnable {

	ArrayList<Integer> num = new ArrayList<Integer>(20);
	Object lock = new Object();

	public NumeriDispari(Object lock, ArrayList<Integer> num) {
		this.lock = lock;
		this.num = num;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 1; i <= 10; i += 2) { // Stampa numeri dispari da 1 a 9
				System.out.println("Numero dispari: " + i);
				num.add(i);
				try {
					Thread.sleep(500); // Mette in pausa il thread per 500 millisecondi
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.notify();
				try {
					if (i < 10) {
						lock.wait();
					}

				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}
	}

}
