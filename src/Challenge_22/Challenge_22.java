package Challenge_22;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Challenge_22
{
	private static char[][] maze;
	private static int width;
	private static int playerR;
	private static int playerC;
	private final static int viewDistance =5;
	private static boolean win;
	public static void main(String args[])  throws FileNotFoundException
	{
		File file = new File("src/Challenge_22/map1.txt");
		Scanner scanner = new Scanner(file);
		
		playerR=-1;
		playerC=-1;
		
		win=false;
		
		//Needed to create the 2D maze array
		String firstLine = scanner.nextLine();
		width=firstLine.length();
		maze = new char[width][width];
		char[] characters = firstLine.toCharArray();
		for(int i=0; i<characters.length; i++)
		{
			if(characters[i]=='S')
			{
				playerR=0;
				playerC=i;
			}
			
			maze[0][i]=characters[i];
		}
		
		//Already got first row, start at second
		int current = 1;
		while (scanner.hasNextLine())
		{
			characters= scanner.nextLine().toCharArray();
			for(int i=0; i<characters.length; i++)
			{
				if(characters[i]=='S')
				{
					playerR=current;
					playerC=i;
				}
				maze[current][i]=characters[i];
			}
			current++;
		}		
		
		if(playerR<0 || playerC<0)
			System.out.println("Player not found"); 
		

		displayMaze();
		scanner.close();
		scanner = new Scanner(System.in);
		char choice = ' ';
		while(!win)
		{
			choice = scanner.nextLine().toUpperCase().toCharArray()[0];
			switch(choice)
			{
				case 'U': moveUp();
						  break;
				case 'D': moveDown();
						  break;
				case 'L': moveLeft();
						  break;
				case 'R': moveRight();
						  break;
			}
		}
		System.out.println("You Win!");
	}
	public static boolean isSpaceNotWall(int r, int c)
	{
		if(maze[r][c]=='E')
			win=true;
		return maze[r][c]!='#' && maze[r][c]!='E';
	}
	public static void moveLeft()
	{
		if(playerC>0)
			if(isSpaceNotWall(playerR, playerC-1))
			{
				maze[playerR][playerC]=maze[playerR][playerC-1];
				maze[playerR][playerC-1]='S';
				playerC-=1;
			}
		displayMaze();
	}
	public static void moveRight()
	{
		if(playerC<maze.length)
			if(isSpaceNotWall(playerR, playerC+1))
			{
				maze[playerR][playerC]=maze[playerR][playerC+1];
				maze[playerR][playerC+1]='S';
				playerC+=1;
			}
		displayMaze();
	}
	public static void moveUp()
	{
		if(playerR>0)
			if(isSpaceNotWall(playerR-1, playerC))
			{
				maze[playerR][playerC]=maze[playerR-1][playerC];
				maze[playerR-1][playerC]='S';
				playerR-=1;
			}
		displayMaze();
	}
	public static void moveDown()
	{
		if(playerR<maze.length)
			if(isSpaceNotWall(playerR+1, playerC))
			{
				maze[playerR][playerC]=maze[playerR+1][playerC];
				maze[playerR+1][playerC]='S';
				playerR+=1;
			}
		displayMaze();
	}
	private static void displayMaze()
	{
		clearConsole();
		for(int i= (playerR-viewDistance<0?0:playerR-viewDistance);i<playerR+viewDistance&& i<maze.length; i++)
		{
			for(int j =(playerC-viewDistance<0?0:playerC-viewDistance); j<playerC+viewDistance&&j<maze.length; j++)
				System.out.print(maze[i][j]);
			System.out.println();
		}
	}
	private static void clearConsole()
	{
		StringBuilder clear = new StringBuilder();
		for(int i= 0; i< 30; i++)
		{
			clear.append("\n");
		}
		System.out.print(clear.toString());
	}

}
