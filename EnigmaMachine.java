package enigma;

public class EnigmaMachine {
	
	private EnigmaRotor rotorOne, rotorTwo, rotorThree;
	public EnigmaMachine(int rotorNumberOne, int offsetOne, int rotorNumberTwo, int offsetTwo, int rotorNumberThree, int offsetThree) {
		rotorOne = new EnigmaRotor(rotorNumberOne, offsetOne, 1);
		rotorTwo = new EnigmaRotor(rotorNumberTwo, offsetTwo, 2);
		rotorThree = new EnigmaRotor(rotorNumberThree, offsetThree, 3);
	}
	public char encrypt(char c) {
		char encryptedChar = rotorOne.getChar(c);
		if(rotorOne.getOffset() + 1 == 26) {
			if(rotorTwo.getOffset() + 1 == 26) {
				rotorThree.setOffset(rotorThree.getOffset() + 1);
			}
			rotorTwo.setOffset(rotorTwo.getOffset() + 1);
			rotorOne.setOffset(rotorOne.getOffset() + 1);
		}
		else {
			rotorOne.setOffset(rotorOne.getOffset() + 1);
		}
		encryptedChar = rotorTwo.getChar(encryptedChar);
		
		encryptedChar = rotorThree.getChar(encryptedChar);
		
		encryptedChar = rotorTwo.getChar(encryptedChar);
		if(rotorTwo.getOffset() + 1 == 26) {
			rotorThree.setOffset(rotorThree.getOffset() + 1);
			
		}
		
		encryptedChar = rotorOne.getChar(encryptedChar);
		if(rotorOne.getOffset() + 1 == 26) {
			if(rotorTwo.getOffset() + 1 == 26) {
				rotorThree.setOffset(rotorThree.getOffset() + 1);
			}
			rotorTwo.setOffset(rotorTwo.getOffset() + 1);
			rotorOne.setOffset(rotorOne.getOffset() + 1);
		}
		else {
			rotorOne.setOffset(rotorOne.getOffset() + 1);
		}
		return encryptedChar;
	}
}
