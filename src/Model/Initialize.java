package Model;
import java.util.TreeMap;

import View.Menu;

public class Initialize
{
	private java.util.Map<Integer, Player> arr = new TreeMap<Integer, Player>();
	public void setPlayer(int num, int type)
	{
		/*
		 * num  代表順序
		 * type 代表玩家類型
		 * 		-1 : Computer
		 * 		 0 : Not Activate
		 * 		 1 : Human
		 */
		switch(type)
		{
			case  1:
				arr.put(new Integer(num), new Human());
				break;
			case -1:
				arr.put(new Integer(num), new Computer());
			default:
				arr.remove(new Integer(num));
		}
	}
	public Game start()
	{
		return new Game((Player[])this.arr.values().toArray());		
	}
	public Initialize()
	{
		Menu view = new Menu();
		view.setModel(this);//make the viewer can control the model setting
	}
}

