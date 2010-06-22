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
	JFrame frame;
	
	JComboBox combo = null;
	JComboBox[] List;
	String[] select = {"Not-Activate","Player","Computer"};	//JComboBox select Event
	public Menu(Initialize _init){
		
	    	init = _init;
	    	frame = new JFrame("TDRich");
	    	frame.setSize(980, 680);
		Container under = frame.getContentPane();
		Container upper = frame.getLayeredPane();
		JPanel background = new JPanel();
		background.setLayout(new GridLayout(2,1));
		//�W�b��
		JPanel up = new JPanel();
		JLabel back=new JLabel();
		back.setIcon( new ImageIcon(getClass().getResource("pic/back.jpg")));
		up.add(back);
		
		//�U�b��
		JPanel down = new JPanel();
		down.setLayout(new GridLayout(1,4));
		JPanel player = null;
		JLabel picture = null;
		List = new JComboBox[4];
		
		for(int i=0;i<4;i++){
		     	player = new JPanel();
		     	player.setLayout(new BorderLayout());
			picture = new JLabel(new ImageIcon(getClass().getResource("pic/p"+i+".gif")));//���ᴫ�Ϥ��n��
			combo = new JComboBox(select);
			combo.addItemListener(this);
			List[i] = combo;
			player.setBorder(BorderFactory.createTitledBorder("choose "+(i+1)+""));
			player.add(picture,BorderLayout.CENTER);
			player.add(combo,BorderLayout.SOUTH);
			down.add(player);
		}
		background.add(up);
		background.add(down);
		under.add(background);
		
		JButton start=new JButton("start");
		start.addActionListener(this);
		start.setLayout(null);
		start.setBounds(500,180,80,20);
		upper.add(start);
		
		JButton exit=new JButton("exit");
		end ear=new end();
		exit.addActionListener(ear);
		exit.setLayout(null);
		exit.setBounds(500,230,80,20);
		upper.add(exit);
		
		frame.setLocation(200,0);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){ System.exit(0); }});
		
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
		JOptionPane.showMessageDialog(null,"�Ӫ��ܡA�ܦ����A��Ө���a!!","�p��ĳ",3);
	    else if(init.checkPlayer()==(-1))
		JOptionPane.showMessageDialog(null,"��ӹq���a�A�@�ӤH���@�ɫܩt�W��!!","�p��ĳ",3);
	    else{
		frame.setVisible(false);			
		init.start();
	    } 
	}
}
class end implements ActionListener {
    public void actionPerformed(ActionEvent e){
	System.exit(0);
    }
}
 

	

	 
	

