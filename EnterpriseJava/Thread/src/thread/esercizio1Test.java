package thread;

import java.util.ArrayList;

public class esercizio1Test {

	public static void main(String[] args) {
		
		ArrayList <Integer> insiemNum = new ArrayList<Integer>(20);
		Object lock = new Object();
		Thread numeriPari = new Thread(new NumeriPari(lock, insiemNum));
        Thread numeriDispari = new Thread(new NumeriDispari(lock, insiemNum));
		
        numeriPari.start();
        numeriDispari.start();
	}

}
