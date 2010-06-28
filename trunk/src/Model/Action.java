package Model;
import java.util.Scanner;

public abstract class Action
{
	Player actor;
	public abstract void act(Player taker);
}

class Purchase extends Action
{
	Scanner input = new Scanner(System.in);
	Map map;
	boolean active;
	int x, y;
	public Purchase(Map _map, int _x, int _y)
	{
		active = true;
		map = _map;
		x = _x;
		y = _y;
	}
	public void act(Player taker)
	{
		if (taker instanceof Human)
		{
			/*if (new View.YesNoDialog("�O�_�n�R�U").show())
			{
				if(new View.YesNoDialog("��OR����").show())
				{
				Tower tower = new Tower(taker, map);
				tower.setPosition(x, y);
				map.map[x][y].container = tower;
				taker.addTower(tower);
				}
				else 
				{
				Lumbermill lumber = new Lumbermill(taker, map);
				taker.setLumbermill(taker.getlumbermill() + 1);
				lumber.setPosition(x, y);
				map.map[x][y].container = lumber;
				}
		     }*/
			while(active)
			{
				System.out.println("�O�_�n�R�U�a�H(Yes or No)");
				String temp = input.next();
				if (temp.equalsIgnoreCase("yes"))
				{
					while(true)
					{
						System.out.println("�O�n�R���٬O�����H(Tower or Lumbermill)");
						temp = input.next();
						if (temp.equalsIgnoreCase("Tower"))
						{
							Tower tower = new Tower(taker, map);
							tower.setPosition(x, y);
							map.map[x][y].container = tower;
							taker.addTower(tower);
							active = false;
							break;
						}
						else if (temp.equalsIgnoreCase("Lumbermill"))
						{
							Lumbermill lumber = new Lumbermill(taker, map);
							taker.setLumbermill(taker.getlumbermill() + 1);
							lumber.setPosition(x, y);
							map.map[x][y].container = lumber;
							active = false;
							break;
						}
					}
					return;
				}
				else if (temp.equalsIgnoreCase("no"))
					return;
			}
		}
	}
}

class Attack extends Action
{
	int damage;
	Tower tower;
	public Attack(Player actor,int _damage)
	{
		this.actor = actor;
		damage = _damage;
	}

	public void act(Player taker)
	{
		if(taker!=actor)
		{
			taker.setHP(taker.getHP()-damage);
			System.out.println(taker + "����" + actor + "��" + damage + "�I�ˮ`!");			
		}	
	}
}





