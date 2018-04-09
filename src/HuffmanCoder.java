import java.util.Iterator;

public class HuffmanCoder {
    /**
     * the huffman tree
     */
    private HuffmanTree huffTree;
    /**
     * unordered list of encoding data which will be built when Huffman tree is built and will be used
     * for encoding a textfile into a Huffman-coded compressed file
     */
    private ArrayUnorderedList<EncodingData> encodingList;

    /**
     * This constructor will create the huffTree using 4th Huffman tree constructor
     * @param pairsList
     */
    public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList){
        huffTree = new HuffmanTree(pairsList);
        encodingList = new ArrayUnorderedList<>();
        buildEncodingList(huffTree.getRoot(), "");
    }

    /**
     * Method will take specified string of binary digits that is a Huffman encoding and return coded character
     * @param code given code
     * @return character
     */
    public char decode(String code){
        BinaryTreeNode<HuffmanPair> current = huffTree.getRoot();
        for(char digit: code.toCharArray()){
            if(digit=='0')
                current = current.getLeft();
            else if (digit=='1')
                current = current.getRight();
        }
        if(current.isLeaf())
            return current.getElement().getCharacter();
        return (char)0;
    }

    /**
     * takes specified element and return string representation of the binary Huffman encoding of the character
     * @param c given character
     * @return binary code of the character
     * @throws ElementNotFoundException
     */
    public String encode(char c)throws ElementNotFoundException{
        int index = encodingList.find(new EncodingData(c, "")); // finds index of object with same character
        EncodingData element = encodingList.getElement(index);
        return element.getEncoding();
    }

    /**
     * Builds a list of symbols and their encodings from the Huffman tree
     * @param node root node
     * @param encoding code
     */
    private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding){
        if(node.isLeaf()){
            EncodingData object = new EncodingData(node.getElement().getCharacter(), encoding);
            encodingList.addToRear(object);
        }else{
            buildEncodingList(node.getLeft(), encoding + "0");
            buildEncodingList(node.getRight(), encoding +"1");
        }
    }

    /**
     * return string representation of the encoding list of characters and its corresponding code.
     * @return string representation
     */
    public String toString(){
        return encodingList.toString();
    }
}

