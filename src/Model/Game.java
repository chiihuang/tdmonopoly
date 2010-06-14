package Model;
import View.GameBoard;


public class Game
{
	CircularQueue<Player> arr;
	Map map;
	GameBoard gb;
	public Game(Player[] _arr)
	{
		arr = new CircularQueue<Player>(_arr);
	}
	public int throwDice(Player player)
	{
		/*
		 * Make the movement
		 */
		return 1;//not finished
	}
	boolean act(Player player)
	{
		/*
		 * make every action on the block act on the player
		 * 
		 * if the player dies in this round , print the result of death here
		 * 
		 */
		return true;//not finished, true means need not to remove the player
	}
	public void play()
	{
		map = new Map(arr.toArray());
		gb = new GameBoard(map, this);
		while(arr.hasNext())
		{
			Player temp = arr.next();
			if (arr.isHuman())
				gb.setPerson((Human)temp);//miss the part of computer player
			gb.show();//include to make move
			if (!act(temp))
				arr.remove();
		}
		gb.showResult();
	}
}

class CircularQueue<T>
{
	T[] arr;
	int pointer;
	public CircularQueue(T[] _arr)
	{
		if (_arr != null)
			arr = _arr;
		pointer = 0;
	}
	public T next()
	{
		return null;// not finished
	}
	public void remove()
	{
		/*
		 * Remove the current T
		 */
	}
	public boolean hasNext()
	{
		return true;//not finishied
	}
	public T[] toArray()
	{
		return null;//not finished
	}
	public boolean isHuman()
	{
		return true;//not finished
	}
}