package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Dialog extends Message
{
	String s1;
	String s2;
	JFrame u=null;
	JButton c1;
	JButton c2;
	JPanel o;
	int tmp=0;
	public Dialog(String _message, String choice1, String choice2)
	{
		super(_message);
		s1 = choice1;
		s2 = choice2;
		tmp=0;
		
		u=new JFrame();
		u.setUndecorated(true);
		u.setSize(300,150);
		Container con=u.getContentPane();
		o=new JPanel();
		o.setSize(300, 150);
		c1=new JButton();
		c2=new JButton();
		c1.setSize(150, 150);
		c1.setText(s1);
		c1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			tmp=1;
			u.setVisible(false);
			u.dispose();
		    }
		});
		c1.setLayout(null);
		c1.setBounds(0,0,150,150);
		o.add(c1);
		
		c2.setSize(150, 150);
		c2.setText(s2);
		c2.setLayout(null);
		c2.setBounds(150,0,150,150);
		c2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ev){
			tmp=2;
			u.setVisible(false);
			u.dispose();
		    }
		});	
		o.add(c2);
		o.setLayout(null);
		o.setBounds(0,0,300,150);
		con.add(o);
		u.setLocation(400, 200);
		u.setVisible(true);
		
			
		
		
		
		
	}
	public boolean show()
	{
		while(tmp==0){
		    try{
		    Thread.sleep(100);
		    }catch(InterruptedException e){
		    
		    }	    
	    	}
		if(tmp==1)
		  return true;
		else
		  return false;
		
	}
	
}
