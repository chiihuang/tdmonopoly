package Model;

public abstract class Action
{
	Player actor;
	public abstract void act(Player taker);
}

class Purchase extends Action
{
	Map map;
	int x, y;
	public Purchase(Map _map, int _x, int _y)
	{
		map = _map;
		x = _x;
		y = _y;
	}
	public void act(Player taker)
	{
		if (taker instanceof Human)
		{
			if (new View.YesNoDialog("是否要買下").show())
			{
				Tower tower = new Tower(taker, map);
				tower.setPosition(x, y);
				map.map[x][y].container = tower;
				taker.addTower(tower);
			}
		}
	}
}

class Attack extends Action
{
	int damage;
	public Attack(Player actor, int _damage)
	{
		this.actor = actor;
		damage = _damage;
	}

	public void act(Player taker)
	{
		if(taker!=actor)
		taker.setHP(taker.getHP()-damage);	
	}
}





