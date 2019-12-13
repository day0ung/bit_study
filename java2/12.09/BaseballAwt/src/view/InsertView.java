package view;

import java.awt.BorderLayout;
import java.awt.Button;
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

public class InsertView extends JFrame implements ActionListener{

	Container contentPane;
	
	JRadioButton radio1, radio2;
	ButtonGroup group;
	
	public InsertView() {
		super("InsertView");
				
		JLabel label = new JLabel("추가");
		//label.setBounds(200, 30, 200, 30);
		add(label);
		
		radio1 = new JRadioButton("투수");
		radio1.setSelected(true);
		radio1.addActionListener(this);
		
		radio2 = new JRadioButton("타자");
		radio2.setSelected(false);
		radio2.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.add(label);
		panel.add(radio1);
		panel.add(radio2);
		
		/*
		JPanel botPanel = new JPanel();
		botPanel.setBackground(Color.blue);		
		*/
		PitcherPanel pp = new PitcherPanel(this);
		
		contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(pp, BorderLayout.CENTER);
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.red);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		contentPane = getContentPane();
		contentPane.remove(1);
		if(radio1.isSelected()) {		
			contentPane.add(new PitcherPanel(this), BorderLayout.CENTER);
		}else {	
			contentPane.add(new BatterPanel(this), BorderLayout.CENTER);
		}
		revalidate();
	}
}




