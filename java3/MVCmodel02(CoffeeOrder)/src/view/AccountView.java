package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import singleton.Singleton;

public class AccountView extends JFrame {
	private JTextField idTextF;
	private JTextField passTextF;
	private JTextField nameTextF;
	private JTextField emailTextF;	
	
	private JButton accountBtn;
	private JButton idBtn;	
	
	public AccountView() {
		super("회원가입 페이지");
		
		setLayout(null);		
		
		JLabel loginLabel = new JLabel("회원가입 화면");
		loginLabel.setBounds(100, 10, 120, 15);
		add(loginLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);
		
		idTextF = new JTextField();
		idTextF.setBounds(100, 60, 150, 20);
		add(idTextF);
		idTextF.setColumns(10);
		
		idBtn = new JButton("id");
		idBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				boolean b = s.memCtrl.idCheck( idTextF.getText() );
				if(b) {
					JOptionPane.showMessageDialog(null, "사용할 수 없는 id 입니다");
					idTextF.setText("");
				}else {
					JOptionPane.showMessageDialog(null, idTextF.getText() + "는 사용할 수 있습니다");
				}
				
			}
		});
		idBtn.setBounds(260, 60, 50, 20);
		add(idBtn);
		
		JLabel passLabel = new JLabel("PassWord:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);
		
		passTextF = new JTextField();
		passTextF.setBounds(100, 104, 150, 20);
		add(passTextF);
		
		JLabel nameLabel = new JLabel("이름:");
		nameLabel.setBounds(31, 148, 67, 15);
		add(nameLabel);
		
		nameTextF = new JTextField();
		nameTextF.setBounds(100, 148, 150, 20);
		add(nameTextF);
		
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(31, 192, 67, 15);
		add(emailLabel);
		
		emailTextF = new JTextField();
		emailTextF.setBounds(100, 192, 150, 20);
		add(emailTextF);
		
		accountBtn = new JButton("회원가입");
		accountBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.memCtrl.regiAf(idTextF.getText(), 
						passTextF.getText(), 
						nameTextF.getText(), 
						emailTextF.getText());
		
				dispose();
				
			}
		});
		accountBtn.setBounds(31, 236, 280, 50);
		add(accountBtn);
		
		getContentPane().setBackground(new Color(0, 255, 0));
		setBounds(100, 100, 350, 400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
