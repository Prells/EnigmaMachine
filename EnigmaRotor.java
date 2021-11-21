package enigma;

public class EnigmaRotor {
	private int rotorNumber;
	private char[] sequence = new char[26];
	private int offset;
	private int position;
	/**
	 * Creates an Enigma Rotor based on the number given, the offset to start at, and the position of the rotor
	 * @param rotorNumber the number of the rotor to use
	 * @param offset the offset to start the rotor at, 0 if start at the first letter
	 * @param position the position of the rotor in the machine
	 */
	public EnigmaRotor(int rotorNumber, int offset, int position) {
		this.rotorNumber = rotorNumber;
		this.position = position;
		switch(rotorNumber) {
			case 1: char[] temp = { 'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J' };
					for(int i = 0; i < temp.length; i++) {
						sequence[i] = temp[i];
					}
					break;
			case 2: char[] temp2 = { 'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E' };
					for(int i = 0; i < temp2.length; i++) {
						sequence[i] = temp2[i];
					}
					break;
			case 3: char[] temp3 = { 'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O' };
					for(int i = 0; i < temp3.length; i++) {
						sequence[i] = temp3[i];
					}
					break;
			case 4: char[] temp4 = { 'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B' };
					for(int i = 0; i < temp4.length; i++) {
						sequence[i] = temp4[i];
					}
					break;
			case 5: char[] temp5 = { 'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
					for(int i = 0; i < temp5.length; i++) {
						sequence[i] = temp5[i];
					}
					break;
			case 6: char[] temp6 = { 'J','P','G','V','O','U','M','F','Y','Q','B','E','N','H','Z','R','D','K','A','S','X','L','I','C','T','W' };
					for(int i = 0; i < temp6.length; i++) {
						sequence[i] = temp6[i];
					}
					break;
			case 7: char[] temp7 = { 'N','Z','J','H','G','R','C','X','M','Y','S','W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T' };
					for(int i = 0; i < temp7.length; i++) {
						sequence[i] = temp7[i];
					}
					break;
			case 8:	char[] temp8 = {	'F','K','Q','H','T','L','X','O','C','B','J','S','P','D','Z','R','A','M','E','W','N','I','U','Y','G','V'	};
					for(int i = 0; i < temp8.length; i++) {
						sequence[i] = temp8[i];
					}
					break;
		}
	}
	/**
	 * Takes the given character and encrypts it
	 * @param charToEncrypt the character to encrypt
	 * @return the new encrypted character
	 */
	public char getChar(char charToEncrypt) {
		char uppercase = Character.toUpperCase(charToEncrypt);
		//Convert the ASCII code to the proper position in the array
		char c = sequence[(offset + uppercase - 65) % 26]; //minus 64 to convert ASCII code to 1 to 26 of proper position of that letter to the alphabet
		
		return c;
	}
	/**
	 * Returns the offset that the rotor is set at
	 * @return the offset of the rotor
	 */
	public int getOffset() {
		return offset;
	}
	/**
	 * Sets the offset of the rotor to a new offset
	 * @param offset the new offset to set the rotor to
	 */
	public void setOffset(int offset) {
		if(offset == 26) {
			this.offset = 0;
		}
		else{
			this.offset = offset;
		}
	}
}
