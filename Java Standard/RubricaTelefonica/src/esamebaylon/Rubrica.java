package esamebaylon;

import java.util.ArrayList;

public class Rubrica {

	private ArrayList<Contatto> contatti;

	public Rubrica() {
		this.contatti = new ArrayList<Contatto>();

	}

	public void aggiungiContatto(Contatto contatto) {
		contatti.add(contatto);

	}

	public void rimuoviContatto(String nome, String cognome) {

		for (Contatto contatto : contatti) {
			if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
				contatti.remove(contatto);
				return;
			}
		}
		System.out.println("Contatto con nome " + nome + " e cognome " + cognome + " non trovato.");

	}
	public void cercaNumero(String nome, String cognome) {
	    for (int i = 0; i < contatti.size(); i++) {
	        Contatto contatto = contatti.get(i);
	        if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
	            System.out.println(contatto.getNome() + " " + contatto.getCognome() + " " + contatto.getNumero());
	            return;
	        }
	    }
	    System.out.println("Contatto con nome " + nome + " e cognome " + cognome + " non trovato.");
	}
	
	public String toString() {
	    if (contatti.isEmpty()) {
	        return "La rubrica è vuota.";
	    }
	    StringBuilder sb = new StringBuilder();
	    sb.append("Rubrica:\n");

	    for (Contatto contatto : contatti) {
	        sb.append(contatto).append("\n");
	    }

	    return sb.toString();
	}

		// TODO Auto-generated method stub
		

		
	}


