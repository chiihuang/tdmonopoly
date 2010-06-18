package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.Initialize;

public class Menu implements ItemListener,ActionListener{
	/*
	 * �qInitialize�i�H�Ϊ�Port���G
	 * 
	 * void setPlayer(int, int) �G  �Ĥ@��int�N��O�X���H��
	 * 							       �ĤG��int�ǤJ0�N���ҥΡA-1�O�q���A1�O���a
	 * 
	 * void start() �G �}�l�C���CInitialize����|�}�Ҥ@�ӷs���e���GGameBoard
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
		Icon general =  new ImageIcon(getClass().getResource("pic/me1.jpg"));//���q�ɭ�
		Icon rollover =  new ImageIcon(getClass().getResource("pic/me2.jpg"));//�ƹ��b�W
		Icon press =  new ImageIcon(getClass().getResource("pic/me3.jpg"));//�ƹ��I
		JButton starting = new JButton();
		starting.setRolloverEnabled(true);
		starting.addActionListener(this);
		starting.setIcon(general);
		starting.setRolloverIcon(rollover);
		starting.setPressedIcon(press);
		title.add(starting);
		title.setBorder(BorderFactory.createRaisedBevelBorder());
		//�гy��ܤ���
		JPanel playerBox = null;
		JLabel picture = null;
		List = new JComboBox[4];
		
		for(int i=0;i<4;i++){
			playerBox = new JPanel();
			playerBox.setLayout(new BorderLayout());
			picture = new JLabel(new ImageIcon(getClass().getResource("pic/p"+i+".gif")));//���ᴫ�Ϥ��n��
			combo = new JComboBox(select);
			combo.addItemListener(this);
			List[i] = combo;
			playerBox.setBorder(BorderFactory.createTitledBorder("choose "+(i+1)+""));
			playerBox.add(picture,BorderLayout.CENTER);
			playerBox.add(combo,BorderLayout.SOUTH);
			playerPane.add(playerBox);
		}
		//�K�W�Ҧ��F��
		panel.add(title);
		panel.add(playerPane);
		contentPane.add(panel);
		menu.setLocation(200,50);
		menu.pack();//�ǥѳo�]�w�����̨Τj�p
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
		JOptionPane.showMessageDialog(null,"�Ӫ��ܡA�ܦ����A��Ө���a!!","Message",3);
	    else if(init.checkPlayer()==(-1))
		JOptionPane.showMessageDialog(null,"��ӹq���a�A�@�ӤH���@�ɫܩt�W��!!","Message",3);
	    else{			
		init.start();
		menu.setVisible(false);
	    } 
	}
}

	

	 
	

