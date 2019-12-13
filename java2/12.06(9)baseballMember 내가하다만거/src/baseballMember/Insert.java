package baseballMember;


import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
	
public class Insert extends JFrame implements WindowListener{
	String name;
	int age;
	JLabel frontLabel;
	Button menu, addPlayer;
	public Insert() {
		setLayout(null);
		
		frontLabel = new JLabel("선수입력창이다");
		frontLabel.setSize(300, 30);
		frontLabel.setLocation(70, 50);
		frontLabel.setBackground(Color.yellow);
		frontLabel.setOpaque(true);
		frontLabel.setHorizontalAlignment(JLabel.CENTER);
		add(frontLabel);
		
		
		
		menu = new Button();
		menu.setLabel("back to MENU");
		menu.setBounds(70, 540, 100, 30);
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuClass();
				
			}
		});
		add(menu);
		
		addPlayer = new Button();
		addPlayer.setLabel("add Player");
		addPlayer.setBounds(300, 540, 100, 30);
		add(addPlayer);
		
		TextField tf1, tf2, tf3, tf4;
		// a blank text field
		tf1 = new TextField();
		// blank field of 20 columns
		tf2 = new TextField("", 20);
		// predefined text displayed
		tf3 = new TextField("Hello! ");
		// predefined text in 30 columns
		tf4 = new TextField("Hello", 30);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		
//		Label label1 = new Label("레이블 1 입니다");
//		label1.setBackground(new Color(255, 0, 0));
//		label1.setSize(150, 30); //레이블의 폭과 높이
//		label1.setLocation(100,100);
//		add(label1);
		
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(new GridLayout(1, 2));

		
		 
		 
		
		
		setSize(500, 700); 
		setLocation(0, 0); 
		setBackground(Color.white);
		
		setVisible(true);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
