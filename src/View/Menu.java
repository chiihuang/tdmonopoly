package View;
import Model.Initialize;

public class Menu {
	/*
	 * 從Initialize可以用的Port有：
	 * 
	 * void setPlayer(int, int) ：  第一個int代表是幾號人物
	 * 							       第二個int傳入0代表不啟用，-1是電腦，1是玩家
	 * 
	 * void start() ： 開始遊戲。Initialize那邊會開啟一個新的畫面：GameBoard
	 * 
	 */
	Initialize init;
	public Menu(Initialize _init)
	{
		init = _init;
	}
}
