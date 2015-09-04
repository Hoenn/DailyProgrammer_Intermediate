package Challenge_02;

import java.util.ArrayList;

public class Player
{
	private String name;
	private ArrayList<String> inventory;
	public Player()
	{
		name="";
		inventory = new ArrayList<String>();
	}
	public void setName(String s)
	{
		name= s;
	}
	public String getName()
	{
		return name;
	}
	public ArrayList<String> getInventory()
	{
		return inventory;
	}
	public void giveItem(String s)
	{
		if(!inventory.contains(s))
			inventory.add(s);
	}
	public boolean hasItem(String s)
	{
		return inventory.contains(s);
	}
}
