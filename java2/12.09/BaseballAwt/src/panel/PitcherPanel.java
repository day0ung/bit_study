package panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.Human;
import dto.Pitcher;
import single.Singleton;
import view.InsertView;
import view.MenuView;

public class PitcherPanel extends JPanel implements ActionListener{

	JLabel label[] = new JLabel[6];
	JTextField textField[] = new JTextField[6];
	
	JButton menuBtn, insertBtn;
	
	InsertView iview;
	
	public PitcherPanel(InsertView iview) {
		setLayout(null);
		
		this.iview = iview;
		
		String title[] = { "이름:", "나이:", "신장:", "승:", "패:", "방어율" };
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText( title[i] );
			label[i].setBounds(30, 50 + 40 * i, 100, 30);
			
			textField[i] = new JTextField();
			textField[i].setBounds(180, 50 + 40 * i, 200, 30);
			
			add(label[i]);
			add(textField[i]);
		}
		
		menuBtn = new JButton("메뉴");
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		insertBtn = new JButton("추가");
		insertBtn.setBounds(320, 320, 150, 50);
		insertBtn.addActionListener(this);
		add(insertBtn);
				
		setBounds(0, 0, 640, 450);
		setBackground(Color.green);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuBtn) {
		//	JOptionPane.showMessageDialog(null, "menuBtn");
			iview.dispose();
			new MenuView();
		}
		else if(obj == insertBtn) {
			Singleton s = Singleton.getInstance();	
			Human human = null;
			
			if(textField[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "모두 작성해 주십시오");
				return;
			}
			
			String name = textField[0].getText();
			int age = Integer.parseInt(textField[1].getText());
			double height = Double.parseDouble(textField[2].getText());
			int win = Integer.parseInt(textField[3].getText());
			int lose = Integer.parseInt(textField[4].getText());
			double defence = Double.parseDouble(textField[5].getText());
			
			human = new Pitcher(s.MemNumber, name, age, height, win, lose, defence)	;		
			
			s.map.put(human.getName(), human);
			
			JOptionPane.showMessageDialog(null, "성공적으로 추가하였습니다");
			
			s.MemNumber++;
		}
	}
}






