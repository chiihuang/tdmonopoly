package Model;


public class Game
{
	CircularQueue<Player> arr;
	Map map;
	public Game(Player[] _arr)
	{
		arr = new CircularQueue<Player>(_arr);
	}
	public void choice()
	{
		
	}
	public void play()
	{
		map = new Map(arr.toArray());
		while(arr.hasNext())
		{
			
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
}