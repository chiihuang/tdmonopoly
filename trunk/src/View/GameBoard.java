package View;
import Model.Map;
import Model.Game;
import Model.Human;

public class GameBoard
{
	Map map;
	Game game;
	Human hmn;
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
}
