package Challenge_2;

public class RoomObject
{
	private String interactiveText;
	private String item;
	private String description;
	private String puzzleKey;
	private String unlockedText;
	private Player hero;
	
	public RoomObject(Player p, String desc, String text, String i)
	{
		hero=p;
		description=desc;
		interactiveText=text;
		item=i;
	}
	public RoomObject(Player p, String desc, String text, String i, String k, String u)
	{
		hero=p;
		interactiveText=text;
		item=i;
		puzzleKey=k;
		description=desc;
		unlockedText=u;
	}
	public String activate()
	{
		if(puzzleKey==null)
		{
			if(!item.equals(""))
				hero.giveItem(item);
			return interactiveText;
		}
		else
		{
			if(hero.hasItem(puzzleKey))
			{
				hero.giveItem(item);
				return unlockedText;
			}	
			else
				return interactiveText;
		}
	}
	public String getDescription()
	{
		return description;
	}
}
