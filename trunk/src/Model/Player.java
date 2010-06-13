package Model;
import java.util.ArrayList;

public abstract class Player
{
	private String name;
	private int Wood;
	private int HP;
	private int x;
	private int y;
	private ArrayList<Tower> owning;
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

	public Player()
	{
		owning = new ArrayList<Tower>(0);
	}
}
