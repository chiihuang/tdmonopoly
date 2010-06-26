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
	private ArrayList<Tower> owning;
	protected String icon; // 存圖檔資訊用的
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
	int getHP(){return HP;}
	int getWood(){return Wood;}
	int getNum(){return num;}
	public Player(int _num)
	{
		num = _num;
		owning = new ArrayList<Tower>(0);
		Wood = 50;
		HP = 250;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}


}
	
	