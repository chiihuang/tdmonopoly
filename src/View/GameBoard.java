package View;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Map;
import Model.Game;
import Model.Player;

public class GameBoard{
	Map map;
	Game game;
	Player hmn;
	JFrame monitor=new JFrame();
	JFrame allinf=new JFrame();
	JPanel board =new JPanel();
	JPanel land[]=new JPanel[30];
	JLabel road[]=new JLabel[30];
	JLabel upland[]=new JLabel[30];
	JLabel user[]=new JLabel[4];//畫地圖用
	Player playerbox[]=null;
	JLabel roll=null;
	JLabel face=new JLabel();
	JLabel sname=new JLabel();
	JLabel shp=new JLabel();
	JLabel swood=new JLabel();
	JLabel dic;
	Container under=monitor.getContentPane();
	Container undera=allinf.getContentPane();//小畫面用
	Container upper=monitor.getLayeredPane();
	JButton dice =new JButton();
	JButton vi =new JButton();
	JButton close=new JButton("感謝使用");//小畫面用
	int flag=0;
	
	public GameBoard(Map _map, Game _game){
	    
		map = _map;
		game = _game;
		monitor.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){ System.exit(0); }});
		allinf.setUndecorated(true);
		allinf.setSize(300,200);
		close.setLayout(null);
		close.setBounds(0,0,80,40);
		close.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			allinf.setVisible(false);
			vi.setEnabled(true);
		    }
		});
		undera.add(close);
		allinf.setLocation(534,250);
		allinf.setVisible(false);
		
		//貼中心
		JLabel back=new JLabel();
		back.setIcon(new ImageIcon(getClass().getResource("pic/bac.jpg")));
		back.setLayout(null);
		back.setBounds(120,180,540,360);
		board.add(back);
		JLabel upg=new JLabel();
		upg.setIcon(new ImageIcon(getClass().getResource("pic/bup.jpg")));
		upg.setLayout(null);
		upg.setBounds(180,120,420,60);
		board.add(upg);
		JLabel downg=new JLabel();
		downg.setIcon(new ImageIcon(getClass().getResource("pic/bdown.jpg")));
		downg.setLayout(null);
		downg.setBounds(180,540,420,60);
		board.add(downg);
		face.setBackground(Color.white);
		face.setLayout(null);
		face.setBorder(BorderFactory.createLineBorder(Color.black));
		face.setBounds(780,0,180,180);
		board.add(face);
			
		sname.setText("  Name:");
		sname.setLayout(null);
		sname.setBounds(780,180,180,60);
		board.add(sname);
		
		shp.setText("  HP:");
		shp.setLayout(null);
		shp.setBounds(780,240,180,60);
		board.add(shp);
		
		swood.setText("  wood:");
		swood.setLayout(null);
		swood.setBounds(780,300,180,60);
		board.add(swood);
		
		//貼格子和馬路
		int use=0;
		for(int i=0;i<30;i++){
		  if(i==0){//角落1
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("pic/b1.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(0,0,180,180);
		      board.add(road[i]);
		  }
		  else if(i==8){//角落2
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("pic/b2.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(600,0,180,180);
		      board.add(road[i]);
		  }
		  else if(i==15){//角落3
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("pic/b3.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(600,540,180,180);
		      board.add(road[i]);	      
		  }
		  else if(i==23){//角落4
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("pic/b4.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(0,540,180,180);
		      board.add(road[i]);
		  }
		  else if(i>=1&&i<=7||i>=16&&i<=22){
		      land[i]=new JPanel();
		      road[i]=new JLabel();
		      land[i].setBorder(BorderFactory.createLineBorder(Color.black));
		      land[i].setLayout(null);
		      land[i].setBackground(Color.LIGHT_GRAY);
		      road[i].setIcon(new ImageIcon(getClass().getResource("pic/road1.jpg")));
		      road[i].setLayout(null);
		      if(i>=1&&i<=7){
			  land[i].setBounds((120+60*i),0,60,60);
		          road[i].setBounds((120+60*i),60,60,60);
		      }
		      else{
			  use=i-16;
			  land[i].setBounds((540-(60*use)),660,60,60);
			  road[i].setBounds((540-(60*use)),600,60,60);
		      }
		      board.add(land[i]);
		      board.add(road[i]);	      
		  }
		  else if(i>=9&&i<=14||i>=24&&i<=29){
		      land[i]=new JPanel();
		      road[i]=new JLabel();
		      land[i].setBorder(BorderFactory.createLineBorder(Color.black));
		      land[i].setLayout(null);
		      land[i].setBackground(Color.LIGHT_GRAY);
		      road[i].setIcon(new ImageIcon(getClass().getResource("pic/road2.jpg")));
		      road[i].setLayout(null);
		      if(i>=9&&i<=14){
			  use=i-9;
			  land[i].setBounds(720,(180+60*use),60,60);
		          road[i].setBounds(660,(180+60*use),60,60);
		      }
		      else{
			  use=i-24;
			  land[i].setBounds(0,(480-60*use),60,60);
			  road[i].setBounds(60,(480-60*use),60,60);
		      }
		      board.add(land[i]);
		      board.add(road[i]);	      
		  }
		}
		//擺骰子
		dice.setSize(180, 180);
		dice.setIcon(new ImageIcon(getClass().getResource("pic/dice.jpg")));
		dice.setContentAreaFilled(false);
		dice.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			dice.setEnabled(false);
			flag=1;
			game.throwDice(hmn);
			
		    }
		});
		dice.setBorder(BorderFactory.createLineBorder(Color.blue));
		dice.setLayout(null);
		dice.setBounds(780, 540, 180, 180);
		dice.setEnabled(false);
		board.add(dice);
		
		vi.setSize(180, 180);
		vi.setIcon(new ImageIcon(getClass().getResource("pic/viewinf.jpg")));
		vi.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			vi.setEnabled(false);
			allinf.setVisible(true);
		    }
		});
		vi.setBorder(BorderFactory.createLineBorder(Color.black));
		vi.setLayout(null);
		vi.setBounds(780, 360, 180, 180);
		board.add(vi);
			
		board.setLayout(null);
		board.setBounds(0,0,960,720);
		under.add(board);
		monitor.setSize(968,750);
		monitor.setLocation(200,0);
		monitor.setVisible(true);		
	}
	
	public void setPerson(Player _hmn)
	{
		hmn = _hmn;
	}
	public void show(){
	    upper.removeAll();
	    playerbox=game.getplayer();
	    dice.setEnabled(true);
	    flag=0;
	    face.setIcon(new ImageIcon(getClass().getResource("pic/"+hmn.getIcon()+".gif")));
	    
	    sname.setText(hmn.getIcon());
	    String ua=" HP:"+hmn.getHP();
	    shp.setText(ua);
	    String v=" wood:"+hmn.getWood();
	    swood.setText(v);
	    
	    int i=0,j=0,tmp=0,pc=0,use=0;
	    
	    for(int u=0;u<30;u++){
		if(u!=0&&u!=8&&u!=15&&u!=23){
		    land[u].setBackground(Color.LIGHT_GRAY);
		}
	    }
	    for(i=0;i<10;i++)
		for(j=0;j<11;j++){
		    if(map.getIcon(i, j).type!=0){
			if(map.getIcon(i, j).type==2){
		    		if(i==0&&(j>=2&&j<=8)){
		    		    tmp=j-1;
		    		    land[tmp].setBackground(map.getIcon(i, j).color);//////////////////
		    		    upland[tmp]=new JLabel();
		    		    upland[tmp].setLayout(null);
		    		    upland[tmp].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+".gif")));
		    		    upland[tmp].setBounds((120+60*tmp),0,60,60);
		    		    /////////////////
		    		    upper.add(upland[tmp]);		    	    
		    		}
		    		else if(i==9&&(j>=2&&j<=8)){
		    		    tmp=24-j;
		    		    land[tmp].setBackground(map.getIcon(i, j).color);//////////////////
		    		    upland[tmp]=new JLabel();
		    		    upland[tmp].setLayout(null);
		    		    use=tmp-16;
		    		    upland[tmp].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+".gif")));
		    		    upland[tmp].setBounds((540-(60*use)),660,60,60);
		    		    /////////////////
		    		    upper.add(upland[tmp]);
		    		}
		    		else if(j==0&&(i>=2&&i<=7)){
		    		    tmp=31-i;
		    		    land[tmp].setBackground(map.getIcon(i, j).color);//////////////////
		    		    upland[tmp]=new JLabel();
		    		    upland[tmp].setLayout(null);
		    		    use=tmp-24;
		    		    upland[tmp].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+".gif")));
		    		    upland[tmp].setBounds(0,(480-60*use),60,60);
		    		    /////////////////
		    		    upper.add(upland[tmp]);
		    	    
		    		}
		    		else if(j==10&&(i>=2&&i<=7)){
		    		    tmp=i+7;
		    		    land[tmp].setBackground(map.getIcon(i, j).color);//////////////////
		    		    upland[tmp]=new JLabel();
		    		    upland[tmp].setLayout(null);
		    		    use=tmp-9;
		    		    upland[tmp].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+".gif")));
		    		    upland[tmp].setBounds(720,(180+60*use),60,60);
		    		    /////////////////
		    		    upper.add(upland[tmp]);
		    		}
			}
			else if(map.getIcon(i, j).type==1){
			
		    		if(i==1&&j==1){
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"1.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds(60,60,60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    		}
		    		else if(i==1&&j==9){
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"1.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds(660,60,60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    		}
		    		else if(i==8&&j==1){
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"3.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds(60,600,60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    	    
		    		}
		    		else if(i==8&&j==9){
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"3.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds(660,600,60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    		}
		    		else if(i==1&&(j>=2&&j<=8)){
		    		    tmp=i-1;
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"1.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds((120+60*i),60,60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    		}
		    		else if(i==8&&(j>=2&&j<=8)){
		    		    tmp=24-j;
		    		    use=tmp-16;
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"3.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds((540-(60*use)),600,60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    		}
		    		else if(j==1&&(i>=2&&i<=7)){
		    		    tmp=31-i;
		    		    use=tmp-24;
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"4.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds(60,(480-60*use),60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    	    
		    		}
		    		else if(j==9&&(i>=2&&i<=7)){
		    		    tmp=i+7;
		    		    use=tmp-9;
		    		    user[pc]=new JLabel();
		    		    user[pc].setIcon(new ImageIcon(getClass().getResource("pic/"+map.getIcon(i, j).icon+"2.gif")));/////////
		    		    user[pc].setLayout(null);
		    		    user[pc].setBounds(660,(180+60*use),60,60);
		    		    upper.add(user[pc]);
		    		    pc++;
		    		}
			}		    
		} 
	    }
	    monitor.repaint();	    
	}
	public void showResult()
	{
		/*
		 * 將遊戲結果show出來
		 */
	}
	public void stop(){
	    while(flag==0){
		try{
		    Thread.sleep(100);
		    }catch(InterruptedException e){
		    
		    }
	    }
	    return;
	    
	}
	
}

