package View;
import Model.Map;
import Model.Game;
import Model.Human;

public class GameBoard
{
	Map map;
	Game game;
	Human hmn;
	/*
	 * 可從Game那邊拿到的Port有：
	 * 
	 * void play() : 這個不要用，這是給Menu用的method
	 * int throwDice(Player) ： 將現前玩家丟進去後，可以知道玩家走了幾步。
	 * 						         在這裡，執行到這個操作的時候，就把執行權交還給Game()
	 * 						   (用return即可交還)
	 * 
	 */
	public GameBoard(Map _map, Game _game)
	{
		map = _map;
		game = _game;
	}
	public void setPerson(Human _hmn)
	{
		hmn = _hmn;
	}
	public void show()
	{
		/*
		 * 將遊戲畫面show出來
		 */
	}
	public void showResult()
	{
		/*
		 * 將遊戲結果show出來
		 */
	}
}
