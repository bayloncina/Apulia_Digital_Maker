package thread;

import java.util.ArrayList;

public class EsercizioLambdaMain {
	public static void main(String[] args) {
	ArrayList<Integer> insiemNum = new ArrayList<Integer>(20);
	Object lock = new Object();

	Runnable rDispari = () -> {
		synchronized (lock) {
			for (int i = 1; i <= 10; i += 2) { // Stampa numeri dispari da 1 a 9
				System.out.println("Numero dispari: " + i);
				insiemNum.add(i);
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
	};

	Runnable rPari = () -> {
		synchronized (lock) {
			for (int i = 0; i <= 10; i += 2) { // Stampa numeri pari da 0 a 10
				System.out.println("Numero pari: " + i);
				insiemNum.add(i);
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
	};
	Thread numeriPari = new Thread(rPari);
	Thread numeriDispari = new Thread(rDispari);
	numeriPari.start();
	numeriDispari.start();

}

}
