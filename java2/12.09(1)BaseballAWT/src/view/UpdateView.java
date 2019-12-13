package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.Human;
import dto.Pitcher;
import panel.UpdatePitPanel;
import single.Singleton;

public class UpdateView extends JFrame implements ActionListener{
	Container contentPane;
	JTextField textField;
	JButton button;
		
	public UpdateView() {
		super("update View");
		JLabel label = new JLabel("수정");
		JLabel nameLabel = new JLabel("이름: ");
		textField = new JTextField(20);
		button = new JButton("선택");
		button.addActionListener(this);
		/*
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//버튼을클릭했을때 이름을넘겨줌 이름은 텍스트필드가 갖고잇음, 이름을적어줬을때 이름을 찾아줘야함
				Singleton s = Singleton.getInstance();
				Human h = s.map.get(textField.getText()); //휴먼에서 넘어옴
				
				//휴먼이 투수냐 타자냐
				if(h instanceof Pitcher) {
					new UpdatePitPanel(textField.getText());
					//new pitpanel을 contetnpane에 넣어줘야함(updatepanel클래스안에있는)
				}else {
					
				}
				
			}
		});
		*/
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.add(label);
		panel.add(nameLabel);
		panel.add(textField);
		panel.add(button);
		
		JPanel botpanel = new JPanel();
		
		
		contentPane = getContentPane(); //jframe에만있음
		contentPane.add(panel, BorderLayout.NORTH); //0번재
		contentPane.add(botpanel, BorderLayout.CENTER); //1번쨰

		
		setBounds(0, 0, 640, 480);
		setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "actionPerformed");
		Singleton s = Singleton.getInstance();
		Human h = s.map.get(textField.getText()); //휴먼에서 넘어옴
		
		contentPane = getContentPane();
		contentPane.remove(1);
		//휴먼이 투수냐 타자냐
		if(h instanceof Pitcher) {
			contentPane.add(new UpdatePitPanel(textField.getText(), this), BorderLayout.CENTER);
			//new pitpanel을 contetnpane에 넣어줘야함(updatepanel클래스안에있는)
		}else {
			
		}
		revalidate(); //갱신해준다 화면을.. reprint같은것
	}
}