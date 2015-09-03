package Challenge_19;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Challenge_19 {
	private final static String[] chapterTitles = {
			"A SCANDAL IN BOHEMIA",
			"THE RED-HEADED LEAGUE",
			"A CASE OF IDENTITY",
			"THE BOSCOMBE VALLEY MYSTER",
			"THE FIVE ORANGE PIPS",
			"THE MAN WITH THE TWISTED LIP",
			"THE ADVENTURE OF THE BLUE CARBUNCLE",
			"THE ADVENTURE OF THE SPECKLED BAND",
			"THE ADVENTURE OF THE ENGINEER'S THUMB",
			"THE ADVENTURE OF THE NOBLE BACHELOR",
			"THE ADVENTURE OF THE BERYL CORONET",
			"THE ADVENTURE OF THE COPPER BEECHES"
	};
	private final static String filePath ="Week_3/Challenge_19/sherlock.txt";
	public static void main(String args[]) throws IOException
	{
		String masterString = readFile(filePath, StandardCharsets.UTF_8);
		int bookStart = masterString.indexOf("Beeches");
		ArrayList<String> chapters = new ArrayList<String>();
		for(int i=0; i< chapterTitles.length-1; i++)
		{
			System.out.println(i);
			chapters.add(masterString.substring(masterString.indexOf(chapterTitles[i],bookStart), masterString.indexOf(chapterTitles[i+1],bookStart)));
		}
		chapters.add(masterString.substring(masterString.indexOf(chapterTitles[chapterTitles.length-1], bookStart)));
		int sum =0;
		StringTokenizer tokenizer;
		for(String s: chapters)
		{
			tokenizer = new StringTokenizer(s);
			System.out.println(tokenizer.countTokens());
			sum+=tokenizer.countTokens();
		}
		int numWordsOfChapterTitles=0;
		for(int i = 0 ; i<chapterTitles.length; i++)
		{
			numWordsOfChapterTitles+=chapterTitles[i].length();
		}
		sum-=numWordsOfChapterTitles;
		System.out.println("Total words in book "+sum);
	}
	private static String readFile(String path, Charset encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
