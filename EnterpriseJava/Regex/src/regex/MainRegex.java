package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainRegex {
    public static void main(String[] args) {
        String testString = "The quick brown fox jumps over the quick dog.";

        // Creazione del pattern per cercare la parola "fox" nella stringa di testo
        Pattern pattern = Pattern.compile("quick");
        Matcher matcher = pattern.matcher(testString);

        // Trovare la corrispondenza
        while (matcher.find()) {
            System.out.println("La parola cercata inizia al punto " + matcher.start() + " e termina al punto " + matcher.end());
        } 
    }
}