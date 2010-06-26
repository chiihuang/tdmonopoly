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
		 * 初使化一個11*10的map
		 * 並設定地形
		 * 	像是在哪一格可以買哪一格的地
		 * 	站在該格移動的下一格是哪裡。
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
		 * 回傳兩個String
		 * 給定 x y 座標，回傳該位置上的資訊
		 * 
		 * 第一個回傳地圖上的人物姓名
		 * 第二個回傳物件圖檔位置
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