package Model;

public class Tower implements Chess
{
	int x;
	int y;
	private int damage;
	private int range;
	private int Level;
	String icon;
	Player owner;
	Map map;
	Attack atk;

	public void setPosition(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}
	
	void setDamage()
	{
		damage = 10 + Level*5;
	}
	
	int getDamage()
	{
		return damage;
	}
	
	void setRange()
	{
		range = Level;
	}
	
	int getRange()
	{
		return range;
	}
	int LevelUpWood()
	{
		return 20*Level + 50;
	}
	void levelUp()
	{
		withdraw();
		Level += 1;
		setDamage();
		setRange();
		atk = new Attack(this, damage);
		for (int i = x - range; i <= x + range; i++)
			for (int j = y - range; j <= y + range; j++)
			{
				if (i < 10 && i >= 0 && j < 11 && j >=0)
					if (map.map[i][j].field == 1)
					{
						map.map[i][j].command.add(atk);
						map.map[i][j].command.add(new TowerLevelUp(this));
					}
			}
	}
	
	public Tower(Player _owner, Map _map)
	{
		map = _map;
		owner = _owner;
		
		levelUp();
	}
	public String getIcon()
	{
		return "lv" + Level;
	}
	public String getOwner()
	{
		return owner.getOwner();
	}
	public void withdraw()
	{
		for (int i = x - range; i <= x + range; i++)
			for (int j = y - range; j <= y + range; j++)
			{
				if (i < map.map.length && i >= 0 && j < map.map[0].length && j >=0)
					if (map.map[i][j].field == 1)
						map.map[i][j].command.remove(atk);
			}
	}
	public java.awt.Color getColor()
	{
		return owner.getColor();
	}
	public int getType()
	{
		return 2;
	}
	public int getNum()
	{
		return owner.getNum();
	}
}
