package dataesercizi;

import java.time.*;

public class esercizio1 {

	public static void main(String[] args) {
		System.out.println("---------Esercizio: Verificare quanti giorni mancano a ferragosto--------------");
		LocalDate oggi = LocalDate.now();
		System.out.println("Oggi è : " + oggi);
		LocalDate ferragosto = LocalDate.of(2024, Month.AUGUST, 15);
		System.out.println("ferragosto: " + ferragosto);
		// specificare solo il giorno
		Duration tempoMancante = Duration.between(oggi.atStartOfDay(), ferragosto.atStartOfDay());
		Period tempoMancante1 = Period.between(oggi, ferragosto);
		System.out.println("Differenza di tempo: " + tempoMancante.toDays() + " giorni");
		System.out.println("Differenza di tempo: " + tempoMancante1.getMonths() + " mesi e " + tempoMancante1.getDays()
				+ " giorni");
		System.out.println("---------Esercizio: Aggiungere giorni di festa per il compleanno + Quanti giorni mancano al tuo compleanno----");
		LocalDate compleanno = LocalDate.of(1988, Month.OCTOBER, 13);
		System.out.println("Il mio compleanno è : " + compleanno);
		LocalDate festa = compleanno.plusDays(7);
		System.out.println("La festa del tuo compleanno durerà fino a : " + festa);
		Period giorniMancantiCompleanno = Period.between(compleanno, oggi);
		System.out.println("Al mio compleanno mancano  " + giorniMancantiCompleanno.getMonths() + " mesi "
				+ giorniMancantiCompleanno.getDays() + " giorni");

	}

}
