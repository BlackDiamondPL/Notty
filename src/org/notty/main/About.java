package org.notty.main;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class About {

	private JFrame frame;
	
	public About() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 240, 160);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new SpringLayout());
		frame.setVisible(true);
	}
}
