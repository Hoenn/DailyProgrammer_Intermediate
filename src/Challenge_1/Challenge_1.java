package Challenge_1;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * "Create a program that will allow you to enter events organizable by hour. There must be menu options of some form, and you
 * must be able to easily edit, add, and delete events without directly changing the source code.
 * (note that by menu i dont necessarily mean gui. as long as you can easily access the different options and receive prompts and 
 * instructions telling you how to use the program, it will probably be fine)"
 */
public class Challenge_1
{
	private static final String[] CHOICES = {"1. Add Event", "2. Delete Event", "3. Edit Event", "4. Display Events"};
	private static ArrayList<HourEvent> eventsList;
	private static Scanner input;
	public static void main(String args[])
	{
		eventsList = new ArrayList<HourEvent>();
		menuSelection();
	}
	public static void menuSelection()
	{
		input = new Scanner(System.in);
		for(int i = 0; i<CHOICES.length; i++)
		{
			System.out.println(CHOICES[i]);
		}
		System.out.println("Enter a number");
		int selection = -1;
		do
		{
			selection = Integer.parseInt( input.nextLine());
		
		} while(selection<1 || selection>4);
		
		switch(selection)
		{
			case 1: addEvent();
					break;
			case 2: deleteEvent();
					break;
			case 3: editEvent();
					break;
			case 4: displayEvents();
					break;
		}
	}
	public static void addEvent()
	{
		System.out.println("Enter a blurb for an Event");

		String userBlurb="";
		do
		{
			userBlurb=input.nextLine();
		}
		while( userBlurb.equals("") );
		
		System.out.println("Enter an hour for the Event");
		int userHour=-1;
		do 
		{
			userHour=Integer.parseInt(input.nextLine());
			if(userHour<0 || userHour>24)
				System.out.println("Hour must be between 0 and 24");
		}
		while(userHour<0 || userHour>24);
		
		System.out.println("Enter a minute for the Event");
		int userMinute =-1;
		do
		{
			userMinute = Integer.parseInt(input.nextLine());
			if(userMinute<0 || userMinute>60)
				System.out.println("Minute must be between 0 and 60");
			
		}
		while(userMinute<0 || userMinute>60);
		
		HourEvent hEvent = new HourEvent(userBlurb, userHour, userMinute);
		//Find the first bigger element and place it before that to keep list sorted
		int i =0;
		while(i < eventsList.size() &&hEvent.compareTo(eventsList.get(i))>0)
		{
			i++;
		}
		
		eventsList.add(i, hEvent);
		menuSelection();
	}
	public static void deleteEvent()
	{
		if(eventsList.size()==0)
		{
			System.out.println("No Events to Delete");
			menuSelection();
		}
		
		System.out.println("List of Events");
		for(int i =0; i<eventsList.size(); i++)
		{
			System.out.println(i+1 +" "+eventsList.get(i));
		}
		System.out.println("Enter number of Event to remove");
		
		int selection = -1;
		do
		{
			selection= Integer.parseInt(input.nextLine());
			if(selection< 0  || selection>eventsList.size())
				System.out.println("Invalid input, Select a number from above");
		}
		while(selection< 0  || selection>eventsList.size());
		
		eventsList.remove(selection-1);
		
		//Back to menu
		menuSelection();
	}
	public static void editEvent()
	{
		System.out.println("List of Events");
		for(int i =0; i<eventsList.size(); i++)
		{
			System.out.println(i+1 +" "+eventsList.get(i));
		}
		System.out.println("Enter number of Event to Edit");
		
		int userInput = -1;
		do
		{
			userInput = Integer.parseInt(input.nextLine());
			if(userInput < 0  || userInput>eventsList.size())
				System.out.println("Invalid input, Select a number from above");
		}while(userInput < 0  || userInput>eventsList.size());
		
		//Prompt user for new Blurb or keep old
		HourEvent temp = eventsList.get(userInput-1);
		System.out.println("Enter new blurb or leave blank to keep old");
		String userBlurb= input.nextLine();
		if(!userBlurb.equals(""))
			temp.setBlurb(userBlurb);
		
		//Prompt user for new hour or keep old
		System.out.println("Enter new hour or -1 to keep old");
		int userHour = Integer.parseInt(input.nextLine());
		if(userHour!=-1)
			temp.setHour(userHour);
		
		//Prompt user for new minute or keep old
		System.out.println("Enter new minute or -1 to keep old");
		int userMinute = Integer.parseInt(input.nextLine());
		if(userMinute!=-1)
			temp.setMinute(userMinute);
		
		//Only if something has changed remove old entry and enter new one
		if(!temp.equals(eventsList.get(userInput-1)))
		{
			eventsList.remove(userInput-1);
		
			int i =0;
			while(i < eventsList.size() &&temp.compareTo(eventsList.get(i))>0)
			{
				i++;
			}
			eventsList.add(i, temp);
		}	
		menuSelection();
		
	}
	public static void displayEvents()
	{
		for(HourEvent e: eventsList)
		{
			System.out.println(e);
		}
		menuSelection();
	}
}
