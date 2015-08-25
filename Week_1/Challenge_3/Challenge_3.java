package Challenge_3;

import java.util.Scanner;

/*
 * Create a program that can take a piece of text and encrypt it with an alphabetical substitution cipher. 
 * This can ignore white space, numbers, and symbols.
 */
public class Challenge_3
{
	private static Scanner input;
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		System.out.println("Enter text to be decoded");
		System.out.print("> ");
		String word = input.nextLine().trim().toUpperCase();
		String encrypt = encrypt(word);
		String decrypt = decrypt(encrypt);
		System.out.println("Encrypted: "+encrypt);
		System.out.println("Decrypted: "+decrypt);
	}
	public static String encrypt(String text)
	{
		String temp = "";
		for(int i=0; i<text.length(); i++)
		{
			Character c = text.charAt(i);
			temp += Character.toString((char)(90-c.charValue()+65));
		}
		return temp;
		
	}
	public static String decrypt(String text)
	{
		String temp = "";
		for(int i=0; i<text.length(); i++)
		{
			Character c = text.charAt(i);
			temp += Character.toString((char)(65-c.charValue()+90));
		}
		return temp;
		
	}
	
}
