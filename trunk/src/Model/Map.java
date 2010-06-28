package Model;

import java.util.ArrayList;
import java.util.Random;
public class Map
{
	
	Random rnd = new Random();
	Block[][] map = new Block[10][11];
	private void initMap()
	{
		
		int i, j;
		
		for( j = 0; j < 11 ; j++ )
			for(i = 0; i < 10 ; i++)
			{
				map[i][j] = new Block();
				if( 
					((i == 0 && j >= 2) && (i == 0 && j <= 8))
				||	((i == 9 && j >= 2) && (i == 9 && j <= 8))	
				||	((i >= 2 && j == 0) && (i <= 7 && j == 0))
				||	((i >= 2 && j == 10) && (i <= 7 && j == 10)))
				{
					map[i][j].field = 2;
					map[i][j].next = -1;
				}
				
				else if((j == 1 && i >= 2) && (j == 1 && i <= 7))
				{
					map[i][j].field = 1;
					map[i][j].beside = map[i][j-1];
					map[i][j].next = 1;
					map[i][j].command.add ( new Purchase(this,i,j-1));
				}
				
				else if((j == 9 && i >= 2) && (j == 9 && i <= 7))
				{
					map[i][j].field = 1;
					map[i][j].beside = map[i][j+1];
					map[i][j].next = 0;
					map[i][j].command.add ( new Purchase(this,i,j+1));
				}
				
				else if((j >= 2 && i == 1) && (j <= 8 && i == 1))
				{
					map[i][j].field = 1;
					map[i][j].beside = map[i-1][j];
					map[i][j].next = 2;
					map[i][j].command.add ( new Purchase(this,i-1,j));
				}
				
				else if((j >= 2 && i == 8) && (j <= 8 && i == 8))
				{
					map[i][j].field = 1;
					map[i][j].beside = map[i+1][j];
					map[i][j].next = 3;
					map[i][j].command.add ( new Purchase(this,i+1,j));
				}
				
				else if(j == 1 && i == 1)
				{
					map[i][j].field = 1;
					map[i][j].next = 2;
				}
				
				else if(j == 9 && i == 1)
				{
					map[i][j].field = 1;
					map[i][j].next = 0;
				}
				
				else if(j == 1 && i == 8)
				{
					map[i][j].field = 1;
					map[i][j].next = 1;
				}
				
				else if(j == 9 && i == 8)
				{
					map[i][j].field = 1;
					map[i][j].next = 3;
				}
				
				else 
				{
					map[i][j].field = 0;
					map[i][j].next = -1;
				}
			}
		
		
		
	}
	public void create_Map(Player[] arr)
	{
		/*
		 * 1. initMap()
		 * 2. set players on the map
		 */
		initMap();
		int i;
		for(i=0;i<arr.length;i++)
		{
			
			switch (arr[i].getNum())
			{
			case 0:
				arr[i].setPostion(1, rnd.nextInt(7)+2);
				break;
			case 1:
				arr[i].setPostion(8, rnd.nextInt(7)+2);
				break;
			case 2:
				arr[i].setPostion(rnd.nextInt(6)+2, 1);
				break;
			case 3:
				arr[i].setPostion(rnd.nextInt(6)+2, 9);
				break;
				
			}
			
			map[arr[i].getX()][arr[i].getY()].container = arr[i] ;
		}
	}
	public BlockIcon getIcon(int x, int y)
	{
		/*
		 * �^�Ǩ��String
		 * ���w x y �y�СA�^�ǸӦ�m�W����T
		 * 
		 * �Ĥ@�Ӧ^�Ǧa�ϤW���H���m�W
		 * �ĤG�Ӧ^�Ǫ�����ɦ�m
		 * 
		 */
		if (x >= 0 && x < 10 &&y >= 0 && y < 11)
		{
			if (map[x][y] != null && map[x][y].container != null)
			{
				Chess temp = map[x][y].container;
				return new BlockIcon(temp.getType(), temp.getIcon(),temp.getColor(),temp.getNum());
			}
			else if (map[x][y].next == -1)
				return new BlockIcon(0,null,null,-1);
			else
				return new BlockIcon(0,null,null,-2);
		}
		else
			return null;//Ū�줣��Ū���a��A�^��null�]�X���~�T��
		
	}
	public void move(Player p)
	{
		
		if(map[p.getX()][p.getY()].next == 0 && map[p.getX()+1][p.getY()].container == null )
		{
			map[p.getX()][p.getY()].container = null ;
			p.setPostion(p.getX()+1,p.getY());
		}
		else if(map[p.getX()][p.getY()].next == 1 && map[p.getX()-1][p.getY()].container == null)
		{
			map[p.getX()][p.getY()].container = null ;
			p.setPostion(p.getX()-1,p.getY());	
		}
		else if(map[p.getX()][p.getY()].next == 2 && map[p.getX()][p.getY()+1].container == null)
		{
			map[p.getX()][p.getY()].container = null ;
			p.setPostion(p.getX(),p.getY()+1);
		}
		else if(map[p.getX()][p.getY()].next == 3 && map[p.getX()][p.getY()-1].container == null)
		{
			map[p.getX()][p.getY()].container = null ;
			p.setPostion(p.getX(),p.getY()-1);
		}
		
		map[p.getX()][p.getY()].container = p ;
			
		
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