package Challenge_8;
import java.util.Scanner;

/**
 * Write a program that will print the english name of a value.
 * For example: "1211" would become "one-thousand, two-hundred, eleven"
 * For extra credit allow it to read the english value and print out the number
 * 
 */
public class Challenge_8 {
	
	private static String[] specialNames = 
		{
			"",
			"thousand",
			"million",
			"billion",
			"trillion",
			"quadrillion",
			"quintillion"
		};
	private static String[] numberNames =
		{
			"",
			"one",
			"two",
			"three",
			"four", 
			"five", 
			"six",
			"seven",
			"eight",
			"nine",
			"ten",
			"eleven",
			"twelve",
			"thirteen",
			"fourteen",
			"fifteen",
			"sixteen",
			"seventeen",
			"eighteen",
			"nineteen",
		};
	private static String[] tensNames =
		{
			"",
			"ten",
			"twenty",
			"thirty",
			"fourty",
			"fifty",
			"sixty",
			"seventy",
			"eighty",
			"ninety,"
		};
	
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input a number to be rewritten in spoken English");
		System.out.print("> ");
		
		int inputNumber = Integer.parseInt(input.nextLine());
		
		input.close();
		
		System.out.println(spokenEnglish(inputNumber));
	}
	private static String spokenEnglish(int number)
	{
		String result = "";
		if(number==0)
			return "zero";
		//magnitude refers to the special name
		//million, billion, etc.
		int magnitude=0;
		do
		{
			//Starting from the right side of the number
			//Take each three digit chunk and put send to
			//lessThanOneThousand helper method
			int n = number%1000;
			if(n!=0)
			{
				String temp = lessThanOneThousand(n);
				result= temp+" "+specialNames[magnitude]+" "+result;
			}
			magnitude++;
			//remove the first three digits and continue with 
			//the remaining digits until nothing remains and number==0
			number/=1000;
			
			
			
		}while(number>0);
		
		
		return result;
	}
	
	private static String lessThanOneThousand(int number)
	{
		String temp="";
		if(number%100 <20)
		{
			//If the tens/ones place is under twenty
			//use their special name whose index
			//is equal to their value;
			temp= numberNames[number%100];
			number /= 100;
		}
		else
		{
			//Else get the ones place
			temp= numberNames[number%10];
			//Remove the ones places
			number/= 10;
			//get the tens place and add the ones place to it
			temp= tensNames[number%10]+temp;
			number/=10;
			//Remove the tens place
		}
		if(number==0)
			return temp;
		//All that should be left is the digit in 
		//the hundreds position
		return numberNames[number]+" hundred "+temp;
	}
}
