package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	JTextField IdTextField, PwTextField;
	JButton logBtn,accountBtn;
	JLabel id,pw;
	
	public LoginView() {
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
		logBtn = new JButton("LogIn");
		logBtn.setBounds(120, 250, 100, 100);
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj ==logBtn) {
					dispose();
				
				}
				
			}
		});
		add(logBtn);
		
		accountBtn = new JButton("회원가입");
		accountBtn.setBounds(280, 250, 100, 100);
		accountBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj == accountBtn) {
					dispose();
					new AccountView();
				}
				
			}
		});
		add(accountBtn);	
		setBounds(0, 0, 640, 480);	
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
