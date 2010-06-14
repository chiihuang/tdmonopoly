package Model;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import View.Menu;

public class Initialize
{
	private java.util.Map<Integer, Player> arr = new TreeMap<Integer, Player>();
	public void setPlayer(int num, int type)
	{
		/*
		 * num  �N����
		 * type �N���a����
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
	public int checkPlayer()
	{
		/*
		 * return 0   �G �S�����a
		 * return -1�G �S�����H�W
		 * return 1   �G �i�H���F
		 */
		

		return 1;//not finished yet
	}
	public Initialize()
	{
		Menu view = new Menu(this);;//make the viewer can control the model setting
	}
}

