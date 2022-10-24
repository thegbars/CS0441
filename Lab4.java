import java.util.*;
import java.io.*;

public class Lab4
{
    public static void main(String[] args) throws Exception
    {
        if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Lab4 <input filename>\n\n"); // i.e. C:\> java Lab2 L2input.txt
			System.exit(0);
		}

        BufferedReader theFile = new BufferedReader (new FileReader(args[0]));

        ArrayList<String> wordList = new ArrayList<String>();
        
        while(theFile.ready())
        {
            wordList.add(theFile.readLine());
        }

        Collections.sort(wordList);

        for(String word : wordList)
        {
            System.out.println(word + " " + canonize(word));
        }
    }

    public static String canonize(String word)
    {
        char letterArray[] = word.toCharArray();
        Arrays.sort(letterArray);

        String theWord = "";
        for(char x : letterArray)
        {
            theWord += x;
        }

        return theWord;
    }
}