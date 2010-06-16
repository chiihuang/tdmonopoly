package Model;

public  abstract class Tower
{
	protected int x;
	protected int y;
	protected int damage;
	protected int range;
	
	public void setPosition(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}
	
	public void setDamage(int _damage)
	{
		this.damage = _damage;
	}
	
	public void setRange(int _range)
	{
		this.range = _range;
	}
	
	public Tower()
	{
		
	}
	/*¸Ñºc¤l*/

}
