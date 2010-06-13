package Model;
import java.util.TreeMap;
import Viewer.Viewer;

public class Initialize
{
	java.util.Map<Integer, Player> arr = new TreeMap<Integer, Player>();
	public void setPlayer(int num, int type)
	{
		/*
		 * num  代表順序
		 * type 代表玩家類型
		 * 		-1 : Computer
		 * 		 0 : Not Activate
		 * 		 1 : Human
		 */
		
	}
	public Initialize()
	{
		Viewer view = new Viewer();
		view.setModel(this);//make the viewer can control the model setting
	}
}
