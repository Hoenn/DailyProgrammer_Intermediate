package Challenge_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Write a program that will take a string ("I LIEK CHOCOLATE MILK"), and allow the user to scan a text file
 * for strings that match. after this, allow them to replaces all instances of the string with another ("I quite
 * enjoy chocolate milk. hrmmm. yes.")
 */

public class Challenge_9 {
	private static final String filepath="src/Challenge_9/ch9.txt";
	public static void main(String args[]) throws IOException
	{
		//Get entire text file in one string
		String fileContents = new Scanner(new File(filepath)).useDelimiter("\\Z").next();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter phrase to find: ");
		String findPhrase = input.nextLine();
		
		if(fileContents.contains(findPhrase))
		{
			System.out.println("Phrase found!");
		}
		
		System.out.println("Would you like to replace this phrase with another? y/n");
		String choice = input.nextLine().toUpperCase().trim();
		if(choice.equals("Y"))
		{
			System.out.println("Enter replacement: ");
			String replacePhrase = input.nextLine();
			fileContents=fileContents.replaceAll(findPhrase, replacePhrase);
			
			File replaced = new File(filepath);
			FileWriter fWriter = new FileWriter(replaced, false);
			fWriter.write(fileContents);
			fWriter.close();
			
			
		}
		
	}
}
