package Model;
import View.GameBoard;
import java.util.Iterator;


public class Game
{
	CircularQueue<Player> arr;
	Map map;
	GameBoard gb;
	public Game(Object[] _arr)
	{
		Player[] temp = new Player[_arr.length];
		for (int i = 0; i < temp.length; i++)
			temp[i] = (Player)_arr[i];
		arr = new CircularQueue<Player>(temp);
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
	public Player[] getplayer()
	{
		return arr.toArray();
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
	boolean[] alive;
	
	
	
	public CircularQueue(T[] _arr)
	{
		if (_arr != null)
			arr = _arr;
		pointer = 0;
	}
	
	public void aliveinit()
	{
		for(int i = 0;i<arr.length;i++)
			alive[i] = true;
	}
	
	public T next()
	{
		
		T temp = null;
			for(int i = 0 ; i < arr.length ; i++)
			if(alive[(pointer+i)%arr.length])
			{
				temp = arr[(pointer+i)%(arr.length)];
				pointer = (pointer+i)%(arr.length);
				break;
			}
				
		return temp;// maybe finished
	}
	public void remove()
	{
		alive[pointer - 1] = false ;
	}
	public boolean hasNext()
	{
		int check = 0;
		
		for(int i=0 ; i < arr.length-1 ; i++ )
			if(alive[(pointer+i)%(arr.length)])
				check++;
		
		if(check > 0)
			return true;
		
		else return false;//maybe finished
	}
	public T[] toArray()
	{
		return arr;//maybe finished
	}

}