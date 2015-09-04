package Challenge_02;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * create a short text adventure that will call the user by their name. 
 */
public class Challenge_2
{
	public static Scanner input;
	public static Player hero;
	private static Room[] roomList = new Room[15];
	private static int width=5;
	private static int currentRoom=12;
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		hero = new Player();
		System.out.println("What is the hero's name? ");
		System.out.print("> ");
		String name = input.nextLine();
		
		//Default name
		if(name.length()==0)
			name="Blankson";
		hero.setName(name);
		createWorld();
		System.out.println(hero.getName()+" wakes up in a strange place with a heavy fog around them. They cannot see too far ahead. They lean against an ice cold metal door. They don't know how they got there but they must escape.");
		
		menu();
	}

	public static void menu()
	{
		if(hero.hasItem("Freedom"))
			System.out.println("You win!");
		else
		{
			System.out.println("What will "+ hero.getName()+ " do?");
			System.out.println("0 Move North");
			System.out.println("1 Move West");
			System.out.println("2 Move East");
			System.out.println("3 Move South");
			ArrayList<RoomObject> options = roomList[currentRoom].getChoices();
			for(int i = 0; i<options.size(); i++)
			{
				System.out.println((4+i) +" "+options.get(i).getDescription());
			}
			
			int userChoice = -1;
			do
			{
				userChoice = Integer.parseInt(input.nextLine());
				if(userChoice<0 || userChoice>options.size() +4)
					System.out.println("Invalid Choice");
			} while(userChoice<0 || userChoice>options.size() +4);
			
			if(userChoice==0)
			{
				if(currentRoom-5>0)
				{
					currentRoom-=5;
				}
				else
					System.out.println("Cannot move there");
			}
			if (userChoice ==1)
			{
	
	
				if(currentRoom-1>=0&&(currentRoom%width) - (currentRoom-1)%width==1 && roomList[currentRoom-1]!=null)
					currentRoom-=1;
				else
					System.out.println("Cannot move there");
			}
			if (userChoice ==2)
			{
				if((currentRoom%width+1)-(currentRoom%width)==1 && roomList[currentRoom+1]!=null)
					currentRoom+=1;
				else
					System.out.println("Cannot move there");
			}
			if(userChoice==3)
			{
				if(currentRoom+5<roomList.length)
				{
					currentRoom+=5;
				}
				else
					System.out.println("Cannot move there");
			}
			if(userChoice>3)
			{
				System.out.println(options.get(userChoice-4).activate());
			}
			menu();
		}
	}
	public static void createWorld()
	{
		String heroName = hero.getName();
		//ADD MORE STUFF TO LOOK AT 
		roomList[0] = new Room(0);
		roomList[0].addRoomObject(new RoomObject(hero, "Inspect a hammer that rests on a hook","The hammer appears to have \"IceSmasher\" written on it" , "Door Key", "iceblock", heroName+" smashes the iceblock free with the hammer and collects the key"));
		roomList[0].addRoomObject(new RoomObject(hero, "Inspect a mushroom that sits beneath a small anvil", heroName+" collects the mushroom", "mushroom"));
		roomList[1] = new Room(1);
		roomList[1].addRoomObject(new RoomObject(hero, "Inspect a blade of grass", "The grass cuts "+heroName+"'s hand", ""));
		roomList[2] = new Room(2);
		roomList[2].addRoomObject(new RoomObject(hero, "Inspect a road sign", "West to the blacksmiths, East towards the witch", ""));
		roomList[3] = new Room(3);
		roomList[3].addRoomObject(new RoomObject(hero, "Inspect a spell book", "The book is covered in scribbles that "+heroName+" cannot understand", ""));
		roomList[3].addRoomObject(new RoomObject(hero, "Inspect a boiling cauldron", heroName+" sees a key sliding around the bottom of a boiling cauldron too heavy to move", "iceblock", "icespell", heroName+" freezes the cauldron revealing a key in an iceblock. They collect the frozen key"));
		roomList[4] = null;
		roomList[5] = new Room(5);
		roomList[5].addRoomObject(new RoomObject(hero, "Inspect a small rock to overturn", "Bugs crawl out from under the rock", ""));
		roomList[5].addRoomObject(new RoomObject(hero, "Inspect a glyph", heroName+" nearly faints as they are overcome with some mystic energy. "+heroName+ " feels cold", "icespell"));
		roomList[6] = new Room(6);
		roomList[6].addRoomObject(new RoomObject(hero, "Inspect surroundings", heroName+" cautiously inspects the inside of a dirt tunnel. A cold air surrounds them. A light shines into the tunnel from the West", ""));
		roomList[7] = new Room(7);
		roomList[7].addRoomObject(new RoomObject(hero, "Inspect surroundings", heroName+" notices a tunnel to the West and clear path to the North", ""));
		roomList[8] = null;
		roomList[9] = null;
		roomList[10] = null;
		roomList[11] = null;
		roomList[12] = new Room(12);
		roomList[12].addRoomObject(new RoomObject(hero, "Inspect surroundings", heroName+" finds themself closed in on 3 sides. A door with runic markings looms behind them", ""));
		roomList[12].addRoomObject(new RoomObject(hero, "Inspect ominous door", heroName+" tries with all of their might to open the door. It won't budge", "Freedom", "Door Key", heroName+" slowly pushes the key into the door and feels the chambers unlocking. "+heroName+" has escaped."));
		// ADD the final door to escape
		roomList[13] = null;
		roomList[14] = null;

		
	}
}
