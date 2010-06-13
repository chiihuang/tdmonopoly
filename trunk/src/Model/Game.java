package Model;
import View.GameBoard;


public class Game
{
	CircularQueue<Player> arr;
	Map map;
	public Game(Player[] _arr)
	{
		arr = new CircularQueue<Player>(_arr);
	}
	public void throwDice()
	{
		
	}
	public void play()
	{
		map = new Map(arr.toArray());
		GameBoard gb = new GameBoard(map, this);
		while(arr.hasNext())
		{
			if (arr.isHuman())
				gb.setPerson((Human)arr.next());
			gb.show();
		}
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