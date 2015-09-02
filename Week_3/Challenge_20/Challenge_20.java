package Challenge_20;

import java.util.Scanner;

/*
 * create a program that will take user input and tell them their age in months, days, hours, and minutes
 *  sample output:
 * how old are you? 18
 * months : 216, days : 6480, hours : 155520, and minutes : 388800
 */
public class Challenge_20 {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("How old are you? ");
		int age = input.nextInt();
		System.out.println(getBirthdayString(age));
	}
	public static String getBirthdayString(int age)
	{
		String result = "";
		
		result+= "Months: "+age*12+" ";
		result+= "Days: "+age*365+" ";
		result+= "Hours: "+age*(365*24)+" ";
		result+= "Minutes: "+age*(365*24*60)+" ";
				
		
		
		return result;
	}
}
