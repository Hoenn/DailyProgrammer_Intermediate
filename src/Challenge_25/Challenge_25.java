package Challenge_25;

import java.util.Scanner;

public class Challenge_25
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter non fractional number to convert to binary");
		int userNum = input.nextInt();
		
		System.out.println(convertToBinary(userNum));
	}
	public static StringBuilder convertToBinary(int num)
	{
		StringBuilder result = new StringBuilder();
		
		while(num>2)
		{
			num/=2;
			result.append(num%2);
		}
		result.append(num/2);
		result.reverse();
		return result;
	}
}
