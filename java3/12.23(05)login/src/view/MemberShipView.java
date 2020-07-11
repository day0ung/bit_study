package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MemberShipView extends JFrame implements ActionListener{
	JLabel label[] = new JLabel[4];
	JTextField testField[] = new JTextField[4];
	JButton menuBtn;
	
	public MemberShipView() {
		setLayout(null);
		
		String title[] = {"ID", "PW", "NAME", "EMail"};
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText(title[i]);
			label[i].setBounds(30, 50 + 40*i,100,30 );
			
			testField[i] = new JTextField();
			testField[i].setBounds(180, 50 + 40*i, 200, 30);
			
			add(label[i]);
			add(testField[i]);
		}
		
		menuBtn = new JButton();
		
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == menuBtn) {
			dispose();
			
		}
		
	}
}
