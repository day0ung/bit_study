package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuView extends JFrame implements ActionListener{
	
	JButton button[];
	
	public MenuView() {
		super("MenuView");
		
		setLayout(null); //레이아웃을 그리드로하고 그안에 패널을 null로잡으면됨 둘중하나는 써야함
		
		JLabel label = new JLabel("메뉴");
		label.setBounds(200, 30, 200, 30);
		add(label);
		//버튼은 추가, 삭제, 검색, 수정, 모두출력이 있어야함
		String title[] = {"선수추가", "선수삭제", "선수검색", "선수수정", "모두출력", "파일저장"};
		button = new JButton[6];
		
		for (int i = 0; i < title.length; i++) {
			button[i] = new JButton();
			button[i].setLabel(title[i]); //구버전이라서 줄그어짐
			button[i].setBounds(50, 80 + 60*i, 150, 50);
			button[i].addActionListener(this);
			add(button[i]);
		}
 
		
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.gray);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj ==button[0]) {
//			JOptionPane.showMessageDialog(null, "추가");
			new InsertView();
			
		}else if(obj ==button[1]) {
			
		}else if(obj ==button[2]) {
			
		}else if(obj ==button[3]) {
			new UpdateView();
		}else if(obj ==button[4]) {
			new AllprintView();
		}else if(obj ==button[5]) {
			
		}
		this.dispose();
	}
}
