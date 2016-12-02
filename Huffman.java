import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Dallas Sanchez on 11/16/14
 * Huffman is a class that contains methods
 * used to create a huffman encoding tree
 */

public class Huffman
{

    /**
     * createTree builds a huffman tree by looping through the map given as a parameter to
     * build a LinkedList, removing the 2 lowest valued Node's from that list, creating
     * a parent to those 2 nodes, and adding that parent to the LinkedList of nodes.
     * this is done until there is only 1 node left and it returns that root node
     *
     * @param myFrequency a map of letters, along with an Integer value of their frequency
     * @return root is the root node of the huffman tree
     */
    static Node createTree(Map<String, Integer> myFrequency)
    {
        //create a list to hold Nodes
        LinkedList<Node> nodeList = new LinkedList<Node>();

        //loop through the map, adding each entry to the list of Nodes
        for(Map.Entry<String, Integer> entry : myFrequency.entrySet())
        {
            Node entryNode = new Node();

            entryNode.letter = entry.getKey();
            entryNode.value = entry.getValue();

            nodeList.add(entryNode);
        }

        //loop while the list has more than 1 entry
        while(nodeList.size() > 1)
        {
            //get the 2 lowest nodes
            Node lowestNode = removeMinNode(nodeList);
            Node nextLowestNode = removeMinNode(nodeList);

            //assign the 2 lowest to a parent node
            Node parent = new Node();
            parent.right = lowestNode;
            parent.left = nextLowestNode;

            //parent gets sum of it's children's values, then add it to the list of nodes
            parent.value =  lowestNode.value + nextLowestNode.value;
            nodeList.add(parent); //Add the parent to the list of nodes
        }

        //return the root of the tree, which is the last node left in the list
        Node root;
        root = nodeList.pop();
        return root;
    }

    /**
     * removeMinNode loops through a LinkedList of Nodes, identifies the lowest node
     * and removes it from the list and returns it
     * @param baseList a LinkedList of type Node
     * @return returns minNode, the Node that has the lowest value in baseList
     */

    static Node removeMinNode(LinkedList<Node> baseList)
    {
        //set variables to initial values
        Node minNode = baseList.getFirst();
        int minIndex = 0;

        Node curNode;
        int curIndex;

        //loop through every node, checking if has a lower value and setting it to lowest if so
        for(curIndex = 1; curIndex < baseList.size(); curIndex++)
        {
            curNode = baseList.get(curIndex);

            if (curNode.value < minNode.value)
            {
                minNode = curNode;
                minIndex = curIndex;
            }
        }

        //remove the lowest node from the original list and return it
        baseList.remove(minIndex);
        return minNode;
    }
}