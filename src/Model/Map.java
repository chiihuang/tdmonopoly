package Model;

import java.util.ArrayList;

public class Map
{
	/*
	 * map[x][y] : 
	 * 
	 * y - - - - - - O
	 * .             |
	 * .             |
	 * .             |
	 * 3             |
	 * 2             |
	 * 1             |
	 * 0 1 2 3 . . . x
	 * 
	 */
	Block[][] map;
	private void initMap()
	{
		/*
		 * ��ϤƤ@��10X10��map
		 * �ó]�w�a��
		 * 	���O�b���@��i�H�R���@�檺�a
		 * 	���b�Ӯ沾�ʪ��U�@��O���̡C
		 */
		
	}
	public Map(Player[] arr)
	{
		/*
		 * 1. initMap()
		 * 2. set players on the map
		 */
		initMap()
		
	}
	public String getIcon(int x, int y)
	{
		/*
		 * ���w x y �y�СA�^�ǸӦ�m�W�����ɸ�T
		 */
	}
	public void move()
	{
		
	}
}

class Block
{
	
	/*
	 * ���p�o��O�樫���a
	 * ���w�U�@�檺��V�O����
	 * 
	 * 0 : [+][ ]
	 * 1 : [-][ ]
	 * 2 : [ ][+]
	 * 3 : [ ][-]
	 */
	public int next(int x,int y)
	{
	if(x == 0)
		{
		if(y == 9) return 0;
		else return 2;
		}
	else if(x == 9)
		{
		if(y == 0) return 1;
		else return 3;
		}
	else if(y == 0)return 1;
	else if(y == 9)return 0;
	else return -1;	
	}
	
	/*
	 * ���p�o��O�樫���a
	 * ���w�i�H�ʶR���a�O���@��Block
	 */
	Block beside;
	
	/*
	 * ���p�o��O�樫���a
	 * command�N�O�Ψ��x�s�n���檺�ʧ@
	 */
	ArrayList<Action> command = new ArrayList<Action>(0);
	/*
	 * �ˤJPlayer�BTower��������Reference
	 * ���L��ϥΪ��u��Chess�o��interface���w���\��C
	 */
	Chess container;
}