import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testklasse1 extends Klasse1 {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		List<String> wordList = getWordList();	
		String word = getWord(wordList);											//gesuchtes Wort
		List<String> buchstabenliste= new ArrayList <String>() ;
		List<Integer> position = new ArrayList<Integer>();
		
		for (int i=0; i<word.length(); i++) {										//Starttext
			System.out.print("_ ");
		}
		System.out.println("\n \nAnleitung: Um zu raten, geben Sie bitte einen Großbuchstaben ein und drücken Sie Enter. Viel Spaß\n" );
		
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

	private static void guessInWord (String guess, String word, List<Integer> position) {
		int i = word.indexOf(guess);
		if (!(i==-1)) {
			int t = guess.length();
			int l = word.lastIndexOf(guess);
			if (l == i) {
				for (int k=i; k<i+t;k++) {
					position.add(k);
				}
			} else {
				for (int k=i; k<i+t; k++) {
					position.add(k);
				}
				for (int m=l; m<l+t;m++) {
					position.add(m);
				}
			}
			printWord(position, word);
		} else {
			leben = leben -1;														//Reduzierung der Leben
			System.out.print(guess);												//Ausgabe der verbliebenen Leben
			System.out.print(" ist leider falsch. Ihnen verbleiben noch "); 		
			System.out.print(leben);
			System.out.println(" Leben.");
		}
	}

	public static void printWord(List<Integer> position, String word) {
		counter = 0;
		char[] searchedLetter = word.toCharArray();
		for (int i=0; i<searchedLetter.length; i++) {
			if (position.contains(i)) {
				System.out.print(searchedLetter[i]);
			} else {
				System.out.print("_ ");
				counter = counter + 1;
			}
		}
		if (counter == 0) {															//wenn das ganze Wort erraten wurde 
			System.out.println("\nZum Glück hält auch ein Henker seine Versprechen. \nDu wurdest von deiner Strafe verschont. Glückwunsch!");								//Siegesmeldung;
		}
	}
}