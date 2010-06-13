package Model;

import java.util.ArrayList;

public class Map
{
	/*
	 * map[x][y] : 
	 * 
	 * y - - - - - - O
	 * .             |
	 * .             |
	 * .             |
	 * 3             |
	 * 2             |
	 * 1             |
	 * 0 1 2 3 . . . x
	 * 
	 */
	Block[][] map;
	private void initMap()
	{
		/*
		 * Edit the map
		 * Put Player
		 */
	}
	public Map(Player[] arr)
	{
		/*
		 * 1. initMap()
		 * 2. set players on the map
		 */
	}
	public void move()
	{
		
	}
}

class Block
{
	/*
	 * 0 : [+][ ]
	 * 1 : [-][ ]
	 * 2 : [ ][+]
	 * 3 : [ ][-]
	 */
	int next;
	Block beside;
	ArrayList<Action> command = new ArrayList<Action>(0);
	Object container;
}