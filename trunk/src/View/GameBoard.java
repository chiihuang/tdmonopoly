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
	JLabel roll=null;
	JLabel face=new JLabel();
	JLabel sname=new JLabel();
	JLabel shp=new JLabel();
	JLabel swood=new JLabel();
	JLabel dic;
	Container under=monitor.getContentPane();
	Container undera=allinf.getContentPane();//�p�e����
	Container upper=monitor.getLayeredPane();
	JButton dice =new JButton();
	JButton vi =new JButton();
	JButton close=new JButton("close");
	/*
	 * �i�qGame���䮳�쪺Port���G
	 * 
	 * void play() : �o�Ӥ��n�ΡA�o�O��Menu�Ϊ�method
	 * int throwDice(Player) �G �N�{�e���a��i�h��A�i�H���D���a���F�X�B�C
	 * 						         �b�o�̡A�����o�Ӿާ@���ɭԡA�N������v���ٵ�Game()
	 * 						   (��return�Y�i����)
	 * 
	 * �i�qHuman���䮳�쪺Port���G
	 * 
	 * �i�qMap���䮳�쪺Port���G
	 * 
	 * String getIcon(int x, int y) �G�Nxy�ȶǤJ�A�^�Ǹ���ܪ��Ϥ��T���C
	 * 
	 */
	public GameBoard(Map _map, Game _game){
	    
		map = _map;
		game = _game;
		monitor.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){ System.exit(0); }});
		allinf.setUndecorated(true);
		allinf.setSize(720,400);
		close.setLayout(null);
		close.setBounds(320,400,80,40);
		close.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			allinf.setVisible(false);
			vi.setEnabled(true);
		    }
		});
		undera.add(close);
		allinf.setLocation(320,100);
		allinf.setVisible(false);
		
		//�K����
		JLabel back=new JLabel();
		back.setIcon(new ImageIcon(getClass().getResource("bac.jpg")));
		back.setLayout(null);
		back.setBounds(120,180,540,360);
		board.add(back);
		JLabel upg=new JLabel();
		upg.setIcon(new ImageIcon(getClass().getResource("bup.jpg")));
		upg.setLayout(null);
		upg.setBounds(180,120,420,60);
		board.add(upg);
		JLabel downg=new JLabel();
		downg.setIcon(new ImageIcon(getClass().getResource("bdown.jpg")));
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
		
		//�K��l�M����
		int use=0;
		for(int i=0;i<30;i++){
		  if(i==0){//����1
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("b1.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(0,0,180,180);
		      board.add(road[i]);
		  }
		  else if(i==8){//����2
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("b2.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(600,0,180,180);
		      board.add(road[i]);
		  }
		  else if(i==15){//����3
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("b3.jpg")));
		      road[i].setLayout(null);
		      road[i].setBounds(600,540,180,180);
		      board.add(road[i]);	      
		  }
		  else if(i==23){//����4
		      road[i]=new JLabel();
		      road[i].setIcon(new ImageIcon(getClass().getResource("b4.jpg")));
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
		      road[i].setIcon(new ImageIcon(getClass().getResource("road1.jpg")));
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
		      road[i].setIcon(new ImageIcon(getClass().getResource("road2.jpg")));
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
		//�\��l
		dice.setSize(180, 180);
		dice.setIcon(new ImageIcon(getClass().getResource("dice.jpg")));
		dice.setContentAreaFilled(false);
		dice.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			dice.setEnabled(false);
			game.throwDice(hmn);
		    }
		});
		dice.setBorder(BorderFactory.createLineBorder(Color.blue));
		dice.setLayout(null);
		dice.setBounds(780, 540, 180, 180);
		dice.setEnabled(false);
		board.add(dice);
		
		vi.setSize(180, 180);
		vi.setIcon(new ImageIcon(getClass().getResource("viewinf.jpg")));
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

