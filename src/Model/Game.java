package Model;
import View.GameBoard;
import java.util.Iterator;
import java.util.Scanner;

public class Game
{
	CircularQueue<Player> arr;
	Map map;
	//GameBoard gb;
	Game itself=this;
	public void create_Game(Player[] _arr)
	{
		arr = new CircularQueue<Player>(_arr);
		arr.aliveinit();
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
			if (player.getHP() < 0)
				return false;
		}
		return true;
	}
	public Player[] getplayer()
	{
		return arr.toArray();
	}
	public void show()
	{
		/*
		 * show in cmd mode
		 */
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 11; j++)
			{
				char type;
				switch(map.getIcon(i,j).type)
				{
					case 1:
						type = 'P';
						break;
					case 2:
						type = 'T';
						break;
					case 3:
						type = 'L';
						break;
					default:
						type = ' ';
						break;
				}
				System.out.printf("%c%d",type,map.getIcon(i, j).num);
			}
			System.out.println();
			System.out.println();
		}
		
		
	}
	public void showResult()
	{
		/*
		 * show who wins the game
		 */
	}
	public void play()
	{
		Scanner input = new Scanner(System.in);
		map = new Map();
		map.create_Map(arr.toArray());
		while(arr.hasNext())
		{
			Player temp = arr.next();
			show();
			System.out.println("按下Enter來丟骰子...");
			input.nextLine();//stop for while
			throwDice(temp);
			show();
			System.out.println("按下Enter來繼續...");
			if (!act(temp))
				arr.remove();
			for (Player tem : arr.toArray()) tem.setWood(temp.getWood() + temp.getlumbermill());
		}
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
		alive = new boolean[_arr.length];
	}
	
	public void aliveinit()
	{
		for(int i = 0;i<arr.length;i++)
			alive[i] = true;
	}
	
	public T next()
	{
		
		T temp = null;
			for(int i = 1 ; i <= arr.length ; i++)
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
		
		for(int i=1 ; i <= arr.length-1 ; i++ )
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