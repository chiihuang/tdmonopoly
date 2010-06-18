package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.Initialize;

public class Menu implements ItemListener,ActionListener{
	/*
	 * 從Initialize可以用的Port有：
	 * 
	 * void setPlayer(int, int) ：  第一個int代表是幾號人物
	 * 							       第二個int傳入0代表不啟用，-1是電腦，1是玩家
	 * 
	 * void start() ： 開始遊戲。Initialize那邊會開啟一個新的畫面：GameBoard
	 * 
	 */
	Initialize init;
	JFrame menu;	
	JComboBox combo = null;
	JComboBox[] List;
	String[] select = {"Not-Activate","Player","Computer"};	//JComboBox select Event
	public Menu(Initialize _init)
	{
		
	    	init = _init;
	    	menu = new JFrame("TDRich");
		Container contentPane = menu.getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.setBorder(BorderFactory.createEmptyBorder()); 
		JPanel title = new JPanel();
		JPanel playerPane = new JPanel();
		playerPane.setLayout(new GridLayout(1,4));
		/******* Starting Button *********/
		Icon general =  new ImageIcon(getClass().getResource("pic/me1.jpg"));//普通時候
		Icon rollover =  new ImageIcon(getClass().getResource("pic/me2.jpg"));//滑鼠在上
		Icon press =  new ImageIcon(getClass().getResource("pic/me3.jpg"));//滑鼠點
		JButton starting = new JButton();
		starting.setRolloverEnabled(true);
		starting.addActionListener(this);
		starting.setIcon(general);
		starting.setRolloverIcon(rollover);
		starting.setPressedIcon(press);
		title.add(starting);
		title.setBorder(BorderFactory.createRaisedBevelBorder());
		//創造選擇介面
		JPanel playerBox = null;
		JLabel picture = null;
		List = new JComboBox[4];
		
		for(int i=0;i<4;i++){
			playerBox = new JPanel();
			playerBox.setLayout(new BorderLayout());
			picture = new JLabel(new ImageIcon(getClass().getResource("pic/p"+i+".gif")));//之後換圖片要改
			combo = new JComboBox(select);
			combo.addItemListener(this);
			List[i] = combo;
			playerBox.setBorder(BorderFactory.createTitledBorder("choose "+(i+1)+""));
			playerBox.add(picture,BorderLayout.CENTER);
			playerBox.add(combo,BorderLayout.SOUTH);
			playerPane.add(playerBox);
		}
		//貼上所有東西
		panel.add(title);
		panel.add(playerPane);
		contentPane.add(panel);
		menu.setLocation(200,50);
		menu.pack();//藉由這設定視窗最佳大小
		menu.setVisible(true);
		menu.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){ System.exit(0); }});
		
	}
	public void itemStateChanged(ItemEvent item) {
	    int see=0;
	    if(item.getSource()==List[0]){
		if(item.getItem()=="Not-Activate")
		   see=0; 
		if(item.getItem()=="Player")
		   see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		init.setPlayer(0, see);
	    }
	    if(item.getSource()==List[1]){
		if(item.getItem()=="Not-Activate")
		    see=0; 
		if(item.getItem()=="Player")
		    see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		init.setPlayer(1, see);
	    }
	    if(item.getSource()==List[2]){
		if(item.getItem()=="Not-Activate")
		    see=0; 
		if(item.getItem()=="Player")
		    see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		init.setPlayer(2, see);
	    }
	    if(item.getSource()==List[3]){
		if(item.getItem()=="Not-Activate")
		    see=0; 
		if(item.getItem()=="Player")
		    see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		init.setPlayer(3, see);
	    }			
	}
	public void actionPerformed(ActionEvent e) {
	    if(init.checkPlayer()==0)
		JOptionPane.showMessageDialog(null,"來玩嗎，很有趣唷，選個角色吧!!","Message",3);
	    else if(init.checkPlayer()==(-1))
		JOptionPane.showMessageDialog(null,"找個電腦吧，一個人的世界很孤獨的!!","Message",3);
	    else{			
		init.start();
		menu.setVisible(false);
	    } 
	}
}

	

	 
	

