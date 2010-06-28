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
				char num;
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
				switch(map.getIcon(i, j).num)
				{
					case 0:
						num = '0';
						break;
					case 1:
						num = '1';
						break;
					case 2:
						num = '2';
						break;
					case 3:
						num = '3';
						break;			
					case -1:
						num = ' ';
						break;
					default:
						num = '.';
				}
				System.out.printf("%c%c ",type,num);
			}
			System.out.println();
			System.out.println();
		}
		
		
	}
	public void showResult()
	{
		Player[] temp = arr.toArray();
		for (Player tem : temp)
		{
			System.out.println("玩家：" + tem.getOwner() + (tem.checkalive()?"":"(死亡)"));
			System.out.println("血量：" + tem.getHP());
			System.out.println("木頭：" + tem.getWood());
			System.out.println("木廠：" + tem.getlumbermill());
			System.out.println();
		}
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
			System.out.println("現在是"+temp.getOwner()+"的回合：");
			System.out.println("按Enter來丟骰子或輸入\"show\"來查看各玩家情報");
			String teml = input.nextLine();//stop for while
			while(teml.equalsIgnoreCase("show"))
			{
				showResult();
				System.out.println("按Enter來丟骰子或輸入\"show\"來查看各玩家情報");
				teml = input.nextLine();
			}
			throwDice(temp);
			show();
			System.out.println("按下Enter來繼續...");
			if (!act(temp))
				arr.remove();
			for (Player tem : arr.toArray()) tem.gainWood();
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