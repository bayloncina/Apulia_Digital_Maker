package thread;
//programma che stampi numeri pari e dispari con i thread

import java.util.ArrayList;

public class NumeriPari implements Runnable {
	
	
	ArrayList<Integer> num = new ArrayList<Integer>(20);
	Object lock = new Object();
	
	public NumeriPari(Object lock, ArrayList<Integer> num) {
		this.lock = lock;
		this.num = num;
	}

	@Override
		public void run() {
		synchronized (lock) {
	        for (int i = 0; i <= 10; i += 2) { // Stampa numeri pari da 0 a 10
	            System.out.println("Numero pari: " + i);
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
	            }catch(InterruptedException e) {
	            	
	            	e.printStackTrace();
	            }
	            }

			}
		}
		}
