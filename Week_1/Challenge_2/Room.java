package Challenge_2;

import java.util.ArrayList;

public class Room
{
	private ArrayList<RoomObject> objectList;
	private int roomID;
	
	public Room(int rID)
	{
		roomID=rID;
		objectList = new ArrayList<RoomObject>();
	}
	public ArrayList<RoomObject> getChoices()
	{
		return objectList;
	}
	public void addRoomObject(RoomObject ro)
	{
		objectList.add(ro);
	}
}
