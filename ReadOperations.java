import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by novabrains on 10/14/14.
 */
public class ReadOperations
{
    static public Map readFile() throws FileNotFoundException
    {
        Map<String, Integer> myDictionary = new Hashtable<String, Integer>();

        Scanner in = new Scanner(new FileReader("input.txt"));

        HashSet<String> allUniqueLetters = new HashSet<String>();

        while (in.hasNext())
        {
            String currLine = in.nextLine();

            String[] nodes = currLine.split(",");

            LinkedList<String> currList = new LinkedList<String>();

            for(int i = 0; i < nodes.length; i++)
                allUniqueLetters.add(nodes[i]);

            for(String curr : allUniqueLetters)
                myDictionary.put(curr, 0);

            for(int i = 0; i < nodes.length; i ++)
                myDictionary.put(nodes[i], myDictionary.get(nodes[i])+1);

            System.out.println();

            //myDictionary.put(nodes[0], currList);
        }

        return myDictionary;

    }
}