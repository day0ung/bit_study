package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import panel.BatterPanel;
import panel.PitcherPanel;

public class InsertView extends JFrame implements ActionListener {
	Container contentPane;
	JRadioButton radio1, radio2; //피쳐냐 배터냐 
	ButtonGroup group;
	
	public InsertView() {
		super("InsertView");
		
		
		JLabel label = new JLabel("추가");
		//label.setBounds(200, 30, 200, 30);
		add(label);
		
		//라디오버튼추가
		radio1 = new JRadioButton("투수");
		radio1.setSelected(true);
		radio1.addActionListener(this);
		
		radio2 = new JRadioButton("타자");
		radio2.setSelected(false);
		radio2.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		
		//---컨테인에 넣을 패널선언-----
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.add(label);
		panel.add(radio1);
		panel.add(radio2);
		/*
		JPanel botPanel = new JPanel();
		botPanel.setBackground(Color.blue);
		botPanel.add(label);
		*/
		
		PitcherPanel pp = new PitcherPanel(this);
		
		//컨테이너를 줘서 레이아웃대용으로사용(패널추가한것을 컨테이너에 잡아넣음
		contentPane = getContentPane(); //jframe에만있음
		contentPane.add(panel, BorderLayout.NORTH); //0번재
		contentPane.add(pp, BorderLayout.CENTER); //1번쨰
		
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.red);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		contentPane = getContentPane();
		contentPane.remove(1); //지웠으면채워야함
		if(radio1.isSelected()) {
			//JOptionPane.showMessageDialog(null, "radio1");
			contentPane.add(new PitcherPanel(this), BorderLayout.CENTER);
		}else {
			//JOptionPane.showMessageDialog(null, "radio2"); //넘겨주고 넘겨받고this Picher에서 파라미터값
			contentPane.add(new BatterPanel(this), BorderLayout.CENTER);
		}
		revalidate();
		
	}
}