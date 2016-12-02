import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by novabrains on 11/6/14.
 */
public class Main
{

    public static void main(String[] args) throws FileNotFoundException
    {
        Map<String, Integer> myDictionary = new HashMap<String, Integer>();

        myDictionary = ReadOperations.readFile();



        String sequence = "";
        Node root = Huffman.createTree(myDictionary);
        printTree(root, sequence, "");

    }

    static void printTree(Node node, String sequence, String concat)
    {
        sequence = sequence + concat;

        if (node.letter != null)
            System.out.println(node.letter + ": " + sequence);
        else
        {
            printTree(node.left, sequence, "0");
            printTree(node.right, sequence, "1");
        }
    }
}