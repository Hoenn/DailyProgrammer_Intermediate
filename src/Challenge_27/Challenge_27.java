package Challenge_27;

import java.util.Scanner;

/* 
 *  Happy St. Patrick's Day!  Write a program that accepts a year as input and outputs what day St. Patrick's Day falls on.
 */
public class Challenge_27
{
	public static final int spMonth=3;
	public static final int spDay=17;
	
	public static final String[] daysOfWeek = {
		"Sunday",
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday",
		"Saturday"
	};

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter year: ");
		int year = input.nextInt();
		int day = findDayOfWeek(year);
		System.out.println("St. Patrick's Day is on a "+daysOfWeek[day]);
	}
	public static int findDayOfWeek(int year)
	{
		int tempYear=year;
		int secondHalf = 0;
		if(tempYear>1000)
		{
			tempYear/=100;
			secondHalf= year%1000;
		}
		else
		{
			tempYear/=10;
			secondHalf=year%100;
		}
		
		int c = tempYear%4;
		return ((spDay+spMonth+secondHalf+(secondHalf/4)+c)-1)%7;
	}
}
