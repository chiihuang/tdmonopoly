package Model;

import java.util.ArrayList;
import java.util.Random;
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
	Random rnd = new Random();
	Block[][] map = new Block[11][10];
	private void initMap()
	{
		/*
		 * 初使化一個11*10的map
		 * 並設定地形
		 * 	像是在哪一格可以買哪一格的地
		 * 	站在該格移動的下一格是哪裡。
		 * 
		 *-------------------> 
		 * |00222222200 y(j)
		 * |01111111110
		 * |21000000012
		 * |21000000012
		 * |21000000012
		 * |21000000012
		 * |21000000012
		 * |21000000012
		 * |01111111110
		 * |00222222200 
		 * |
		 * x(i)
		 */
		
		int i, j;
		
		for(j = 0; j < 11; j++)
			for(i = 0; i < 10 ; i++)
			{
				map[j][i] = new Block();
				if( 
					((i == 0 && j >= 2) && (i == 0 && j <= 8))
				||	((i == 9 && j >= 2) && (i == 9 && j <= 8))	
				||	((i >= 2 && j == 0) && (i <= 7 && j == 0))
				||	((i >= 2 && j == 10) && (i <= 7 && j == 10)))
					map[j][i].field = 2;
				
				else if((i == 1 && j >= 2) && (i == 1 && j <= 8))
				{
					map[j][i].field = 1;
					map[j][i].beside = map[j][i-1];
					map[j][i].next = 0;
				}
				
				else if((j == 8 && i >= 2) && (j == 8 && i <= 8))
				{
					map[j][i].field = 1;
					map[j][i].beside = map[j][i+1];
					map[j][i].next = 1;
				}
				
				else if((j >= 2 && i == 1) && (j <= 7 && i == 1))
				{
					map[j][i].field = 1;
					map[j][i].beside = map[j-1][i];
					map[j][i].next = 3;
				}
				
				else if((j >= 2 && i == 9) && (j <= 7 && i <= 9))
				{
					map[j][i].field = 1;
					map[j][i].beside = map[j+1][i];
					map[j][i].next = 2;
				}
				
				else if(j == 1 && i == 1)
				{
					map[j][i].field = 1;
					map[j][i].next = 0;
				}
				
				else if(j == 9 && i == 1)
				{
					map[j][i].field = 1;
					map[j][i].next = 2;
				}
				
				else if(j == 1 && i == 8)
				{
					map[j][i].field = 1;
					map[j][i].next = 3;
				}
				
				else if(j == 9 && i == 8)
				{
					map[j][i].field = 1;
					map[j][i].next = 1;
				}
				
				else map[j][i].field = 0;
			}
		
		
		
	}
	public Map(Player[] arr)
	{
		/*
		 * 1. initMap()
		 * 2. set players on the map
		 */
		initMap();
		int i;
		for(i=0;i<arr.length;i++)
		{
			int j = rnd.nextInt(4);
			switch (j)
			{
			case 0:
				arr[i].setPostion(1, rnd.nextInt(8)+1);
				break;
			case 1:
				arr[i].setPostion(9, rnd.nextInt(8)+1);
				break;
			case 2:
				arr[i].setPostion(rnd.nextInt(9)+1, 1);
				break;
			case 3:
				arr[i].setPostion(rnd.nextInt(9)+1, 8);
				break;
				
			}
			
			map[arr[i].getX()][arr[i].getY()].container = arr[i] ;
		}
	}
	public BlockIcon getIcon(int x, int y)
	{
		/*
		 * 回傳兩個String
		 * 給定 x y 座標，回傳該位置上的資訊
		 * 
		 * 第一個回傳地圖上的人物姓名
		 * 第二個回傳物件圖檔位置
		 * 
		 */
		if (x >= 0 && x < map.length &&y >= 0 && y < map[0].length)
		{
			if (map[x][y] != null && map[x][y].container != null)
			{
				Chess temp = map[x][y].container;
				if (temp instanceof Player)
					return new BlockIcon(1, temp.getIcon(),temp.getColor());
				else
					return new BlockIcon(2, temp.getIcon(),temp.getColor());
			}
			else
				return new BlockIcon(0,null,null);
		}
		else
			return null;//讀到不該讀的地方，回傳null跑出錯誤訊息
		
	}
	public void move(Player p)
	{
		map[p.getX()][p.getY()].container = null ;
		
		if(map[p.getX()][p.getY()].next == 0 && map[p.getX()+1][p.getY()].container == null )
			p.setPostion(p.getX()+1,p.getY());
		
		if(map[p.getX()][p.getY()].next == 1 && map[p.getX()-1][p.getY()].container == null)
			p.setPostion(p.getX()-1,p.getY());	
		
		if(map[p.getX()][p.getY()].next == 2 && map[p.getX()][p.getY()+1].container == null)
			p.setPostion(p.getX(),p.getY()+1);
		
		if(map[p.getX()][p.getY()].next == 3 && map[p.getX()][p.getY()-1].container == null)
			p.setPostion(p.getX(),p.getY()-1);
		
		map[p.getX()][p.getY()].container = p ;
			
		
	}
}

class Block
{
	
	/*
	 * 假如這格是行走的地
	 * 指定下一格的方向是哪裡
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
	 * 假如這格是行走的地
	 * 指定可以購買的地是哪一格Block
	 */
	Block beside;
	
	/*
	 * 假如這格是行走的地
	 * command就是用來儲存要執行的動作
	 */
	ArrayList<Action> command = new ArrayList<Action>(0);
	/*
	 * 裝入Player、Tower等等物件的Reference
	 * 不過能使用的只有Chess這個interface限定的功能。
	 */
	Chess container;
}