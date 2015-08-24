package Challenge_5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge_5 {
	/*
	 * Create a program that can find the amount of anagrams
	 * within a .txt file
	 */
	private static final String filepath= "Week_1/Challenge_5/ch5.txt";
	public static void main(String args[]) throws FileNotFoundException
	{
		String token ="";
		
		Scanner fileIn = new Scanner(new File(filepath)).useDelimiter("\\s");
		
		List<String> wordList = new ArrayList<String>();
		
		while(fileIn.hasNext())
		{
			token = fileIn.next();
			wordList.add(token);
		}
		fileIn.close();
		
		System.out.println("Word count of "+filepath+" "+wordList.size());
		System.out.println("Number of anagrams in "+filepath+" "+anagramCount(wordList));
	}
	public static int anagramCount(List<String> wordList)
	{
		int sum = 0;
		//Start at the end of the list to make removing items cleaner
		for(int i =wordList.size()-1; i >=1; i--)
		{
			//For each item in the list check the rest
			// of the list for a matching anagram
			// then remove (both) items.
			for(int j = i-1; j>=0; j--)
			{
				if(isAnagram(wordList.get(i), wordList.get(j)))
				{
					//Remove the pair of anagrams
					wordList.remove(i);
					wordList.remove(j);
					i--;
					//Break out of search loop as we have found a pair
					//Anagrams are only counted in pairs so that
					// hello elloh and llohe don't show up as 2 pairs
					//but just 1 and a leftover word
					//This functionality is easily switched by not removing 
					//one of the matching words
					j=0;
					sum++;
				}
			}
		}
		
		return sum;
	}
	private static boolean isAnagram(String a, String b)
	{
		boolean isAnAnagram=true;
		int pos = 0;
		//If the words are not the same length they cannot be an anagram
		if(a.length()!= b.length())
			return false;
		
		//if at any point one letter in one word cannot be found in the other word
		//this will fail
		//and because they MUST be the same size, having repeated letters doesn't 
		//affect the outcome.
		while(pos<a.length() && isAnAnagram)
		{
			if(b.indexOf(a.charAt(pos))<0)
			{
				isAnAnagram=false;
			}
			pos++;
		}
		pos=0;
		while(pos<b.length() && isAnAnagram)
		{
			if(a.indexOf(b.charAt(pos))<0)
			{
				isAnAnagram=false;
			}
			pos++;
		}
		
		return isAnAnagram;
	}
}
