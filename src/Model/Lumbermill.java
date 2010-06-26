package Model;

public class Lumbermill implements Chess
{
	int x;
	int y;

	String icon;
	Player owner;
	Map map;
	
	public void setPosition(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}
	
	public Lumbermill(Player _owner, Map _map)
	{
		map = _map;
		owner = _owner;
	}
	
	
	public String getOwner()
	{
		return owner.getOwner();
	}
	
	public String getIcon()
	{
		return "pic/lum" ;
	}

}
