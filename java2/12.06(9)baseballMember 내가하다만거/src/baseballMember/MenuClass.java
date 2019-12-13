package baseballMember;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuClass extends JFrame implements WindowListener, ActionListener {
	
	JLabel frontLabel;
	JButton one, two, three, four, five, six;
	JPanel panel;
	
	public MenuClass() {
	super("BaseBall Member");
		
		setLayout(null);
		frontLabel = new JLabel("Menu");
		frontLabel.setSize(300, 30);
		frontLabel.setLocation(70, 50);
		frontLabel.setBackground(Color.yellow);
		frontLabel.setOpaque(true);
		frontLabel.setHorizontalAlignment(JLabel.CENTER);
		add(frontLabel);
		
		
		
		one = new JButton();
		one.setLabel("선수추가");
		one.setBounds(70, 90, 200, 30);
		one.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Insert();
				
			}
		});
		add(one);
		
		two = new JButton();
		two.setLabel("선수삭제");
		two.setBounds(70, 180, 200, 30);
		add(two);
		
		three = new JButton();
		three.setLabel("선수검색");
		three.setBounds(70, 270, 200, 30);
		add(three);
		
		four = new JButton();
		four.setLabel("선수 수정");
		four.setBounds(70, 360, 200, 30);
		add(four);
		
		five = new JButton();
		five.setLabel("선수출력");
		five.setBounds(70, 450, 200, 30);
		add(five);
		
		six = new JButton();
		six.setLabel("파일저장");
		six.setBounds(70, 540, 200, 30);
		
		
	
	
		
		setSize(640, 700);	// 윈도우의 크기 (폭, 높이)
		setLocation(100, 0);	// 윈도우 실행위치
		setBackground(Color.gray);
		setVisible(true);	// 윈도우 시각화	
		
		addWindowListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}



}
