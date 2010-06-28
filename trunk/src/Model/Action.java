package Model;
import java.util.Scanner;

public abstract class Action
{
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
						if (temp.equalsIgnoreCase("Tower")&&taker.getWood()<50)
						{
							System.out.println("�ܩ�p�I�A�S�����������Y��I");
						}
						else if (temp.equalsIgnoreCase("Tower"))
						{
							taker.setWood(taker.getWood() - 50);
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
	public Attack(Tower _tower,int _damage)
	{
		tower = _tower;
		damage = _damage;
	}

	public void act(Player taker)
	{
		if(!taker.getOwner().equals(tower.getOwner()))
		{
			taker.setHP(taker.getHP()-damage);
			System.out.println(taker.getOwner() + "����" + tower.getOwner() +
					"�b" +tower.x + "," + tower.y + "��" + damage + "�I�ˮ`!");			
		}	
	}
}





