import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanImproved2Players extends HangmanImproved1 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String word = getWord(keyboard);											//gesuchtes Wort
		
		
		List<String> buchstabenliste= new ArrayList <String>() ;
		List<Integer> position = new ArrayList<Integer>();
		
		startausgabeNeu(word);

		while (leben > 0 && counter > 0 ) {
			String letter = inputFromKeyboard(keyboard);							//ein vom Spieler eingetippter Buchstabe
			buchstabenliste.add(letter);											//Der Buchstabe wird zu einer Liste hinzugefügt
			guessInWord(letter,word, position);
			if (leben == 0) {
				System.out.println("\nSIE WURDEN ERHANGEN!\nDie richtige Lösung war: ");//Game over Screen
				System.out.println(word);	
			}
		}
	}


	public static String getWord(Scanner keyboard) {
		System.out.println("Spieler 1: Geben Sie ein zu erratendes Wort ein.\n\nBitte achten Sie darauf, dass es ausschließlich aus Großbuchstaben beseht, die keine Umlaute sind.\nBestätigen Sie Ihre Eingabe mit Enter.");
		String word = keyboard.next().toUpperCase();
		
		return word;
	}
	
	public static void startausgabeNeu(String word) {
		for (int i=0; i<word.length(); i++) {										//Starttext
			System.out.print("_ ");
		}
		System.out.println("\n \nSpieler 2: Raten Sie, indem Sie Ihren Tipp in Großbuchstaben eingeben.\nBestätigen Sie mit Enter. Viel Spaß\n" );
	}

}