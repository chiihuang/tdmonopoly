package Model;

import java.util.ArrayList;

public class Map
{
	Block[][] map;
	void initMap()
	{
		
	}
}

class Block
{
	int next;
	Block beside;
	ArrayList<Action> command = new ArrayList<Action>(0);
	Object container;
}