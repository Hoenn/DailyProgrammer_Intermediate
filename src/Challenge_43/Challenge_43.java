package Challenge_43;

import java.util.Scanner;

public class Challenge_43
{

	

	public static final String[] daysOfWeek =
	{ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			"Saturday" };
	public static final int[] monthsTable = {
			0,
			3,
			3,
			6,
			1,
			4,
			6,
			2,
			5,
			0,
			3,
			5
		};

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter year: ");
		int year = input.nextInt();
		System.out.println("Enter month: ");
		int month = input.nextInt();
		System.out.println("Enter day: ");
		int day = input.nextInt();
		
		int dayOfWeek = findDayOfWeek(year, monthsTable[month-1], day);
		System.out.println("That day is a " + daysOfWeek[dayOfWeek]);
	}

	public static int findDayOfWeek(int year, int month, int day)
	{
		int tempYear = year;
		int secondHalf = 0;
		if (tempYear > 1000)
		{
			tempYear /= 100;
			secondHalf = year % 1000;
		} else
		{
			tempYear /= 10;
			secondHalf = year % 100;
		}
		int c = tempYear % 4;
		return ((day + month + secondHalf + (secondHalf / 4) + c) - 1) % 7;
	}
}
