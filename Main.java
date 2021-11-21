package enigma;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String encrypted = "";
	//	System.out.println(7 % 26);
		System.out.println("Rotors available: 1-8");
		System.out.println("Enter the a number for the first rotor and an offset:");
		int rotorOne = 0,rotorTwo = 0,rotorThree = 0;
		int offsetOne = 0,offsetTwo = 0,offsetThree = 0;
		int i = 0;
		if(scan.hasNextInt()) {
			rotorOne = scan.nextInt();
			offsetOne = scan.nextInt();
		}
		System.out.println("Enter a different number for the second rotor and an offset:");
		if(scan.hasNextInt()) {
			rotorTwo = scan.nextInt();
			offsetTwo = scan.nextInt();
		}
		System.out.println("Enter a third number for the third rotor and an offset");
		if(scan.hasNextInt()) {
			rotorThree = scan.nextInt();
			offsetThree = scan.nextInt();
		}
		EnigmaMachine enigma = new EnigmaMachine(rotorOne, offsetOne, rotorTwo, offsetTwo, rotorThree, offsetThree);
		System.out.println("Enter a message");
		while(scan.hasNextLine()) {
			String input = scan.nextLine();
			for(int j = 0; j < input.length(); j++) {
				encrypted = encrypted + enigma.encrypt(input.charAt(j));
			}
			
		}
		System.out.println(encrypted);
	}
}
