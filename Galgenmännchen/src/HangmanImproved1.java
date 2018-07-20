import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanImproved1 extends Testklasse1{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		List<String> wordList = getWordList();	
		String word = getWord(wordList);													//gesuchtes Wort
		List<String> buchstabenliste= new ArrayList <String>() ;
		List<Integer> position = new ArrayList<Integer>();
		
		startausgabe(word);
		schwierigkeitsstufeWaehlen(keyboard);
		System.out.println("\nAnleitung: Gib deinen Tipp ein und drücke Enter. Viel Spaß\n");
		
		while (leben > 0 && counter > 0 ) {
			String letter = inputFromKeyboard(keyboard);									//ein vom Spieler eingetippter Buchstabe
				buchstabenliste.add(letter);											
				guessInWord(letter,word, position);
				if (leben == 0) {
					System.out.println("\nDU WURDEST ERHANGEN!\nDie richtige Lösung war: ");//Game over Screen
					System.out.println(word);	
				}	
		}
	}

	public static void startausgabe(String word) {
		System.out.println("Du wurdest zum Tode verurteilt.\nDeine Hinrichtung steht kurz bevor\nDu kannst deinen Galgen schon sehen.\nNur noch wenige Schritte trennen dich von deinem grausamen Schicksal.\nAngstschweiß überflutet deinen Körper.\nDu bist noch nicht bereit zu sterben\nDer Henker schaut dich mit einem gnadenlosem Blick an, sodass dir augenblicklich das Blut in den Adern gefriert.\nDoch dann öffnet er den Mund und stellt eine Forderung:\n<<Errate mein Wort. Ich sage dir, ob du richtig rätst. Doch Vorsicht: Jeder Fehler bringt dich dem Strick näher!>>\n" );
		for (int i=0; i<word.length(); i++) {										
			System.out.print("_ ");
		}
	}
	
	public static void schwierigkeitsstufeWaehlen(Scanner keyboard) {
		System.out.println("\n\n Wähle eine Schwierigkeitsstufe. Drücke hierfür die Zahl der gewüschten Stufe.\n(1)Noob (2)Einfach (3)Mittel (4)Schwer (5)Extrem");
		String number = keyboard.next();
		if (number.equals("1")) {
			leben = 18; 
		} else {
			if (number.equals("2")) {
				leben = 12;
			} else {
				if (number.equals("3")) {
					leben = 9;
				} else {
					if (number.equals("4")) {
						leben = 6;
					} else {
						if (number.equals("5")) {
							leben = 3;
						} else {
							System.out.println("Du bist ein Idiot. Das Speziallevel wurde aktiviert. Du hast exakt 1 Leben.");
							leben = 1; 
						}
					}
				}
			}
		}
		System.out.print("Du hast gewählt. Noch ");
		System.out.print(leben);
		System.out.println(" Schritte trennen dich vom Strick.");
	}
	
	public static void guessInWord (String guess, String word, List<Integer> position) {
		int i = word.indexOf(guess.toUpperCase());
		int substart = 0;
		String substring = word;
		
		if (!(i==-1)) {
			int t = guess.length();
			while (! (i==-1)){
				addToList(i,t, position, substart);
				substart = substart+i+t;
				substring = substring.substring(i+t);
				i = substring.indexOf(guess.toUpperCase());
			}
			printWord(position, word);
		} else {
			leben = leben -1;
			lebensmeldung(leben, guess);
		}
	}
	
	public static void addToList(int i, int t, List<Integer> position, int substart) {
		
		for (int k=i; k<i+t;k++) {
			position.add(k+substart);
		}
	}

	public static void lebensmeldung(int leben, String guess) {
		System.out.print(guess);												
		System.out.print(" IST FALSCH! NUR NOCH "); 		
		System.out.print(leben);
		System.out.println(" SCHRITTE TRENNEN DICH VON DEINEM STRICK!");
	}
	
}