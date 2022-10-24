// Speeder

import java.io.*;
import java.util.*;

public class Project1
{
	public static void main( String args[] )
	{
		Scanner kbd = new Scanner( System.in);

		final int MPH_INCREMENT = 5;	// user pays either $30 or $50
										// for every 5mp overlimit
		final int  LOW_RATE = 30; 		// if not more than 20 over limit then
										// driver pays only $30 per every 5mph over limit
		final int HIGH_RATE = 50; 		// if driver over limit by more than 20
										// driver pays $50 per every 5mph over limit
		final int HIGHRATE_OVERLIMIT = 20;  // if driver is more than 20 over
									   // driver pays the HIGH_RATE
		final int UNDERAGE_SPEEDER_FINE = 300; // applied to flagrant
		final int MINOR_AGE = 20;  		// flagrant speeders this age or under are penalized with
										// the underage speeder fine
		String firstName, lastName;		// driver's name
		int age;						// in whole years
		int speedLimit=0, driverSpeed=0, mphOver=0; // legal, actual, difference
		int rate;      					// how much to charge per 5 (or whatever) mph over
		int baseFine=0,zoneFine=0,underAgeFine=0; // 3 components of total fine
		boolean inZone=false;			// did violation occur in a construction zone

		System.out.print("Driver's first name? " );
		firstName = kbd.next();

		System.out.print("Driver's last name? " );
		lastName = kbd.next();

		System.out.print("Driver's speed in mph? ");
		driverSpeed = kbd.nextInt();

		System.out.print("Speed Limit? ");
		speedLimit = kbd.nextInt();

		System.out.print("Driver's age in yrs? ");
		age  = kbd.nextInt();

		System.out.print("Did violation occur in construction zone? ");
		inZone = kbd.nextBoolean();	// must enter exactly "true" or "false" (case IN-sensitive)

		// D O N T  M O D I F Y  A N Y T H I N G   A B O V E

		// ALL YOUR CODE GOES IN HERE
		// they have to be more than 5 over for them to possibly get any fines 
		// get the correct values into each for the 4 fines: base, zone, underage and total


        /*
if driver is less than or equal to 5mph over limit,  no fine is assessed, but you finish all prompts, calculations and generate the report
else if driver is over limit by 20mph or less, charge $30 per every 5mph over limit.
else if driver is more than 20mph over limit charge $50 per every 5 mph over limit.
the above rules are for the BASE FINE
Don't mix rates! - driver is either charged $30 per 5mph over or $50 per 5mph over.
if the violation occurred in a construction zone, you are to copy the base fine amount into the zone fine variable.
if driver was more than 20 over speed limit AND driver is under 21 they get a $300 underage flagrant speeder fine
         */

        mphOver = (driverSpeed - speedLimit);

        //base fine calculation
        if(mphOver <= 5)
        {
            baseFine = 0;
        }
        else if (mphOver <= HIGHRATE_OVERLIMIT)
        {
            baseFine = ((mphOver / MPH_INCREMENT) * LOW_RATE);
        }
        else if (mphOver > HIGHRATE_OVERLIMIT)
        {
            baseFine = ((mphOver / MPH_INCREMENT) * HIGH_RATE);
        }


        //bonus bucks calculation
        if (inZone)
        {
            zoneFine = baseFine;
        }

        if ((mphOver > HIGHRATE_OVERLIMIT) && (age <= MINOR_AGE))
        {
            underAgeFine = UNDERAGE_SPEEDER_FINE;
        }



		// D O N T  M O D I F Y  A N Y T H I N G   B E L O W

		System.out.println( "\n" +
		"Driver Name: " + lastName + ", " + firstName + "\n" +
		"Driver Age: " + age + "\n" +
		"Speed Limit: " + speedLimit + "\n" +
		"Actual Speed: " + driverSpeed + "\n" +
		"Mph over limit: " + mphOver + "\n" +
		"Base Fine: $" + baseFine + "\n" +
		"Construction Zone Fine: $" + zoneFine + "\n" +
		"Underage Fine: $" + underAgeFine + "\n" +
		"Total Fine: $" + (baseFine+zoneFine+underAgeFine) );

	} // END MAIN METHOD
}
