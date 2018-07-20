import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Erweiterungsversuch extends Klasse1 {
	
public static int leben = 6; 
public static int counter = 1;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		List<String> wordList = getWordList();	
		String word = getWord(wordList);												//gesuchtes Wort
		char[] searchedLetter = word.toCharArray();	
		List<String> buchstabenliste= new ArrayList <String>() ;
		//String erlaubteBuchstaben = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";						//ein String mit allen ung�ltigen Zeichen; wird zur �berpr�fung der G�ltigkeit verwendet
		
		for (int i=0; i<word.length(); i++) {											//Starttext
		System.out.print("_ ");
		}
		System.out.println("\n \nAnleitung: Um zu raten, geben Sie bitte einen Gro�buchstaben ein und dr�cken Sie Enter. Viel Spa�\n" );
		
		while (leben > 0 && counter > 0 ) {												
			
			String letter = inputFromKeyboard(keyboard);								//ein vom Spieler eingetippter Buchstabe
			buchstabenliste.add(letter);												//Der Buchstabe wird zu einer Liste hinzugef�gt
			// if(erlaubteBuchstaben.contains(letter)|| buchstabenliste.contains(String.valueOf(word))) {									//�berpr�fung auf G�ltigkeit des Zeichens
				if (new String(word).contains(letter)) {								//�berpr�ft, ob Buchstabe im Wort vorkommt
					printWordLarge(buchstabenliste,searchedLetter);							//Schreibt das Wort ensprechend dem Fortschritt aus.
				} else {
					leben = leben -1;													//Reduzierung der Leben
					System.out.print(letter);											//Ausgabe der verbliebenen Leben
					System.out.print(" ist leider falsch. Ihnen verbleiben noch "); 		
					System.out.print(leben);
					System.out.println(" Leben.");
				} 
			/* } else {																	//Ausgabe bei ung�ltigen Zeichen
				if (letter.length() == word.length()) {
					leben = leben -1;
					System.out.print(letter);											
					System.out.print(" ist leider falsch. Ihnen verbleiben noch "); 		
					System.out.print(leben);
					System.out.println(" Leben.");
				} else {
				System.out.println("Sie haben ein falsches Zeichen eingegeben. Bitte beachten Sie, dass ausschlie�lich Gro�buchstaben, die keine Umlaute sind, akzeptiert werden.");
				} 
			} */
		}
		
		if (leben == 0) {
			System.out.println("\nSIE WURDEN ERHANGEN!\nDie richtige L�sung war: ");	//Game over Screen
			System.out.println(word);	
		}
	}


//Methode, die das Wort soweit wie bereits erraten ausschreibt. (+Siegesmeldung)
	private static void printWordLarge(List<String> letters, char[] word) {
		int counter = 0 ;	
		int n;
		
		for (int i=0; i<word.length; i++) {	
			n=0;
			String s0 = String.valueOf(word[i + n]);
			n = n + 1;									//n=1
			if (i< word.length-n) {
				String s1 = s0 + String.valueOf(word[i+n]);
				n = n + 1;								//n=2
				if (i< word.length-n) {
					String s2 = s1 + String.valueOf(word[i+n]);
					n = n+1;					 		// n=3
					
					// hier kommt eigentlich die n�chste bedingte Verzweigung 
						n=n-1; // nachher ggf entfernen	//n=2
							if (letters.contains(s2)){ 
								System.out.print(s2);
								i = i + n;
							}else{
								n = n-1; 				//n=1
								if (letters.contains(s1)) { 
									System.out.print(s1);
									i = i + n;
								} else {
									
									n = n-1; 			// n=0
									if (letters.contains(s0)){ 
										i = i + n;
										System.out.print(s0);
									}else{
										n = n-1; 		//n=-1
										System.out.	print("_ "); 
										counter = counter +1; 
									}
								}
							}
				} else { 
					n = n - 1;							//n=1
					if (letters.contains(s1)){ 
						System.out.print(s1);
						i = i + n;
						
					} else {
						n = n-1; 						// n=0
						if (letters.contains(s0)){ 
							System.out.print(s0);
							i = i + n;
						}else{
							n = n-1; 					//n=-1
							System.out.print("_ ");
							counter = counter +1; 
						}
					}				
				}
			} else { 
				n = n -1;								//n=0
				if (letters.contains(s0)){ 
					System.out.print(s0);
					i = i + n;
				}else{
					n = n -1;							//n=-1
					System.out.print("_ ");
					counter = counter +1;
				}
			}
		}	
			System.out.println("");	
			if (counter == 0 || letters.contains(String.valueOf(word))) {			//wenn das ganze Wort erraten wurde (-> keine Unterstriche mehr vorhanden sind oder das Wort vollst�ndig eingetippt wurde) 
			System.out.println("\nYOU ARE WINNER!");								//Siegesmeldung
			counter = 0;
		}
	}
}
