package Model;
import java.util.ArrayList;

public abstract class Player implements Chess
{
	private String name;
	private int Wood;
	private int HP;
	private int x;
	private int y;
	private int num;
	private java.awt.Color color;
	private ArrayList<Tower> owning;
	protected String icon; // �s���ɸ�T�Ϊ�
	private int lumbermill; 
	private boolean alive;
	
	void setName(String _name)
	{
		name = new String(_name);
	}
	
	void setHP(int _HP)
	{
		if (_HP <= 0)
			HP = 0;
		else
			HP = _HP;
	}
	void setWood(int _Wood)
	{
		if (_Wood <= 0)
			Wood = 0;
		else
			Wood = _Wood;
	}
	void setPostion(int _x, int _y){x = _x; y = _y;}
	public int getHP(){return HP;}
	public int getWood(){return Wood;}
	public int getNum(){return num;}
	void addTower(Tower tower)
	{
		owning.add(tower);
	}
	public Player(int _num)
	{
		num = _num;
		owning = new ArrayList<Tower>(0);
		Wood = 50;
		HP = 250;
		alive = true;
		/*
		 * setColor
		 */
	}
	public boolean checkalive()
	{
		return alive;
	}
	
	public void die()
	{
		alive = false;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public String getOwner()
	{
		return new String(name);
	}
	public String getIcon()
	{
		return new String(icon);
	}

	public int getlumbermill()
	{
		return lumbermill;
		
	}
	public java.awt.Color getColor()
	{
		return color;
	}
	
}
	
	