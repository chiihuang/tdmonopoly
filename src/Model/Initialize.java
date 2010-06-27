package Model;
import java.util.TreeMap;
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
		if (num <= 3 && num >= 0)
			switch(type)
			{
				case  1:
					arr.put(new Integer(num), new Human(num));
					break;
				case -1:
					arr.put(new Integer(num), new Computer(num));
					break;
				default:
					arr.remove(new Integer(num));
			}
	}
	public void start()
	{
		Player[] temp = new Player[arr.size()];
		Game gm = new Game();
		gm.create_Game(arr.values().toArray(temp));
		gm.play();
	}
	public int checkPlayer()
	{
		/*
		 * return 0   �G �S�����a
		 * return -1�G �S�����H�W
		 * return 1   �G �i�H���F
		 */
		boolean check_human = false;
		for (int i = 0; i < 4; i++)
			if (arr.get(new Integer(i)) instanceof Human)
				check_human = true;
		if (!check_human)
			return 0;
		else if (arr.size() < 2)
			return -1;
		else
			return 1;//not finished yet
	}
	public void run()
	{
		Menu view = new Menu(this);//make the viewer can control the model setting
	}
}

