package strutturedati;
import java.util.Comparator;
import java.util.TreeMap;
public class TreeMapComparatorEx {

	public static void main(String[] args) {
		
		 TreeMap<Italia, String> treeMap = new TreeMap<>(Comparator.comparing(Italia::getCapoluogo));
		 //IN BASE AL VALORE PASSATO AL COMPARATORE CAMBIA IL DATO DA COMPARARE
		 //TreeMap<Italia, String> treeMap = new TreeMap<>(Comparator.comparing(Italia::getRegione));
		 
		 treeMap.put(new Italia("Puglia", "Bari"), "Bari");
		 treeMap.put(new Italia("Toscana", "Firenze"), "Firenze");
		 treeMap.put(new Italia("Lazio", "Roma"), "Roma");
		 treeMap.put(new Italia("Piemonte", "Torino"), "Torino");
		 treeMap.put(new Italia("Campania", "Napoli"), "Napoli");
		 
		 for (Italia regione : treeMap.keySet()) {
			 System.out.println("Regione: "+ regione.getRegione() + " Capoluogo: " + treeMap.get(regione));
			// System.out.println("Regione: "+ regione.getRegione() + " Capoluogo: " + treeMap.get(regione));
		 }
}

}
