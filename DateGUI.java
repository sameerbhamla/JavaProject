import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DateGUI extends JFrame{
	static JFrame frame;
	
	public static void main(String[] args) throws IOException{
		createAndShowGUI();
	}
	
	//Create and show GUI
	private static void createAndShowGUI() throws IOException {
		frame = new JFrame();
		frame.setTitle("Dates");
		frame.setSize(300,200);
		frame.setLayout(new GridLayout(1,2));
		createMenu();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	//Create a menu 
	private static void createMenu() {
		JMenuBar menuBar  = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;
		FileMenuHandler fmh  = new FileMenuHandler(frame);
		   
		item = new JMenuItem("Open"); 
		item.addActionListener( fmh );
		fileMenu.add(item);
		fileMenu.addSeparator(); 
		item = new JMenuItem("Quit"); 
		item.addActionListener(fmh);
		fileMenu.add(item);
		frame.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	}
	
}

