package Model;

public abstract class Action
{
	Player actor;
	public abstract void act(Player taker);
}

class Purchase extends Action
{
	Block ground;
	public Purchase(Block _ground)
	{
		ground = _ground;
	}
	public void act(Player taker)
	{
		if (taker instanceof Human)
		{
			if (new View.YesNoDialog("�O�_�n�R�U").show())
			{
				ground.container = new Tower(taker);
			}
		}
	}
}