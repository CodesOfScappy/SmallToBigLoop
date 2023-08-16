package de.codeofscappy.loopnumbers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Eine Klasse, die eine Schleife von einer kleinen zu einer großen ganzen Zahl
 * durchläuft. Diese Klasse ermöglicht es dem Benutzer, zwei ganze Zahlen
 * einzugeben und zeigt dann eine Schleife von der kleineren zur größeren Zahl
 * an. Die eingegebenen Zahlen werden auf Gültigkeit geprüft, und die Schleife
 * zählt nur ganze Zahlen. Ungültige Eingaben und Fehler werden abgefangen und
 * dem Benutzer mitgeteilt.
 * 
 * @author [Dein Name]
 * @version 1.0
 */
public class SmallToBigNumbLoop {

	/**
	 * Die Hauptmethode des Programms, die die Eingabe von zwei ganzen Zahlen
	 * ermöglicht und eine Schleife von der kleineren zur größeren Zahl ausführt.
	 * 
	 * @param args Die Befehlszeilenargumente (werden nicht verwendet).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("####################################");
		System.out.println(" Zahlen Looping von klein nach groß ");
		System.out.println("####################################");

		int number1 = getInput("Geben Sie die erste ganze Zahl ein: ", scanner);
		int number2;

		do {
			number2 = getInput("Geben Sie die zweite ganze Zahl (größer oder kleiner als die erste) ein: ", scanner);

			if (number2 == number1) {
				System.out.println("Die zweite Zahl muss unterschiedlich von der ersten Zahl sein.");
			} else if (number2 > number1) {
				break;
			} else {
				System.out.println("Die zweite Zahl muss größer als die erste Zahl sein.");
			}
		} while (true);

		int start = Math.min(number1, number2);
		int end = Math.max(number1, number2);

		int count = Math.abs(end - start) + 1;

		System.out.println("Die Anzahl der Durchläufe der Schleife: " + count);

		for (int i = start; i <= end; i++) {
			System.out.println("Durchlauf " + (i - start + 1) + ", Aktuelle Zahl: " + i);
		}

		scanner.close();
	}

	/**
	 * Liest eine gültige ganze Zahl von der Benutzereingabe ein. Wenn die Eingabe
	 * ungültig ist, wird der Benutzer benachrichtigt und aufgefordert, es erneut zu
	 * versuchen.
	 * 
	 * @param prompt  Die Eingabeaufforderung, die dem Benutzer angezeigt wird.
	 * @param scanner Der Scanner, der für die Benutzereingabe verwendet wird.
	 * @return Die eingegebene ganze Zahl.
	 */
	private static int getInput(String prompt, Scanner scanner) {
		while (true) {
			try {
				System.out.print(prompt);
				int number = scanner.nextInt();
				scanner.nextLine(); // Clear input buffer

				return number;
			} catch (InputMismatchException e) {
				System.out.println("Ungültige Eingabe. Bitte geben Sie eine Ganzzahl ein.");
				scanner.nextLine(); // Clear input buffer
			}
		}
	}
}
