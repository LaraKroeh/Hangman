import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Klasse1 {
	
public static int leben = 6; 
public static int counter = 1;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		List<String> wordList = getWordList();	
		String word = getWord(wordList);												//gesuchtes Wort
		char[] searchedLetter = word.toCharArray();	
		List<String> buchstabenliste= new ArrayList <String>() ;
		String erlaubteBuchstaben = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";						//ein String mit allen ungültigen Zeichen; wird zur Überprüfung der Gültigkeit verwendet
		
		for (int i=0; i<word.length(); i++) {											//Starttext
		System.out.print("_ ");
		}
		System.out.println("\n \nAnleitung: Um zu raten, geben Sie bitte einen Großbuchstaben ein und drücken Sie Enter. Viel Spaß\n" );
		
		while (leben > 0 && counter > 0 ) {												
			
			String letter = inputFromKeyboard(keyboard);								//ein vom Spieler eingetippter Buchstabe
			buchstabenliste.add(letter);												//Der Buchstabe wird zu einer Liste hinzugefügt
			if(erlaubteBuchstaben.contains(letter)) {									//Überprüfung auf Gültigkeit des Zeichens
				if (new String(word).contains(letter)) {								//überprüft, ob Buchstabe im Wort vorkommt
					printWord(buchstabenliste,searchedLetter);							//Schreibt das Wort ensprechend dem Fortschritt aus.
				} else {
					leben = leben -1;													//Reduzierung der Leben
					System.out.print(letter);											//Ausgabe der verbliebenen Leben
					System.out.print(" ist leider falsch. Ihnen verbleiben noch "); 		
					System.out.print(leben);
					System.out.println(" Leben.");
				} 
			 } else {																	//Ausgabe bei ungültigen Zeichen
				System.out.println("Sie haben ein falsches Zeichen eingegeben. Bitte beachten Sie, dass ausschließlich alleinstehende Großbuchstaben, die keine Umlaute sind, akzeptiert werden.");
			} 
		}
		
		if (leben == 0) {
			System.out.println("\nSIE WURDEN ERHANGEN!\nDie richtige Lösung war: ");	//Game over Screen
			System.out.println(word);	
		}
	}
	
	
	//Methode, die das Wort soweit wie bereits erraten ausschreibt. (+Siegesmeldung)
	private static void printWord(List<String> letters, char[] word) {
		int counter = 0 ;	
		for (int i=0; i<word.length; i++) {
			if (letters.contains(String.valueOf(word[i]))){ 
				System.out.print(word[i]);
			}else{
				System.out.print("_ ");
				counter = counter +1;
			}
		}
		System.out.println("");	
		if (counter == 0) {														//wenn das ganze Wort erraten wurde 
		System.out.println("\n\nYOU ARE WINNER!");								//Siegesmeldung
		counter = 0;
		}
	}
	
	

	// nimmt Buchstaben, der durch Spieler eingegeben wird, auf
 	public static String inputFromKeyboard(Scanner keyboard) {
		String letter = keyboard.next();
		
		return letter;
	}

	// COM wählt ein zufälliges Wort aus. 
	public static List<String> getWordList() {
		List<String> woerterliste = new ArrayList<String>(); 							//Vokabular, aus dem gewählt wird
		woerterliste.add("BALL");
		woerterliste.add("HORN");
		woerterliste.add("FEST");
		woerterliste.add("JAVA");
		woerterliste.add("BAUM");
		woerterliste.add("ETHALON");
		woerterliste.add("INFORMATIK");
		woerterliste.add("GALGEN");
		woerterliste.add("SPIEL");	
		woerterliste.add("EINHORN");
		woerterliste.add("STEIN");
		woerterliste.add("KATZE");
		woerterliste.add("TRAUM");
		woerterliste.add("RUBIN");
		woerterliste.add("HAMBURG");
		woerterliste.add("ENGEL");
		woerterliste.add("TRANSFORMATOR");
		woerterliste.add("BOGEN");
		woerterliste.add("WASSER");
		woerterliste.add("PFEIL");
		woerterliste.add("MAUER");
		woerterliste.add("COMPUTER");
		woerterliste.add("TASTATUR");
		woerterliste.add("TOD");
		woerterliste.add("BUCH");
		woerterliste.add("XYLOPHON");
		woerterliste.add("EISHOKEYSCHLÄGER");
		woerterliste.add("SKIZZE");
		woerterliste.add("NERD");
		woerterliste.add("NAHT");
		woerterliste.add("HARAJUKU");
		woerterliste.add("MANDEL");
		woerterliste.add("KETTE");
		woerterliste.add("BAMBUS");
		woerterliste.add("INTERNET");
		woerterliste.add("HUND");
		woerterliste.add("FREUNDSCHAFT");
		woerterliste.add("GRILL");
		woerterliste.add("GEBÄRDE");
		woerterliste.add("ALKOHOL");
		woerterliste.add("VULKAN");
		woerterliste.add("KORB");
		woerterliste.add("VOGEL");
		woerterliste.add("KONZERT");
		woerterliste.add("Verwandschaft");
		woerterliste.add("SUPERKALIFRAGELISTIKEXPIALIGETISCH");
		woerterliste.add("ZAUBER");
		woerterliste.add("KARUSSEL");
		woerterliste.add("TRIATLON");
		
		return woerterliste;
	}

	
	//Auswahl eines zufälligen Wortes
	public static String getWord(List<String> woerterliste) {
		Random random = new Random();
		int gesuchtesWort = random.nextInt(woerterliste.size());
		return woerterliste.get(gesuchtesWort);
	}
}