package Challenge_18;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Challenge_18
{
	private static String output = "<html><body><form>\n";
	private static final String filePath= "Week_3/Challenge_18/input.txt";
	public static void main(String args[]) throws IOException
	{
		String masterString = readFile(filePath, StandardCharsets.UTF_8);
		System.out.println(masterString);
		
		int currentPos=0;
		while(masterString.contains(":"))
		{
			String currentPiece = masterString.substring(currentPos,masterString.indexOf(":"));
			currentPos=masterString.indexOf(":")+1;
			if(currentPiece.contains("["))
			{
				ArrayList<String> options = new ArrayList<String>();
				String word ="";
				int pos = currentPiece.indexOf("[");
				while(pos<currentPiece.indexOf(":"))
				{
					word+=pos+1;
					word+=currentPiece.substring(pos+2, currentPiece.indexOf(","));
					pos=currentPiece.indexOf("[", currentPos);
				}
			}
			else
				addFieldInput(currentPiece);
			
			masterString=masterString.substring(currentPos);

		}
		
		
		PrintWriter writer = new PrintWriter("Week_3/Challenge_18/outputFile.html", "UTF-8");
		writer.println(output);
		writer.close();
	}
	private static void addFieldInput(String title)
	{
		output+=title+"\n <input type=\"text\" name=\"name\"/> <br/>";
	}
	private static String readFile(String path, Charset encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
