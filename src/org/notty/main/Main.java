package org.notty.main;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.*;
//import java.io.File;
//import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.notty.io.FileIO;

public class Main {

	private JFrame frmNpad;
	private FileIO fIO = new FileIO();
	private JFileChooser chooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmNpad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNpad = new JFrame();
		frmNpad.setTitle("NPad");
		frmNpad.setBounds(100, 100, 450, 300);
		frmNpad.setMinimumSize(new Dimension(500,500));
		frmNpad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNpad.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar mnBar = new JMenuBar();
		frmNpad.setJMenuBar(mnBar);
		
		JMenu mnFile = new JMenu("File");
		mnBar.add(mnFile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmNpad.getContentPane().add(scrollPane);
		
		JTextArea mainTextArea = new JTextArea();
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setLineWrap(true);
		scrollPane.setViewportView(mainTextArea);
		
		JMenuItem mntmSaveas = new JMenuItem("Save as...");
		mntmSaveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooser.showSaveDialog(null);
				APPDATA.opnFile = chooser.getSelectedFile();
				chooser.setCurrentDirectory(APPDATA.opnFile.getParentFile());
				APPDATA.currentFile= APPDATA.opnFile.getAbsolutePath();
				frmNpad.setTitle("NPad - "+APPDATA.currentFile);
				fIO.writeFile(APPDATA.opnFile, mainTextArea.getText());
			}
		});
		mnFile.add(mntmSaveas);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = chooser.showOpenDialog(null);
				APPDATA.opnFile = chooser.getSelectedFile();
				if(option == JFileChooser.APPROVE_OPTION) {
					chooser.setCurrentDirectory(APPDATA.opnFile.getParentFile());
					APPDATA.currentFile= APPDATA.opnFile.getAbsolutePath();
					APPDATA.currentFileCtn= fIO.readFile(APPDATA.currentFile);
					mainTextArea.setText("");
					for(int i =0; i<APPDATA.currentFileCtn.size();i++) {
						mainTextArea.append(APPDATA.currentFileCtn.get(i));
						mainTextArea.append("\n");
					}
					frmNpad.setTitle("NPad - "+APPDATA.currentFile);
				}
				APPDATA.currentFileCtn = null;
			}
		});
		mnFile.add(mntmOpen);
		
		JMenu mnEditor = new JMenu("Editor");
		mnBar.add(mnEditor);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new About();
			}
		});
		mnEditor.add(mntmAbout);
	}
}
