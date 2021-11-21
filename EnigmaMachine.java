package enigma;

public class EnigmaMachine {
	
	private EnigmaRotor rotorOne, rotorTwo, rotorThree;
	/**
	 * Creates an Enigma machine with the 3 rotors, each at a given offset, and their positions in the machine
	 * @param rotorNumberOne the first rotor in the machine
	 * @param offsetOne the offset to start the first rotor at
	 * @param rotorNumberTwo the second rotor in the machine
	 * @param offsetTwo the offset to start the second rotor at
	 * @param rotorNumberThree the third rotor in the machine
	 * @param offsetThree the offset to start the third rotor at
	 */
	public EnigmaMachine(int rotorNumberOne, int offsetOne, int rotorNumberTwo, int offsetTwo, int rotorNumberThree, int offsetThree) {
		rotorOne = new EnigmaRotor(rotorNumberOne, offsetOne, 1);
		rotorTwo = new EnigmaRotor(rotorNumberTwo, offsetTwo, 2);
		rotorThree = new EnigmaRotor(rotorNumberThree, offsetThree, 3);
	}
	/**
	 * Encrypts the given character and return the new encrypted character and "rotates" or increases any offsets depending on the rotor and it's position
	 * @param c the character to encrypt
	 * @return the newly encrypted character
	 */
	public char encrypt(char c) {
		char encryptedChar = rotorOne.getChar(c);
		//if the first rotor has done a full rotation increase the offset of the second rotor by 1
		if(rotorOne.getOffset() + 1 == 26) {
			//if the second rotor has done a full rotation increase the offset of the third rotor by 1
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
		//if the second rotor has done a full rotation increase the offset of the third rotor by 1
		if(rotorTwo.getOffset() + 1 == 26) {
			rotorThree.setOffset(rotorThree.getOffset() + 1);
			
		}
		
		encryptedChar = rotorOne.getChar(encryptedChar);
		//if the first rotor has done a full rotation increase the offset of the second rotor by 1
		if(rotorOne.getOffset() + 1 == 26) {
			//if the second rotor has done a full rotation increase the offset of the third rotor by 1
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
