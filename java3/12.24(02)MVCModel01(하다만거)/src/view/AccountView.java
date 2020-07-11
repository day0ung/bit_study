package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javabean.MemberDao;

public class AccountView extends JFrame  {
	JLabel label[] = new JLabel[4];
	JTextField IDtextF, PWTextF, NameTextF, EmailTextF;
	JButton accountBtn, idBtn;

	public AccountView() {
		setLayout(null);

		String title[] = { "ID", "PW", "NAME", "EMail" };

		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText(title[i]);
			label[i].setBounds(100, 50 + 40 * i, 100, 30);

			add(label[i]);
		}

		IDtextF = new JTextField();
		IDtextF.setBounds(180, 50, 200, 30);
		IDtextF.setColumns(10);

		PWTextF = new JTextField();
		PWTextF.setBounds(180, 90, 200, 30);
		PWTextF.setColumns(10);

		NameTextF = new JTextField();
		NameTextF.setBounds(180, 130, 200, 30);
		NameTextF.setColumns(10);

		EmailTextF = new JTextField();
		EmailTextF.setBounds(180, 170, 200, 30);

		add(IDtextF);
		add(PWTextF);
		add(NameTextF);
		add(EmailTextF);

		accountBtn = new JButton("회원가입");

		accountBtn.setBounds(200, 250, 150, 50);
		accountBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		add(accountBtn);

		idBtn = new JButton("ID");
		idBtn.setBounds(400, 50, 100, 30);
		idBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(idBtn);

		setBounds(0, 0, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "버튼 클릭");	
		// JButton;
		// dao부분의 getintanec함수를 가져와야함
		JButton btn = (JButton) e.getSource();
		String btnTitle = btn.getLabel();

		MemberDao dao = MemberDao.getInstance();

		if (btnTitle.equals("ID")) {
			//JOptionPane.showMessageDialog(null, "id 버튼");
			
			// 빈칸 첵크 //trim 유저가 스페이스바를 입력하니까
			if (IDtextF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "id를 입력해 주십시오");
				return;
			}

			String id = IDtextF.getText().trim();
			// b에는 결과값이 나옴 true/false인지
			boolean b = dao.getId(id);
			if (b) { // true데이터가 있는 것임
				JOptionPane.showMessageDialog(null, "사용할 수 없는 id입니다");
				IDtextF.setText("");
			} else { // false
				JOptionPane.showMessageDialog(null, IDtextF.getText() + "는 사용하실 수 있습니다");
			}
			
		}else if(btnTitle.equals("회원가입")) {
			
			if( IDtextF.getText().equals("") ||
				PWTextF.getText().equals("")||
				NameTextF.getText().equals("")||
				EmailTextF.getText().equals("")) {
				
			}
			
			
		}

	}
	*/
}
