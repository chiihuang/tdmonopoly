package Model;
import View.GameBoard;
import java.util.Iterator;


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
		int temp = new java.util.Random().nextInt(6)+1;
		for (int i = temp; i > 0; i--)
			map.move(player);
		
		return temp;
	}
	boolean act(Player player)
	{
		/*
		 * make every action on the block act on the player
		 * use gb to show everyevent
		 * if the player dies in this round , print the result of death here
		 * 
		 */
		Iterator<Action> temp = map.map[player.getX()][player.getY()].command.iterator();
		while(temp.hasNext())
		{
			(temp.next()).act(player);
			if (player.getHP() > 0)
				return false;
		}
		return true;
	}
	public void play()
	{
		map = new Map(arr.toArray());
		gb = new GameBoard(map, this);
		while(arr.hasNext())
		{
			Player temp = arr.next();
			gb.setPerson(temp);//miss the part of computer player
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

}