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
				System.out.println("是否要買下地？(Yes or No)");
				String temp = input.next();
				if (temp.equalsIgnoreCase("yes")||temp.equalsIgnoreCase("y"))
				{
					while(true)
					{
						System.out.println("是要買塔還是伐木場？(Tower or Lumbermill)");
						temp = input.next();
						if ((temp.equalsIgnoreCase("Tower")||temp.equalsIgnoreCase("T"))&&taker.getWood()<50)
						{
							System.out.println("很抱歉！你沒有足夠的木頭喔！");
						}
						else if (temp.equalsIgnoreCase("Tower")||temp.equalsIgnoreCase("T"))
						{
							taker.setWood(taker.getWood() - 50);
							Tower tower = new Tower(taker, map);
							tower.setPosition(x, y);
							map.map[x][y].container = tower;
							taker.addTower(tower);
							active = false;
							break;
						}
						else if (temp.equalsIgnoreCase("Lumbermill")||temp.equalsIgnoreCase("L"))
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
		System.out.println("INNN");
		if(taker!=tower.owner)
		{
			taker.setHP(taker.getHP()-damage);
			System.out.println(taker.getOwner() + "受到" + tower.getOwner() +
					"在" +tower.x + "," + tower.y + "的" + damage + "點傷害!");			
		}	
	}
}

class TowerLevelUp extends Action
{
	Tower tower;
	public TowerLevelUp(Tower _tower)
	{
		tower = _tower;
	}
	public void act(Player taker)
	{
		
		Scanner input = new Scanner(System.in);
		if (taker == tower.owner)
		{
			while(true)
			{
				System.out.println("是否要升級塔呢？(Yes or No)");
				String temp = input.next();
				if ((temp.equalsIgnoreCase("Yes")||temp.equalsIgnoreCase("y"))&&taker.getWood()<tower.LevelUpWood())
				{
					System.out.println("很抱歉！升下一級的需求是："+tower.LevelUpWood());
					return;
				}
				else if (temp.equalsIgnoreCase("Yes")||temp.equalsIgnoreCase("y"))
				{
					tower.levelUp();
				}
				else if (temp.equalsIgnoreCase("No")||temp.equalsIgnoreCase("N"))
				{
					return;
				}

			}			
		}
	}
	
}