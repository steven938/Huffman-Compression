public class HuffmanPair implements Comparable<HuffmanPair> {
    /**
     * symbol that is to be encoded
     */
	private char symbol;
    /**
     * the frequency  fo the symbol
     */
	private int frequency;

    /**
     * creates Huffman pair from character and frequency
     * @param c character
     * @param f frequency
     */
	public HuffmanPair(char c, int f) {
		symbol = c;
		frequency = f;
	}

    /**
     * constructor used when symbol is irrelevant
     * @param f given frequency
     */
	public HuffmanPair(int f) {
		
		symbol = (char)0;
		frequency = f;
		
	}

    /**
     * getter for character
     * @return character
     */
	public char getCharacter() {
		
		return symbol;
	}

    /**
     * getter for frequency
     * @return freqeuncy
     */
	public int getFrequency() {
		
		return frequency;
	}

    /**
     * setter for character
     * @param c character
     */
	public void setCharacter(char c) {
		
		symbol = c;
	}

    /**
     * setter for freqeuncy
     * @param f frequency
     */
	public void setFrequency(int f) {
		
		frequency = f;
	}

    /**
     * incrementing frequency by 1
     */
	public void incrementFrequency() {
		
		frequency += 1;
	}

    /**
     * implementation of the comparables class used to compare HuffmanPairs by frequency
     * @param otherPair other HuffmanPair being compared
     * @return the frequency of this object minus freqeuency of object beigng compared
     */
	public int compareTo(HuffmanPair otherPair) {
		
		return this.frequency - otherPair.getFrequency();
	}

    /**
     * establishes equality between HuffmanPairs based on symbol
     * @param obj other HuffmanPair being compared to
     * @return true or false for equivalency
     */
	public boolean equals(Object obj) {
		
		HuffmanPair other = (HuffmanPair) obj;
		if (symbol != other.symbol)
			return false;
		return true;
	}

    /**
     * to string method
     * @return string representation of the Huffman Pair
     */
	public String toString() {
		
		String s = "";
		s = "(" + Character.toString(symbol) + ", " + Integer.toString(frequency) + ")\n" ;
		return s;
	}
}
