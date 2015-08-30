package Challenge_12;

import java.util.Scanner;

/* 
 * Create a program that will factor a number. for example:
 * 12 = 2*2*3
 * 14 = 7*2
 * 20 = 2*2*5
 */
public class Challenge_12
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number to factor");
		int number= input.nextInt();
		
		System.out.println(factor(number));
	}
	private static String factor(int number)
	{
		String result = "";
		
		int current = number;
		while(!notPrime(current))
		{
			if(current%2==0)
			{
				current/=2;
				result+=2+"*";
			}
			else if(current%3==0)
			{
				current/=3;
				result+=3+"*";
			}
		}
		result+=current;
		return result;
	}
	private static boolean notPrime(int number)
	{
	    for(int i = 2; 2*i <number; i++) {
	        if(number % i ==0)
	            return false;
	    }
	    return true;
	}
}
