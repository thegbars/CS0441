// STARTER FILE LAB #3 

import java.util.*;
import java.io.*;

public class Lab3
{
    static final int MAX_CAPACITY = 30;  // HARDOCED PLENTY BIG. WE'LL DO TRIM AFTER
    
    public static void main( String args[] ) throws Exception
    {
        if (args.length < 1 )
        {
            System.out.println("usage: $ java Lab3 <inupt file of random numbers>\n");
            System.exit(0);
        }
        
        int[] arr = new int[ MAX_CAPACITY ];
        int count=0;
        
        Scanner infile = new Scanner( new File( args[0] ) );
        while ( infile.hasNextInt() )
        {
            insertInOrder( arr, count, infile.nextInt() );
            ++count;
        }
        
        arr = trimArray( arr, count );
        printArray( arr ); // NOTE:  NO COUNT PASSED IN
        
    }// END MAIN
    
    // ############################################################################################################
    
    // MUST USE ENHANCED FOR LOOP IN THIS METHOD
    // (YOUR TRIM BETTER HAVE BEEN WRITEN CORRECTLY)
    static void printArray( int[] array )
    {
        // PRINT EACH NUMBER WITH A SPACE AFTER IT
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println(); // LEAVE THIS HERE
    }
    
    static int[] trimArray( int[] array, int count  )
    {
        int[] trimmedArray = new int[count];

        int tempCount = 0;
        while(tempCount < trimmedArray.length)
        {
            trimmedArray[tempCount] = array[tempCount++];
        }

        return trimmedArray; // THIS IS NOT CORRECT. YOU MUST REPLACE IT!!!!
    }
    
   
    // THE CODE IN HERE NOW JUST APPENDS. THIS IS NOT CORRECT
    static void insertInOrder( int[] arr, int count, int newVal   )
    {
        boolean found = false;
        if(count == 0)
        {
            arr[0] = newVal;
        }
        else if(arr[0] > newVal)
        {
            for(int l = count+1; l > 0; l--)
                    {
                        arr[l] = arr[l-1];
                    }

                arr[0] = newVal;
        }
        else if (arr[count-1] < newVal)
        {
            arr[count] = newVal;
        }
        else
        {
            for(int i = count; i > 0; i--)
            {
                if(arr[i] > newVal && arr[i-1] < newVal)
                {

                    for(int j = count+1; j > i; j--)
                    {
                        arr[j] = arr[j-1];
                    }



                    arr[i] = newVal;
                    found = true;
                    break;
                }            
            }
/*
            if(!found && arr[0] > newVal)
            {
                for(int l = count+1; l > 0; l--)
                    {
                        arr[l] = arr[l-1];
                    }

                arr[0] = newVal;
            }
            else if(!found)
            {
                arr[count] = newVal;
            }
*/
        }
    }
}
// END LAB #3
