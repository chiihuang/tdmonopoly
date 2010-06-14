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
	int rem[][]=new int[4][2];
	String[] select = {"Not-Activate","Player","Computer"};	//JComboBox select Event
	public Menu(Initialize _init)
	{
		
	    	init = _init;
	    	for(int i=0;i<4;i++){
	    	    rem[i][0]=i;
	    	}
		menu = new JFrame("TDRich");
		Container contentPane = menu.getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.setBorder(BorderFactory.createTitledBorder("-TDRich-")); 
		JPanel title = new JPanel();
		JPanel playerPane = new JPanel();
		playerPane.setLayout(new GridLayout(1,3));
		/******* Starting Button *********/
		Icon press =  new ImageIcon(getClass().getResource("picture/12345.jpg"));//圖片可以再改
		Icon rollover =  new ImageIcon(getClass().getResource("picture/1234.jpg"));//這方法可以用圖片大小改變框架
		Icon general =  new ImageIcon(getClass().getResource("picture/123.jpg"));
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
			picture = new JLabel(new ImageIcon(getClass().getResource("picture/"+0+".jpg")));//之後換圖片要改
			combo = new JComboBox(select);
			combo.addItemListener(this);
			List[i] = combo;
			playerBox.setBorder(BorderFactory.createTitledBorder("-choose"+(i+1)+"-"));
			playerBox.add(picture,BorderLayout.CENTER);
			playerBox.add(combo,BorderLayout.SOUTH);
			playerPane.add(playerBox);
		}
		//貼上所有東西
		panel.add(title);
		panel.add(playerPane);
		contentPane.add(panel);
		menu.setLocation(200,50);
		menu.pack();
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
		rem[0][1]=see;
	    }
	    if(item.getSource()==List[1]){
		if(item.getItem()=="Not-Activate")
		    see=0; 
		if(item.getItem()=="Player")
		    see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		rem[1][1]=see;
	    }
	    if(item.getSource()==List[2]){
		if(item.getItem()=="Not-Activate")
		    see=0; 
		if(item.getItem()=="Player")
		    see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		rem[2][1]=see;
	    }
	    if(item.getSource()==List[3]){
		if(item.getItem()=="Not-Activate")
		    see=0; 
		if(item.getItem()=="Player")
		    see=1; 
		if(item.getItem()=="Computer")
		    see=(-1); 
		rem[3][1]=see;
	    }			
	}
	public void actionPerformed(ActionEvent e) {
	    int playercount=0;
	    int computercount=0;
	    for(int i=0;i<4;i++){
		if(rem[i][1]==1)
		    playercount++;
		else if(rem[i][1]==(-1))
		    computercount++;
		
	    }
	    if(playercount == 0 ){//至少要有玩家
		JOptionPane.showMessageDialog(null,"來玩嗎，很有趣唷，選個角色和電腦吧!!","Message",1);
	    }
	    else if(playercount==1 && computercount==0){//玩家要搭配電腦
		JOptionPane.showMessageDialog(null,"找個電腦吧，一個人的世界很孤獨的!!","Message",1);
	    }
	    else{
		for(int i=0;i<4;i++){
			init.setPlayer(rem[i][0], rem[i][1]);
						
		}
		init.start();
		menu.setVisible(false);
	    }
	    
	    
	}
	
}

	

	 
	

