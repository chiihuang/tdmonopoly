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
	 * �i�qGame���䮳�쪺Port���G
	 * 
	 * void play() : �o�Ӥ��n�ΡA�o�O��Menu�Ϊ�method
	 * int throwDice(Player) �G �N�{�e���a��i�h��A�i�H���D���a���F�X�B�C
	 * 						         �b�o�̡A�����o�Ӿާ@���ɭԡA�N������v���ٵ�Game()
	 * 						   (��return�Y�i����)
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
		 * �N�C���e��show�X��
		 */
	}
	public void showResult()
	{
		/*
		 * �N�C�����Gshow�X��
		 */
	}
}
