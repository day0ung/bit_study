package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class menuView extends JFrame {
	JTextField IdTextField, PwTextField;
	JButton logBtn,membershipBtn;
	JLabel id,pw;
	public menuView() {
		super("menuView");
		setLayout(null);
		//label부분
		id = new JLabel();
		id.setText("ID");
		id.setBounds(100, 90, 100, 30);
		
		pw = new JLabel();
		pw.setText("PW");
		pw.setBounds(100, 150, 100, 30);
				
		add(id);
		add(pw);
		
		//textfield부분
		IdTextField = new JTextField();
		PwTextField = new JTextField();
		
		IdTextField.setBounds(180, 90, 200, 30);
		PwTextField.setBounds(180, 150, 200, 30);
		add(IdTextField);
		add(PwTextField);
		
		//버튼부분
		logBtn = new JButton("로그인");
		logBtn.setBounds(120, 250, 100, 100);
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj ==logBtn) {
					dispose();
					new logInView();
				}
				
			}
		});
		add(logBtn);
		
		membershipBtn = new JButton("회원가입");
		membershipBtn.setBounds(280, 250, 100, 100);
		membershipBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj == membershipBtn) {
					dispose();
					new MemberShipView();
				}
				
			}
		});
		add(membershipBtn);
		
		setBounds(0, 0, 640, 480);
	
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
}
