package org.notty.main;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.notty.APPDATA;

public class About {

	private JFrame frmNottyAbout;
	
	public About() {
		initialize();
	}

	private void initialize() {
		frmNottyAbout = new JFrame();
		frmNottyAbout.setTitle("Notty - About");
		frmNottyAbout.setResizable(false);
		frmNottyAbout.setBounds(100, 100, 265, 130);
		frmNottyAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNottyAbout.getContentPane().setLayout(null);
		
		JLabel lblCopyright = new JLabel("Copyright \u00a9 2017 Marcin Siniarski");
		lblCopyright.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblCopyright.setBounds(10, 65, 124, 14);
		frmNottyAbout.getContentPane().add(lblCopyright);
		
		JLabel lblLicensedUnder = new JLabel("Licensed under Generel Public License v3");
		lblLicensedUnder.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblLicensedUnder.setBounds(10, 76, 214, 14);
		frmNottyAbout.getContentPane().add(lblLicensedUnder);
		
		JLabel lblTitle = new JLabel("Notty - Litlle notepad made in Java");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setBounds(10, 0, 239, 14);
		frmNottyAbout.getContentPane().add(lblTitle);
		
		JLabel lblVersion = new JLabel("Version "+APPDATA.APP_VERSION);
		lblVersion.setBounds(10, 21, 124, 14);
		frmNottyAbout.getContentPane().add(lblVersion);
		
		JButton btnGithub = new JButton("GitHub");
		btnGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					try {
						Desktop deskt = Desktop.getDesktop();
						deskt.browse(URI.create("https://github.com/BlackDiamondPL/Notty"));
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnGithub.setBounds(169, 63, 80, 16);
		frmNottyAbout.getContentPane().add(btnGithub);
		frmNottyAbout.setVisible(true);
	}
}
