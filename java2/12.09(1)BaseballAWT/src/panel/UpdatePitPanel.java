package panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.Human;
import dto.Pitcher;
import single.Singleton;
import view.MenuView;
import view.UpdateView;

public class UpdatePitPanel extends JPanel implements ActionListener{

	JLabel label[] = new JLabel[3];

	JTextField textField[] = new JTextField[3];

	JButton menuBtn, updateBtn;
	String name;
	UpdateView uview;
	Pitcher pit;
	
	
	//업데이트뷰 넘겨받기 위해서 this해ㅑㅇ함
	public UpdatePitPanel(String name , UpdateView uview) { // 이름을입력했을때 넘겨받는부분 String name (UpdateView 에서 생성되서 넘어옴
		this.name = name;
		this.uview = uview;
		Singleton s = Singleton.getInstance();
		pit = (Pitcher)s.map.get(name);
		
		
		setLayout(null);
		JOptionPane.showMessageDialog(null, "UpdatePitPanel");

		String title[] = { "승:", "패:", "방어율" };
		
		
		//데이타 넣어주기 //승은4, 패5, 방어율 6 번지수
		String data[] = {pit.getWin() +"", pit.getLose()+ "", pit.getDefence()+""}; //숫자니까 에러남 +""해줘야함
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText(title[i]);
			label[i].setBounds(30, 50 + 40 * i, 100, 30);

			textField[i] = new JTextField();
			textField[i].setText(data[i]);
			textField[i].setBounds(180, 50 + 40 * i, 200, 30);

			add(label[i]);
			add(textField[i]);
		}
		
		menuBtn = new JButton("메뉴");
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(320, 320, 150, 50);
		updateBtn.addActionListener(this);
		add(updateBtn);

		setBounds(0, 0, 640, 450);
		setBackground(Color.green);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(menuBtn == (Object)e.getSource()) {
			uview.dispose();
			new MenuView();
		}
				
		
		if(updateBtn == (Object)e.getSource()) {
			//JOptionPane.showMessageDialog(null, "수정버튼");
			pit.setWin(Integer.parseInt(textField[0].getText()));
			pit.setLose(Integer.parseInt(textField[1].getText()));
			pit.setDefence(Double.parseDouble(textField[2].getText()));
			
			Singleton s = Singleton.getInstance();
			s.map.put(name, pit);
			
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
		}
		
	}
}
