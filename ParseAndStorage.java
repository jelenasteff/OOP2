package rs.ac.ni.pmf.oop2;

import java.util.Scanner;

public class ParseAndStorage {
	public static void main(String[] args) {
		TextParser textParser = new TextParser(); // konstruktor

		System.out.println("Kako zelite da iskodirate tekst?");
		System.out.println("Za LowerCase Encoder : 1");
		System.out.println("Za UpperCase Encoder : 2");

		Scanner in = new Scanner(System.in);
		int izbor = in.nextInt();

		switch (izbor) {
			case 1:
				textParser.setEncoder(new LowerCaseEncoder());
				break;
			case 2:
				textParser.setEncoder(new UpperCaseEncoder());
				break;
			default:
				System.out.println("Pogresan ulazni podatak");
				break;
		}

		System.out.println("Gde zelite da upisete tekst?");
		System.out.println("Za upis u fajl : 1");
		System.out.println("Za upis u bazu podataka : 2");
		System.out.println("Za upis u network storage : 3");

		izbor = in.nextInt();

		switch (izbor){
			case 1:
				textParser.setStorage(new FileStorage());
				break;
			case 2:
				textParser.setStorage(new DBStorage());
				break;
			case 3:
				textParser.setStorage(new NetworkStorage());
				break;
			default:
				System.out.println("Pogresan ulazni podatak");
				break;
		}

		textParser.parse("jelenajelenajelena");
	}
}
