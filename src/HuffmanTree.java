import java.util.*;
public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree>{
    /**
     * constructor with no parameters
     */
    public HuffmanTree(){
        super();
    }

    /**
     * constructor given HuffmanPair element
     * @param element given element
     */
    public HuffmanTree(HuffmanPair element){
        super(element);
    }

    /**
     * Constructor given root's element, a left tree and right tree. Constructor combines these
     * @param element given element
     * @param leftSubtree left subtree
     * @param rightSubtree right subtree
     */
    public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree){
        super(element);
        if(leftSubtree != null){
            getRoot().setLeft(leftSubtree.getRoot());
        }else
            getRoot().setLeft(null);
        if(rightSubtree!=null){
            getRoot().setRight(rightSubtree.getRoot());
        }else
            getRoot().setRight(null);
    }

    /**
     * constructor builds a huffman tree given ordered list of huffman pairs
     * @param pairsList list of Huffman Pair objects
     */
    public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList){
        Iterator<HuffmanPair>iterator = pairsList.iterator(); // allows program to iterate through pairsList
        ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<>(); // temporary list
        while(iterator.hasNext()){
            HuffmanPair pair =  iterator.next();
            HuffmanTree tree = new HuffmanTree(pair);
            buildList.add(tree);
        }
        while(buildList.size()>1){
            HuffmanTree smaller =  buildList.removeFirst();
            HuffmanTree bigger = buildList.removeFirst();
            int totalFrequency = smaller.getRoot().getElement().getFrequency() + bigger.getRoot().getElement().getFrequency();
            HuffmanTree combinedTree = new HuffmanTree(new HuffmanPair(totalFrequency), smaller, bigger);
            buildList.add(combinedTree);
        }
        setRoot(buildList.removeFirst().getRoot());
    }

    /**
     * implementation of comparable class
     * @param o given Huffman Tree
     * @return comparision of the frequencies of the root node of the trees
     */
    @Override
    public int compareTo(HuffmanTree o) {
        return getRoot().getElement().compareTo(o.getRoot().getElement());
    }

    /**
     * Return string representation of the HuffmanTree by doing preorder traversal
     * @return string representation
     */
    public String toString(){
        String s = "";
        Iterator<HuffmanPair> list = iteratorPreOrder();
        while(list.hasNext()){
            s += list.next().toString();
        }
        return s;
    }
}
