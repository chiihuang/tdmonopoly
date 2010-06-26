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
	
	Block[][] map = new Block[11][10];
	private void initMap()
	{
		/*
		 * ��ϤƤ@��11*10��map
		 * �ó]�w�a��
		 * 	���O�b���@��i�H�R���@�檺�a
		 * 	���b�Ӯ沾�ʪ��U�@��O���̡C
		 */
		int i, j;
		
		for(i = 0; i < 11; i++)
			for(j = 0; j < 10 ; j++)
			{
				
			}
		
		
		
	}
	public Map(Player[] arr)
	{
		/*
		 * 1. initMap()
		 * 2. set players on the map
		 */
		initMap();
		
	}
	public String[] getIcon(int x, int y)
	{
		/*
		 * �^�Ǩ��String
		 * ���w x y �y�СA�^�ǸӦ�m�W����T
		 * 
		 * �Ĥ@�Ӧ^�Ǧa�ϤW���H���m�W
		 * �ĤG�Ӧ^�Ǫ�����ɦ�m
		 * 
		 */
	}
	public void move(Player p)
	{
		if(map[p.getX()][p.getY()].next == 0)
			p.setPostion(p.getX()+1,p.getY());
		
		if(map[p.getX()][p.getY()].next == 1)
			p.setPostion(p.getX()-1,p.getY());	
		
		if(map[p.getX()][p.getY()].next == 2)
			p.setPostion(p.getX(),p.getY()+1);
		
		if(map[p.getX()][p.getY()].next == 3)
			p.setPostion(p.getX(),p.getY()-1);
		
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
	
	int next;
	
	/*
	 * kind of block
	 */
	int field;
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