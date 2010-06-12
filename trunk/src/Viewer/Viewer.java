package Viewer;


import javax.swing.JWindow;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

public class Viewer {

	private JWindow jWindow = null;  //  @jve:decl-index=0:visual-constraint="190,47"
	private JPanel jContentPane = null;

	/**
	 * This method initializes jWindow	
	 * 	
	 * @return javax.swing.JWindow	
	 */
	private JWindow getJWindow() {
		if (jWindow == null) {
			jWindow = new JWindow();
			jWindow.setSize(new Dimension(444, 284));
			jWindow.setContentPane(getJContentPane());
		}
		return jWindow;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
		}
		return jContentPane;
	}

}
