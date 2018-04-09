public class EncodingData {
    /**
     * a symbol that is to be encoded
     */
    private char symbol;
    /**
     * the binary Huffman code of the symbol (i.e. a string of 0's and 1's)
     */
    private String encoding;

    /**
     * constructor
     * @param symbol given symbol
     * @param encoding given encoding
     */
    public EncodingData(char symbol, String encoding){
        this.symbol = symbol;
        this.encoding = encoding;
    }

    /**
     * getter method for symbol
     * @return symbol
     */
    public char getSymbol(){
        return symbol;
    }

    /**
     * getter method for encoding
     * @return encoding
     */
    public String getEncoding(){
        return encoding;
    }

    /**
     * setter for encoding
     * @param code given code
     */
    public void setEncoding(String code){
        encoding = code;
    }

    /**
     * setter for symbol
     * @param sym given symbol
     */
    public void setSymbol(char sym){
        symbol = sym;
    }

    /**
     * uses the symbol to establish inequality between EncodingData objects
     * @param obj other EncodingData object
     * @return true or false
     */
    public boolean equals(Object obj){
        EncodingData other = (EncodingData) obj;
        if (symbol==other.getSymbol())
            return true;
        return false;
    }

    /**
     * to string method
     * @return string representation of EncodingData
     */
    public String toString(){
        String s = "";
        s = "(" + Character.toString(symbol) + ", " + encoding + ")\n" ;
        return s;
    }
}
