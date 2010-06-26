package Model;

public abstract class Action
{
	Player actor;
	public abstract void act(Player taker);
}

class Purchase extends Action
{
	Block ground;
	int x, y;
	public Purchase(Block _ground, int _x, int _y)
	{
		ground = _ground;
		x = _x;
		y = _y;
	}
	public void act(Player taker)
	{
		if (taker instanceof Human)
		{
			if (new View.YesNoDialog("�O�_�n�R�U").show())
			{
				Tower tower = new Tower(taker);
				tower.setPosition(x, y);
				ground.container = tower;
				taker.addTower(tower);
			}
		}
	}
}