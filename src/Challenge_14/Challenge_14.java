package Challenge_14;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  PUT COMMENT
 */
public class Challenge_14 {
	public static void main(String args[])
	{
		boolean[] primes;
		System.out.println("Calculate primes below: ");
		Scanner input = new Scanner(System.in);
		int maximum = input.nextInt();
		
		primes = calculatePrimesUpTo(maximum);
		System.out.print("\nPrimes = 2 3 ");
	    	for (int i = 2; i < primes.length/2; i++)
	            if (!primes[i])
	                System.out.println((2 * i + 1) +" ");
	}
	private static boolean[] calculatePrimesUpTo(int limit)
	{
	       int n = limit/2;
	        /** initialize the sieve **/
	        boolean[] prime = new boolean[limit];        
	 
	        for (int i = 1; i < n; i++)
	            for (int j = i; j <= (n - i) / (2 * i + 1); j++)
	                prime[i + j + 2 * i * j] = true;
	 
	        return prime;
	}
}
