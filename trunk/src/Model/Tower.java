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
	
	void levelUp()
	{
		Level += 1;
		setDamage();
		setRange();
	}
	
	public Tower(Player _owner, Map _map)
	{
		map = _map;
		owner = _owner;
		Level = 1;
	}
	public String getIcon()
	{
		return "pic/lv" + Level;
	}
	public String getOwner()
	{
		return owner.getOwner();
	}
	

}
